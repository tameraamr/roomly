package it.uniroma3.siw.roomly.service;

public class SedeDTO {
    private Long id;
    private String nome;
    public SedeDTO(Long id, String nome) { this.id = id; this.nome = nome; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}