package com.example.rentalcar.controller;

import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.service.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
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
        Utente utente = utenteService.findUtenteById(id);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Utente> createUtente(@RequestBody Utente user){
        Utente utente = utenteService.addUtente(user);
        return new ResponseEntity<>(utente, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Utente> updateUtente(@RequestBody Utente user){
        Utente utente = utenteService.updateUtente(user);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtente(@PathVariable Long id) throws Exception {
        utenteService.deleteUtente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Utente> getUtenteByUsername(@PathVariable String username){
        Utente utente = utenteService.findUtenteByUsername(username);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }


}
