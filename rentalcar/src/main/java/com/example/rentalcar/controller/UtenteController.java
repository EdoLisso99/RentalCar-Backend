package com.example.rentalcar.controller;

import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    Utente utente = null;
    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Utente>> getAllUtenti () {
        List<Utente> utenti = utenteService.getAllUtenti();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById (@PathVariable("id") Long id) {
        utente = utenteService.findUtenteById(id);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Utente> createUtente(@RequestBody Utente user){
        utente = utenteService.addUtente(user);
        return new ResponseEntity<>(utente, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Utente> updateUtente(@RequestBody Utente user){
        utente = utenteService.updateUtente(user);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtente(@PathVariable Long id) throws Exception {
        utenteService.deleteUtente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
