package it.uniroma3.siw.roomly.service;
import it.uniroma3.siw.roomly.model.*;
import it.uniroma3.siw.roomly.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class RecensioneService {
    @Autowired private RecensioneRepository recensioneRepository;
    @Autowired private AulaRepository aulaRepository;
    @Autowired private UtenteRepository utenteRepository;

    @Transactional(readOnly = true)
    public List<Recensione> getRecensioniByAula(Long idAula) { return recensioneRepository.findByAulaId(idAula); }

    @Transactional
    public Recensione aggiungiRecensione(Long idAula, String username, String testo, Integer voto) {
        Aula aula = aulaRepository.findById(idAula).orElseThrow();
        Utente utente = utenteRepository.findByUsername(username).orElseThrow();
        Recensione r = new Recensione();
        r.setAula(aula);
        r.setUtente(utente);
        r.setTesto(testo);
        r.setVoto(voto);
        r.setData(new Date());
        return recensioneRepository.save(r);
    }
}