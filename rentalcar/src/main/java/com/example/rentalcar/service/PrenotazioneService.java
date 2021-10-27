package com.example.rentalcar.service;

import com.example.rentalcar.repo.PrenotazioneRepo;
import com.example.rentalcar.entities.Prenotazione;
import com.example.rentalcar.exception.PrenotazioneNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepo prenotazioneRepo;

    public PrenotazioneService(PrenotazioneRepo prenotazioneRepo) {
        this.prenotazioneRepo = prenotazioneRepo;
    }

    public Prenotazione addPrenotazione(Prenotazione prenotazione){
        return prenotazioneRepo.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni(){
        return  prenotazioneRepo.findAll();
    }

    public Prenotazione updatePrenotazione(Prenotazione prenotazione){
        return prenotazioneRepo.save(prenotazione);
    }

    public void deletePrenotazione(Prenotazione prenotazione){
        prenotazioneRepo.delete(prenotazione);
    }

    public Prenotazione findPrenotazioneById(Long id){
        return prenotazioneRepo.findById(id).orElseThrow(() ->
                new PrenotazioneNotFoundException("Prenotazione " + id + " non è stato trovato"));
    }

    public void deletePrenotazione(Long id) throws Exception {
        Prenotazione prenotazione = findPrenotazioneById(id);
        if(prenotazione != null){
            prenotazioneRepo.delete(prenotazione);
        }
        else {
            throw new Exception();
        }

    }

}
