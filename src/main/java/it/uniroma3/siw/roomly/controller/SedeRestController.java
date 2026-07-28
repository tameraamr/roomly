package it.uniroma3.siw.roomly.controller;

import it.uniroma3.siw.roomly.service.AulaDTO;
import it.uniroma3.siw.roomly.service.AulaService;
import it.uniroma3.siw.roomly.service.SedeDTO;
import it.uniroma3.siw.roomly.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sedi")
@CrossOrigin(origins = "http://localhost:5173")
public class SedeRestController {
    @Autowired private SedeService sedeService;
    @Autowired private AulaService aulaService;

    @GetMapping
    public List<SedeDTO> getAllSedi() {
        return sedeService.getAllSedi().stream()
                .map(s -> new SedeDTO(s.getId(), s.getNome()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/aule")
    public List<AulaDTO> getAuleBySede(@PathVariable Long id) {
        return aulaService.getAuleBySede(id).stream()
                .map(a -> new AulaDTO(a.getId(), a.getNome(), a.getCapienza(), a.getDotazioni()))
                .collect(Collectors.toList());
    }
}