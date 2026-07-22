package it.uniroma3.siw.roomly.repository;
import it.uniroma3.siw.roomly.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);
}