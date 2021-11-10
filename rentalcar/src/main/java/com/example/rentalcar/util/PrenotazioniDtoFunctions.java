package com.example.rentalcar.util;

import com.example.rentalcar.dto.prenotazioni.PrenotazioneDto;
import com.example.rentalcar.entities.Prenotazione;
import org.springframework.context.annotation.Bean;

public class PrenotazioniDtoFunctions {

    @Bean
    public Prenotazione fromPrentoazioneDtoToPrenotazione(PrenotazioneDto prenotazioneDto){
        Prenotazione prenotazione = new Prenotazione(
                prenotazioneDto.getId(),
                prenotazioneDto.getDataDiInizio(),
                prenotazioneDto.getDataDiFine(),
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
                prenotazione.getDataDiInizio(),
                prenotazione.getDataDiFine(),
                prenotazione.getAccettata(),
                prenotazione.getAuto(),
                prenotazione.getUtente()
        );
        return prenotazioneDto;
    }
}
