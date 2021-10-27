package com.example.rentalcar.controller;

import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.service.MezzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mezzo")
public class MezzoController {
    Mezzo mezzo = null;
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
        mezzo = mezzoService.findMezzoById(id);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Mezzo> createMezzo(@RequestBody Mezzo vehicle){
        mezzo = mezzoService.addMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Mezzo> updateMezzo(@RequestBody Mezzo vehicle){
        mezzo = mezzoService.updateMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Mezzo> updateMezzo(@PathVariable Long id) throws Exception {
        mezzoService.deleteMezzo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
