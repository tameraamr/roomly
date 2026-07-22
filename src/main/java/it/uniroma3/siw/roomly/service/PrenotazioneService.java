package it.uniroma3.siw.roomly.service;
import it.uniroma3.siw.roomly.model.*;
import it.uniroma3.siw.roomly.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired private PrenotazioneRepository prenotazioneRepository;
    @Autowired private AulaRepository aulaRepository;
    @Autowired private UtenteRepository utenteRepository;

    @Transactional
    public Prenotazione creaPrenotazione(Long idAula, String username, LocalDateTime dataInizio, LocalDateTime dataFine) {
        if (!dataFine.isAfter(dataInizio)) {
            throw new IllegalArgumentException("La data di fine deve essere successiva alla data di inizio");
        }
        Aula aula = aulaRepository.findById(idAula).orElseThrow();
        Utente utente = utenteRepository.findByUsername(username).orElseThrow();

        // controllo sovrapposizione con prenotazioni esistenti sulla stessa aula
        List<Prenotazione> esistenti = prenotazioneRepository.findByAula(aula);
        for (Prenotazione p : esistenti) {
            if (p.getStato() == StatoPrenotazione.CONFERMATA
                    && dataInizio.isBefore(p.getDataFine()) && dataFine.isAfter(p.getDataInizio())) {
                throw new IllegalArgumentException("L'aula è già prenotata in questo intervallo orario");
            }
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setAula(aula);
        prenotazione.setUtente(utente);
        prenotazione.setDataInizio(dataInizio);
        prenotazione.setDataFine(dataFine);
        prenotazione.setStato(StatoPrenotazione.CONFERMATA);
        return prenotazioneRepository.save(prenotazione);
    }

    @Transactional
    public void annullaPrenotazione(Long idPrenotazione, String username) {
        Prenotazione p = prenotazioneRepository.findById(idPrenotazione).orElseThrow();
        if (!p.getUtente().getUsername().equals(username)) {
            throw new IllegalArgumentException("Non puoi annullare una prenotazione di un altro utente");
        }
        p.setStato(StatoPrenotazione.ANNULLATA);
        prenotazioneRepository.save(p);
    }

    @Transactional(readOnly = true)
    public List<Prenotazione> getPrenotazioniByUtente(String username) {
        Utente utente = utenteRepository.findByUsername(username).orElseThrow();
        return prenotazioneRepository.findByUtente(utente);
    }

    @Transactional(readOnly = true)
    public List<Prenotazione> getPrenotazioniByAula(Long idAula) {
        Aula aula = aulaRepository.findById(idAula).orElseThrow();
        return prenotazioneRepository.findByAula(aula);
    }
}