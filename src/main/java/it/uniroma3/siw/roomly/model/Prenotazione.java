package it.uniroma3.siw.roomly.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;

    @Enumerated(EnumType.STRING)
    private StatoPrenotazione stato;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDateTime dataInizio) { this.dataInizio = dataInizio; }
    public LocalDateTime getDataFine() { return dataFine; }
    public void setDataFine(LocalDateTime dataFine) { this.dataFine = dataFine; }
    public StatoPrenotazione getStato() { return stato; }
    public void setStato(StatoPrenotazione stato) { this.stato = stato; }
    public Aula getAula() { return aula; }
    public void setAula(Aula aula) { this.aula = aula; }
    public Utente getUtente() { return utente; }
    public void setUtente(Utente utente) { this.utente = utente; }
}