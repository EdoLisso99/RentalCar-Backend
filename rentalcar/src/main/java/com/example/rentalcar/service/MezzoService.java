package com.example.rentalcar.service;

import com.example.rentalcar.dto.mezzi.MezzoDto;
import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.exception.MezzoNotFoundException;
import com.example.rentalcar.repo.MezzoRepo;
import com.example.rentalcar.util.MezziDtoFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class MezzoService {
    private final MezzoRepo mezzoRepo;
    private final MezziDtoFunctions mezziDtoFunctions = new MezziDtoFunctions();

    @Transactional
    public MezzoDto addMezzo(MezzoDto mezzo){
        mezzoRepo.save(mezziDtoFunctions.fromMezzoDtoToMezzo(mezzo));
        return mezzo;
    }

    public List<MezzoDto> getAllMezzi() {
        List<Mezzo> mezzi = mezzoRepo.findAll();
        List<MezzoDto> mezziDto = new ArrayList<>();
        mezzi.forEach(mezzo -> {
            mezziDto.add(mezziDtoFunctions.fromMezzoToMezzoDto(mezzo));
        });
        return mezziDto;
    }

    @Transactional
    public MezzoDto updateMezzo(MezzoDto mezzo){
        mezzoRepo.save(mezziDtoFunctions.fromMezzoDtoToMezzo(mezzo));
        return mezzo;
    }

    @Transactional
    public void deleteMezzo(Mezzo mezzo){
        mezzoRepo.delete(mezzo);
    }

    public MezzoDto findMezzoById(Long id){
        Mezzo mezzo = mezzoRepo.findById(id).orElseThrow(() ->
                new MezzoNotFoundException("Mezzo " + id + " non è stato trovato"));
        return mezziDtoFunctions.fromMezzoToMezzoDto(mezzo);
    }

    public List<MezzoDto> findAvailableMezzi(String inizio, String fine){
        List<Mezzo> mezzi = mezzoRepo.getAvailableMezzi(inizio, fine);
        List<MezzoDto> mezziDto = new ArrayList<>();
        mezzi.forEach(mezzo -> {
            mezziDto.add(mezziDtoFunctions.fromMezzoToMezzoDto(mezzo));
        });
        return mezziDto;
    }

    @Transactional
    public void deleteMezzo(Long id) throws Exception {
        MezzoDto mezzo = findMezzoById(id);
        if(mezzo != null){
            mezzoRepo.delete(mezziDtoFunctions.fromMezzoDtoToMezzo(mezzo));
        }
        else {
            throw new Exception();
        }
    }
}
