package com.example.rentalcar.service;

import com.example.rentalcar.repo.MezzoRepo;
import com.example.rentalcar.entities.Mezzo;
import com.example.rentalcar.exception.MezzoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MezzoService {
    private final MezzoRepo mezzoRepo;

    
    public MezzoService(MezzoRepo mezzoRepo) {
        this.mezzoRepo = mezzoRepo;
    }

    public Mezzo addMezzo(Mezzo mezzo){
        return mezzoRepo.save(mezzo);
    }

    public List<Mezzo> getAllMezzi() {
        return (List<Mezzo>) mezzoRepo.findAll();
    }

    public Mezzo updateMezzo(Mezzo mezzo){
        return mezzoRepo.save(mezzo);
    }

    public void deleteMezzo(Mezzo mezzo){
        mezzoRepo.delete(mezzo);
    }

    public Mezzo findMezzoById(Long id){
        return mezzoRepo.findById(id).orElseThrow(() ->
                new MezzoNotFoundException("Mezzo " + id + " non è stato trovato"));
    }

    public void deleteMezzo(Long id) throws Exception {
        Mezzo mezzo = findMezzoById(id);
        if(mezzo != null){
            mezzoRepo.delete(mezzo);
        }
        else {
            throw new Exception();
        }
    }
}
