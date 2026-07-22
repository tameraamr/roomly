package it.uniroma3.siw.roomly.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String testo;
    private Integer voto;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }
    public Integer getVoto() { return voto; }
    public void setVoto(Integer voto) { this.voto = voto; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public Utente getUtente() { return utente; }
    public void setUtente(Utente utente) { this.utente = utente; }
    public Aula getAula() { return aula; }
    public void setAula(Aula aula) { this.aula = aula; }
}