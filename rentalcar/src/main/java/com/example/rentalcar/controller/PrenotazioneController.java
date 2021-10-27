package com.example.rentalcar.controller;

import com.example.rentalcar.entities.Prenotazione;
import com.example.rentalcar.service.MezzoService;
import com.example.rentalcar.service.PrenotazioneService;
import com.example.rentalcar.service.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    Prenotazione prenotazione = null;

    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService, MezzoService mezzoService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni () {
        List<Prenotazione> prenotazioni = prenotazioneService.getAllPrenotazioni();
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById (@PathVariable("id") Long id) {
        prenotazione = prenotazioneService.findPrenotazioneById(id);
        return new ResponseEntity<>(prenotazione, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione prenotazione){
        prenotazione = prenotazioneService.addPrenotazione(prenotazione);
        return new ResponseEntity<>(prenotazione, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Prenotazione> updatePrenotazione(@RequestBody Prenotazione user){
        prenotazione = prenotazioneService.updatePrenotazione(user);
        return new ResponseEntity<>(prenotazione, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deletePrenotazione(@PathVariable Long id) throws Exception {
        prenotazioneService.deletePrenotazione(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
