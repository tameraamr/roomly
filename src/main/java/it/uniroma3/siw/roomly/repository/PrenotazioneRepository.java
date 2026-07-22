package it.uniroma3.siw.roomly.repository;
import it.uniroma3.siw.roomly.model.Aula;
import it.uniroma3.siw.roomly.model.Prenotazione;
import it.uniroma3.siw.roomly.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByAula(Aula aula);
    List<Prenotazione> findByUtente(Utente utente);
}