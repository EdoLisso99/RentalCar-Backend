package com.example.rentalcar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mezzo")
public class Mezzo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "anno_di_immatricolazione")
    private Date annoDiImmatricolazione;

    @Column(name = "casa_costruttrice")
    private String casaCostruttrice;

    @Column(name = "modello")
    private String modello;

    @Column(name = "targa")
    private String targa;

    @Column(name = "tipo")
    private String tipo;

//    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "auto")
    private List<Prenotazione> prenotazioniMezzi;

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

    @JsonIgnore
    public List<Prenotazione> getPrenotazioniMezzi() {
        return prenotazioniMezzi;
    }

    public void setPrenotazioniMezzi(List<Prenotazione> prenotazioniMezzi) {
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
