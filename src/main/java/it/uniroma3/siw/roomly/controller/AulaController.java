package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.service.AulaService;
import it.uniroma3.siw.roomly.service.PrenotazioneService;
import it.uniroma3.siw.roomly.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AulaController {
    @Autowired private AulaService aulaService;
    @Autowired private PrenotazioneService prenotazioneService;
    @Autowired private RecensioneService recensioneService;

    @GetMapping("/aule")
    public String elencoAule(Model model) {
        model.addAttribute("aule", aulaService.getAllAuleOrdinate());
        return "aule/elenco";
    }

    @GetMapping("/aule/{id}")
    public String dettaglioAula(@PathVariable Long id, Model model) {
        model.addAttribute("aula", aulaService.getAulaById(id));
        model.addAttribute("recensioni", recensioneService.getRecensioniByAula(id));
        return "aule/dettaglio";
    }
}