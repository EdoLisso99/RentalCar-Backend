package com.example.rentalcar.dto.prenotazioni;

import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.entities.Utente;

import java.util.Date;

public class PrenotazioneDto {

    private Long id;
    private String dataDiInizio;
    private String dataDiFine;
    private Boolean accettata;
    private Mezzo auto;
    private Utente utente;

    public PrenotazioneDto(Long id, String dataDiInizio, String dataDiFine, Boolean accettata, Mezzo auto, Utente utente) {
        this.id = id;
        this.dataDiInizio = dataDiInizio;
        this.dataDiFine = dataDiFine;
        this.accettata = accettata;
        this.auto = auto;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataDiInizio() {
        return dataDiInizio;
    }

    public void setDataDiInizio(String dataDiInizio) {
        this.dataDiInizio = dataDiInizio;
    }

    public String getDataDiFine() {
        return dataDiFine;
    }

    public void setDataDiFine(String dataDiFine) {
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
}
