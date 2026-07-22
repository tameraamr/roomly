package it.uniroma3.siw.roomly.model;

import jakarta.persistence.*;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer capienza;
    private String dotazioni;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getCapienza() { return capienza; }
    public void setCapienza(Integer capienza) { this.capienza = capienza; }
    public String getDotazioni() { return dotazioni; }
    public void setDotazioni(String dotazioni) { this.dotazioni = dotazioni; }
    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }
}