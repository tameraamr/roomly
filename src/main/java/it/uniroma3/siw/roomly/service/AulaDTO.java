package it.uniroma3.siw.roomly.service;

public class AulaDTO {
    private Long id;
    private String nome;
    private Integer capienza;
    private String dotazioni;
    public AulaDTO(Long id, String nome, Integer capienza, String dotazioni) {
        this.id = id; this.nome = nome; this.capienza = capienza; this.dotazioni = dotazioni;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getCapienza() { return capienza; }
    public void setCapienza(Integer capienza) { this.capienza = capienza; }
    public String getDotazioni() { return dotazioni; }
    public void setDotazioni(String dotazioni) { this.dotazioni = dotazioni; }
}