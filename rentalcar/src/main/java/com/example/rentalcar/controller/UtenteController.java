package com.example.rentalcar.controller;

import com.example.rentalcar.dto.utenti.UtenteDto;
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
    public ResponseEntity<List<UtenteDto>> getAllUtenti () {
        List<UtenteDto> utenti = utenteService.getAllUtenti();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtenteDto> getUtenteById (@PathVariable("id") Long id) {
        UtenteDto utente = utenteService.findUtenteById(id);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UtenteDto> createUtente(@RequestBody UtenteDto user, @RequestParam boolean flag){
        UtenteDto utente = utenteService.addUtente(user, flag);
        return new ResponseEntity<>(utente, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UtenteDto> updateUtente(@RequestBody UtenteDto user, @RequestParam boolean updatePw){
        UtenteDto utente = utenteService.updateUtente(user, updatePw);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UtenteDto> deleteUtente(@PathVariable Long id) throws Exception {
        utenteService.deleteUtente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UtenteDto> getUtenteByUsername(@PathVariable String username){
        UtenteDto utente = utenteService.findUtenteByUsername(username);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }


}
