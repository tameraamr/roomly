package it.uniroma3.siw.roomly.repository;
import it.uniroma3.siw.roomly.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findAllByOrderByNomeAsc();
}