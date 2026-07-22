package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrazioneController {
    @Autowired private UtenteService utenteService;
    @GetMapping("/registrati") public String mostraForm() { return "registrati"; }

    @PostMapping("/registrati")
    public String registraUtente(@RequestParam String username, @RequestParam String password) {
        utenteService.registraUtente(username, password);
        return "redirect:/login?registrato";
    }
}