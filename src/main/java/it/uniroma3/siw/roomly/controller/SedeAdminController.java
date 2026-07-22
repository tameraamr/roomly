package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.model.Sede;
import it.uniroma3.siw.roomly.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/sedi")
public class SedeAdminController {
    @Autowired private SedeService sedeService;

    @GetMapping("/nuova")
    public String mostraForm(Model model) {
        model.addAttribute("sede", new Sede());
        return "admin/sedi/form";
    }

    @PostMapping("/nuova")
    public String creaSede(@ModelAttribute Sede sede) {
        sedeService.creaSede(sede.getNome(), sede.getIndirizzo(), sede.getCitta());
        return "redirect:/aule";
    }
}