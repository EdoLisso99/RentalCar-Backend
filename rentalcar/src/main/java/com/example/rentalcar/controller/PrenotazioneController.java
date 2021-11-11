package com.example.rentalcar.controller;

import com.example.rentalcar.dto.prenotazioni.PrenotazioneDto;
import com.example.rentalcar.entities.Prenotazione;
import com.example.rentalcar.service.MezzoService;
import com.example.rentalcar.service.PrenotazioneService;
import com.example.rentalcar.service.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PrenotazioneDto>> getAllPrenotazioni () {
        List<PrenotazioneDto> prenotazioni = prenotazioneService.getAllPrenotazioni();
        return new ResponseEntity<>(prenotazioni, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrenotazioneDto> getPrenotazioneById (@PathVariable("id") Long id) {
        PrenotazioneDto prenotazione = prenotazioneService.findPrenotazioneById(id);
        return new ResponseEntity<>(prenotazione, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PrenotazioneDto> createPrenotazione(@RequestBody PrenotazioneDto prenotazione) throws ParseException {
        prenotazioneService.addPrenotazione(prenotazione);
        return new ResponseEntity<>(prenotazione, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PrenotazioneDto> updatePrenotazione(@RequestBody PrenotazioneDto prenotazione) throws ParseException {
        prenotazioneService.updatePrenotazione(prenotazione);
        return new ResponseEntity<>(prenotazione, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PrenotazioneDto> deletePrenotazione(@PathVariable Long id) throws Exception {
        prenotazioneService.deletePrenotazione(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
