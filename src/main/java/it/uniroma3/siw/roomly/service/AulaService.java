package it.uniroma3.siw.roomly.service;
import it.uniroma3.siw.roomly.model.Aula;
import it.uniroma3.siw.roomly.model.Sede;
import it.uniroma3.siw.roomly.repository.AulaRepository;
import it.uniroma3.siw.roomly.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulaService {
    @Autowired private AulaRepository aulaRepository;
    @Autowired private SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    public List<Aula> getAllAuleOrdinate() { return aulaRepository.findAllByOrderByNomeAsc(); }

    @Transactional(readOnly = true)
    public Aula getAulaById(Long id) { return aulaRepository.findById(id).orElseThrow(); }

    @Transactional
    public Aula creaAula(String nome, Integer capienza, String dotazioni, Long idSede) {
        Sede sede = sedeRepository.findById(idSede).orElseThrow();
        Aula aula = new Aula();
        aula.setNome(nome);
        aula.setCapienza(capienza);
        aula.setDotazioni(dotazioni);
        aula.setSede(sede);
        return aulaRepository.save(aula);
    }

    @Transactional
    public void eliminaAula(Long id) {
        Aula aula = aulaRepository.findById(id).orElseThrow();
        aulaRepository.delete(aula);
    }

    @Transactional(readOnly = true)
    public List<Aula> getAuleBySede(Long idSede) {
        return aulaRepository.findAll().stream()
                .filter(a -> a.getSede().getId().equals(idSede))
                .collect(Collectors.toList());
    }
}