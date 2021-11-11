package com.example.rentalcar.util;

import com.example.rentalcar.dto.utenti.UtenteDto;
import com.example.rentalcar.entities.Utente;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.ArrayList;

public class UtentiDtoFunctions {

    Functions functions = new Functions();

    @Bean
    public UtenteDto fromUtenteToUtenteDto(Utente utente) {
        UtenteDto utenteDto = new UtenteDto(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getUsername(),
                utente.getPassword(),
                utente.getRuolo(),
                functions.fromDateToString(utente.getDataDiNascita())
        );
        return utenteDto;
    }

    @Bean
    public Utente fromUtenteDtoToUtente(UtenteDto utenteDto) throws ParseException {
        Utente utente = new Utente(
                utenteDto.getId(),
                utenteDto.getNome(),
                utenteDto.getCognome(),
                utenteDto.getRuolo(),
                functions.fromStringToDate(utenteDto.getDataDiNascita()),
                utenteDto.getUsername(),
                utenteDto.getPassword(),
                new ArrayList<>()
        );
        return utente;
    }
}
