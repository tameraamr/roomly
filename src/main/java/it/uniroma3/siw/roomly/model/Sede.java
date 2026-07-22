package it.uniroma3.siw.roomly.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "sede")
    private List<Aula> aule = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
    public String getCitta() { return citta; }
    public void setCitta(String citta) { this.citta = citta; }
    public List<Aula> getAule() { return aule; }
    public void setAule(List<Aula> aule) { this.aule = aule; }
}