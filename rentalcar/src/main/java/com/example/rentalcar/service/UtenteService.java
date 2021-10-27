package com.example.rentalcar.service;

import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.exception.UtenteNotFoundException;
import com.example.rentalcar.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    private final UtenteRepo utenteRepo;

    
    public UtenteService(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    public Utente addUtente(Utente utente){
        return utenteRepo.save(utente);
    }

    public List<Utente> getAllUtenti(){
        return  utenteRepo.findAll();
    }

    public Utente updateUtente(Utente utente){
        return utenteRepo.save(utente);
    }

    public void deleteUtente(Utente utente){
        utenteRepo.delete(utente);
    }

    public Utente findUtenteById(Long id){
        return utenteRepo.findById(id).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + id + " non è stato trovato"));
    }

    public void deleteUtente(Long id) throws Exception {
        Utente utente = findUtenteById(id);
        if(utente != null){
            utenteRepo.delete(utente);
        }
        else {
            throw new Exception();
        }

    }
}
