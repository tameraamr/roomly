package it.uniroma3.siw.roomly.service;
import it.uniroma3.siw.roomly.model.Ruolo;
import it.uniroma3.siw.roomly.model.Utente;
import it.uniroma3.siw.roomly.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtenteService {
    @Autowired private UtenteRepository utenteRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Transactional
    public Utente registraUtente(String username, String password) {
        if (utenteRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username già in uso");
        }
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setPassword(passwordEncoder.encode(password));
        utente.setRuolo(Ruolo.USER);
        return utenteRepository.save(utente);
    }
}