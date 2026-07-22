package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.service.AulaService;
import it.uniroma3.siw.roomly.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired private PrenotazioneService prenotazioneService;
    @Autowired private AulaService aulaService;

    @GetMapping("/nuova")
    public String mostraForm(@RequestParam Long idAula, Model model) {
        model.addAttribute("aula", aulaService.getAulaById(idAula));
        return "prenotazioni/form";
    }

    @PostMapping("/nuova")
    public String creaPrenotazione(@RequestParam Long idAula,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInizio,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFine,
                                   @AuthenticationPrincipal UserDetails userDetails) {
        prenotazioneService.creaPrenotazione(idAula, userDetails.getUsername(), dataInizio, dataFine);
        return "redirect:/prenotazioni/mie";
    }

    @GetMapping("/mie")
    public String lePrenotazioni(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("prenotazioni", prenotazioneService.getPrenotazioniByUtente(userDetails.getUsername()));
        return "prenotazioni/mie";
    }

    @PostMapping("/{id}/annulla")
    public String annulla(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        prenotazioneService.annullaPrenotazione(id, userDetails.getUsername());
        return "redirect:/prenotazioni/mie";
    }
}