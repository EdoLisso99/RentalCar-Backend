package com.example.rentalcar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nome;
    private String cognome;
    private String ruolo;
    private Date dataDiNascita;

    @OneToMany(mappedBy = "utente",
            cascade = CascadeType.DETACH)
    private Set<Prenotazione> prenotazioniUtenti;

    public Utente() {
    }

    public Utente(Long id, String nome, String cognome, String ruolo, Date dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.dataDiNascita = dataDiNascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Prenotazione> getPrenotazioniUtenti() {
        return prenotazioniUtenti;
    }

    public void setPrenotazioniUtenti(Set<Prenotazione> prenotazioniUtenti) {
        this.prenotazioniUtenti = prenotazioniUtenti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ruolo='" + ruolo + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
