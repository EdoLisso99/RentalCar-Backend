package com.example.rentalcar.util;

import com.example.rentalcar.dto.mezzi.MezzoDto;
import com.example.rentalcar.entities.Mezzo;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;

public class MezziDtoFunctions {

    Functions functions = new Functions();

    @Bean
    public MezzoDto fromMezzoToMezzoDto (Mezzo mezzo){
        MezzoDto mezzoDto = new MezzoDto(
                mezzo.getId(),
                functions.fromDateToString(mezzo.getAnnoDiImmatricolazione()),
                mezzo.getCasaCostruttrice(),
                mezzo.getModello(),
                mezzo.getTarga(),
                mezzo.getTipo()
        );
        return mezzoDto;
    }

    @Bean
    public Mezzo fromMezzoDtoToMezzo(MezzoDto mezzoDto) throws ParseException {
        Mezzo mezzo = new Mezzo(
                mezzoDto.getId(),
                functions.fromStringToDate(mezzoDto.getAnnoDiImmatricolazione()),
                mezzoDto.getCasaCostruttrice(),
                mezzoDto.getModello(),
                mezzoDto.getTarga(),
                mezzoDto.getTipo()
        );
        return mezzo;
    }
}
