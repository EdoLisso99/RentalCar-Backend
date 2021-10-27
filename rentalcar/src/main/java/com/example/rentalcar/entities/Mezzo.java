package com.example.rentalcar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Mezzo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date annoDiImmatricolazione;
    private String casaCostruttrice;
    private String modello;
    private String targa;
    private String tipo;

    @OneToMany(mappedBy = "auto",
            cascade = CascadeType.DETACH)
    private Set<Prenotazione> prenotazioniMezzi;

    public Mezzo() {
    }

    public Mezzo(Long id, Date annoDiImmatricolazione, String casaCostruttrice, String modello, String targa, String tipo) {
        this.id = id;
        this.annoDiImmatricolazione = annoDiImmatricolazione;
        this.casaCostruttrice = casaCostruttrice;
        this.modello = modello;
        this.targa = targa;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnnoDiImmatricolazione() {
        return annoDiImmatricolazione;
    }

    public void setAnnoDiImmatricolazione(Date annoDiImmatricolazione) {
        this.annoDiImmatricolazione = annoDiImmatricolazione;
    }

    public String getCasaCostruttrice() {
        return casaCostruttrice;
    }

    public void setCasaCostruttrice(String casaCostruttrice) {
        this.casaCostruttrice = casaCostruttrice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Prenotazione> getPrenotazioniMezzi() {
        return prenotazioniMezzi;
    }

    public void setPrenotazioniMezzi(Set<Prenotazione> prenotazioniMezzi) {
        this.prenotazioniMezzi = prenotazioniMezzi;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", annoDiImmatricolazione=" + annoDiImmatricolazione +
                ", casaCostruttrice='" + casaCostruttrice + '\'' +
                ", modello='" + modello + '\'' +
                ", targa='" + targa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
