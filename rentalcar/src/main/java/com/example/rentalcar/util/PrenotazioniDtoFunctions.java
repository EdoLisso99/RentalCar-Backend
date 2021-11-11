package com.example.rentalcar.util;

import com.example.rentalcar.dto.prenotazioni.PrenotazioneDto;
import com.example.rentalcar.entities.Prenotazione;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;

public class PrenotazioniDtoFunctions {

    Functions functions = new Functions();

    @Bean
    public Prenotazione fromPrentoazioneDtoToPrenotazione(PrenotazioneDto prenotazioneDto) throws ParseException {
        Prenotazione prenotazione = new Prenotazione(
                prenotazioneDto.getId(),
                functions.fromStringToDate(prenotazioneDto.getDataDiInizio()),
                functions.fromStringToDate(prenotazioneDto.getDataDiFine()),
                prenotazioneDto.getAccettata(),
                prenotazioneDto.getAuto(),
                prenotazioneDto.getUtente()
        );
        return prenotazione;
    }

    @Bean
    public PrenotazioneDto fromPrenotazioneToPrenotazioneDto(Prenotazione prenotazione){
        PrenotazioneDto prenotazioneDto = new PrenotazioneDto(
                prenotazione.getId(),
                functions.fromDateToString(prenotazione.getDataDiInizio()),
                functions.fromDateToString(prenotazione.getDataDiFine()),
                prenotazione.getAccettata(),
                prenotazione.getAuto(),
                prenotazione.getUtente()
        );
        return prenotazioneDto;
    }
}
