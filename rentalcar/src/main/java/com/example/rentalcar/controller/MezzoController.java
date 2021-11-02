package com.example.rentalcar.controller;

import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.service.MezzoService;
import com.example.rentalcar.util.DateExample;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mezzo")
public class MezzoController {
    private final MezzoService mezzoService;

    public MezzoController(MezzoService mezzoService) {
        this.mezzoService = mezzoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mezzo>> getAllMezzi() {
        List<Mezzo> mezzi = mezzoService.getAllMezzi();
        return new ResponseEntity<>(mezzi, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mezzo> getMezzoById(@PathVariable("id") Long id) {
        Mezzo mezzo = mezzoService.findMezzoById(id);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<Mezzo> createMezzo(@RequestBody Mezzo vehicle){
        Mezzo mezzo = mezzoService.addMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Mezzo> updateMezzo(@RequestBody Mezzo vehicle){
        Mezzo mezzo = mezzoService.updateMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mezzo> updateMezzo(@PathVariable Long id) throws Exception {
        mezzoService.deleteMezzo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO Risolvere cambiando con RequestParam!!!
    @PostMapping("/available")
    public ResponseEntity<List<Mezzo>> getAvailableMezzi(@RequestBody DateExample dateExample){
        List<Mezzo> mezzi = mezzoService.findAvailableMezzi(dateExample.inizio, dateExample.fine);
        return new ResponseEntity<>(mezzi, HttpStatus.OK);
    }
}
