package com.example.rentalcar.controller;

import com.example.rentalcar.dto.mezzi.MezzoDto;
import com.example.rentalcar.service.MezzoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/mezzo")
public class MezzoController {
    private final MezzoService mezzoService;

    public MezzoController(MezzoService mezzoService) {
        this.mezzoService = mezzoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MezzoDto>> getAllMezzi() {
        List<MezzoDto> mezzi = mezzoService.getAllMezzi();
        return new ResponseEntity<>(mezzi, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MezzoDto> getMezzoById(@PathVariable("id") Long id) {
        MezzoDto mezzo = mezzoService.findMezzoById(id);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<MezzoDto>> getAvailableMezzi(@RequestParam String inizio, @RequestParam String fine){
        List<MezzoDto> mezzi = mezzoService.findAvailableMezzi(inizio, fine);
        return new ResponseEntity<>(mezzi, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MezzoDto> createMezzo(@RequestBody MezzoDto vehicle) throws ParseException {
        MezzoDto mezzo = mezzoService.addMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MezzoDto> updateMezzo(@RequestBody MezzoDto vehicle) throws ParseException {
        MezzoDto mezzo = mezzoService.updateMezzo(vehicle);
        return new ResponseEntity<>(mezzo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MezzoDto> updateMezzo(@PathVariable Long id) throws Exception {
        mezzoService.deleteMezzo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
