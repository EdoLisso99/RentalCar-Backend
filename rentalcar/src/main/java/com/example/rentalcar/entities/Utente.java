package com.example.rentalcar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "ruolo")
    private String ruolo;

    @Column(name = "data_di_nascita")
    private Date dataDiNascita;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "utente"
    )
    private List<Prenotazione> prenotazioniUtenti;

    public Utente() {
    }

    public Utente(Long id, String nome, String cognome, String ruolo, Date dataDiNascita, String username, String password, List<Prenotazione> prenotazioniUtenti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.dataDiNascita = dataDiNascita;
        this.username = username;
        this.password = password;
        this.prenotazioniUtenti = prenotazioniUtenti;
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

    @JsonIgnore
    public List<Prenotazione> getPrenotazioniUtenti() {
        return prenotazioniUtenti;
    }

    public void setPrenotazioniUtenti(List<Prenotazione> prenotazioniUtenti) {
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

