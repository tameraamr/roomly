package it.uniroma3.siw.roomly.security;
import it.uniroma3.siw.roomly.model.Utente;
import it.uniroma3.siw.roomly.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UtenteDetailsService implements UserDetailsService {
    @Autowired private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato"));
        return User.builder()
                .username(utente.getUsername())
                .password(utente.getPassword())
                .roles(utente.getRuolo().name())
                .build();
    }
}