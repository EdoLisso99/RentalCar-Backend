package com.example.rentalcar.dto.mezzi;

import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.entities.Utente;

import java.util.Date;

public class MezzoDto {

    private Long id;
    private Date annoDiImmatricolazione;
    private String casaCostruttrice;
    private String modello;
    private String targa;
    private String tipo;

    public MezzoDto(Long id, Date annoDiImmatricolazione, String casaCostruttrice, String modello, String targa, String tipo) {
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
}
