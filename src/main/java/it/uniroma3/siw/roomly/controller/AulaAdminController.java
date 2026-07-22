package it.uniroma3.siw.roomly.controller;
import it.uniroma3.siw.roomly.service.AulaService;
import it.uniroma3.siw.roomly.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/aule")
public class AulaAdminController {
    @Autowired private AulaService aulaService;
    @Autowired private SedeService sedeService;

    @GetMapping("/nuova")
    public String mostraForm(Model model) {
        model.addAttribute("sedi", sedeService.getAllSedi());
        return "admin/aule/form";
    }

    @PostMapping("/nuova")
    public String creaAula(@RequestParam String nome, @RequestParam Integer capienza,
                           @RequestParam String dotazioni, @RequestParam Long idSede) {
        aulaService.creaAula(nome, capienza, dotazioni, idSede);
        return "redirect:/aule";
    }

    @PostMapping("/{id}/elimina")
    public String eliminaAula(@PathVariable Long id) {
        aulaService.eliminaAula(id);
        return "redirect:/aule";
    }
}