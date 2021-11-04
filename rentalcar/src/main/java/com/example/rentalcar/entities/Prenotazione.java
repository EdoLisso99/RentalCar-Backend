package com.example.rentalcar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Prenotazione implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "data_di_inizio")
    private Date dataDiInizio;

    @Column(name = "data_di_fine")
    private Date dataDiFine;

    @Column(name = "accettata")
    private Boolean accettata;

    @ManyToOne
    @JoinColumn(name = "auto")
    private Mezzo auto;

    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;

    public Prenotazione() {
    }

    public Prenotazione(Long id, Date dataDiInizio, Date dataDiFine, Boolean accettata) {
        this.id = id;
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
        this.accettata = accettata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDiInizio() {
        return dataDiInizio;
    }

    public void setDataDiInizio(Date dataDiInizio) {
        this.dataDiInizio = dataDiInizio;
    }

    public Date getDataDiFine() {
        return dataDiFine;
    }

    public void setDataDiFine(Date dataDiFine) {
        this.dataDiFine = dataDiFine;
    }

    public Boolean getAccettata() {
        return accettata;
    }

    public void setAccettata(Boolean accettata) {
        this.accettata = accettata;
    }

    public Mezzo getAuto() {
        return auto;
    }

    public void setAuto(Mezzo auto) {
        this.auto = auto;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataDiInizio=" + dataDiInizio +
                ", dataDiFine=" + dataDiFine +
                ", accettata=" + accettata +
                '}';
    }
}
