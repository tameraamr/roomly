package it.uniroma3.siw.roomly.service;
import it.uniroma3.siw.roomly.model.Sede;
import it.uniroma3.siw.roomly.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SedeService {
    @Autowired private SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    public List<Sede> getAllSedi() { return sedeRepository.findAll(); }

    @Transactional
    public Sede creaSede(String nome, String indirizzo, String citta) {
        Sede sede = new Sede();
        sede.setNome(nome);
        sede.setIndirizzo(indirizzo);
        sede.setCitta(citta);
        return sedeRepository.save(sede);
    }
}