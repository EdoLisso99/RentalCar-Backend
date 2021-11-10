package com.example.rentalcar.util;

import com.example.rentalcar.dto.mezzi.MezzoDto;
import com.example.rentalcar.entities.Mezzo;
import org.springframework.context.annotation.Bean;

public class MezziDtoFunctions {

    @Bean
    public MezzoDto fromMezzoToMezzoDto (Mezzo mezzo){
        MezzoDto mezzoDto = new MezzoDto(
                mezzo.getId(),
                mezzo.getAnnoDiImmatricolazione(),
                mezzo.getCasaCostruttrice(),
                mezzo.getModello(),
                mezzo.getTarga(),
                mezzo.getTipo()
        );
        return mezzoDto;
    }

    @Bean
    public Mezzo fromMezzoDtoToMezzo(MezzoDto mezzoDto){
        Mezzo mezzo = new Mezzo(
                mezzoDto.getId(),
                mezzoDto.getAnnoDiImmatricolazione(),
                mezzoDto.getCasaCostruttrice(),
                mezzoDto.getModello(),
                mezzoDto.getTarga(),
                mezzoDto.getTipo()
        );
        return mezzo;
    }
}
