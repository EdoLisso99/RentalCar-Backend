package com.example.rentalcar.service;

import com.example.rentalcar.dto.prenotazioni.PrenotazioneDto;
import com.example.rentalcar.repo.PrenotazioneRepo;
import com.example.rentalcar.entities.Prenotazione;
import com.example.rentalcar.exception.PrenotazioneNotFoundException;
import com.example.rentalcar.util.PrenotazioniDtoFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class PrenotazioneService {
    private final PrenotazioneRepo prenotazioneRepo;
    private final MezzoService mezzoService;
    private final UtenteService utenteService;
    private final PrenotazioniDtoFunctions prenotazioniDtoFunctions = new PrenotazioniDtoFunctions();

    @Transactional
    public PrenotazioneDto addPrenotazione(PrenotazioneDto prenotazione) throws ParseException {
        prenotazioneRepo.save(prenotazioniDtoFunctions.fromPrentoazioneDtoToPrenotazione(prenotazione));
        return prenotazione;
    }

    public List<PrenotazioneDto> getAllPrenotazioni(){
        List<Prenotazione> prenotazioni = prenotazioneRepo.findAll();
        List<PrenotazioneDto> prenotazioniDto = new ArrayList<>();
        prenotazioni.forEach(prenotazione -> {
            prenotazioniDto.add(prenotazioniDtoFunctions.fromPrenotazioneToPrenotazioneDto(prenotazione));
        });
        return prenotazioniDto;
    }

    @Transactional
    public PrenotazioneDto updatePrenotazione(PrenotazioneDto prenotazione) throws ParseException {
        prenotazioneRepo.save(prenotazioniDtoFunctions.fromPrentoazioneDtoToPrenotazione(prenotazione));
        return prenotazione;
    }

    @Transactional
    public void deletePrenotazione(Prenotazione prenotazione){
        prenotazioneRepo.delete(prenotazione);
    }

    public PrenotazioneDto findPrenotazioneById(Long id){
        Prenotazione prenotazione = prenotazioneRepo.findById(id).orElseThrow(() ->
                new PrenotazioneNotFoundException("Prenotazione " + id + " non è stato trovato"));
        return prenotazioniDtoFunctions.fromPrenotazioneToPrenotazioneDto(prenotazione);
    }

    @Transactional
    public void deletePrenotazione(Long id) throws Exception {
        PrenotazioneDto prenotazione = findPrenotazioneById(id);
        if(prenotazione != null){
            prenotazioneRepo.delete(prenotazioniDtoFunctions.fromPrentoazioneDtoToPrenotazione(prenotazione));
        }
        else {
            throw new Exception();
        }

    }
}
