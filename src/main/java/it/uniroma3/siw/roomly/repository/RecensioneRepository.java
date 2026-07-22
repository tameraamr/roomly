package it.uniroma3.siw.roomly.repository;
import it.uniroma3.siw.roomly.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByAulaId(Long aulaId);
}