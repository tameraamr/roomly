package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.service.SedeService;
import it.uniroma3.siw.roomly.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired private SedeService sedeService;
    @Autowired private AulaService aulaService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("numSedi", sedeService.getAllSedi().size());
        model.addAttribute("numAule", aulaService.getAllAuleOrdinate().size());
        return "index";
    }

    @GetMapping("/login") public String login() { return "login"; }
}