package com.example.rentalcar.service;

import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.exception.UtenteNotFoundException;
import com.example.rentalcar.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UtenteService implements UserDetailsService {
    private final UtenteRepo utenteRepo;

    public UtenteService(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    @Transactional
    public Utente addUtente(Utente utente){
        return utenteRepo.save(utente);
    }

    public List<Utente> getAllUtenti(){
        return utenteRepo.findAll();
    }

    @Transactional
    public Utente updateUtente(Utente utente){
        return utenteRepo.save(utente);
    }

    @Transactional
    public void deleteUtente(Utente utente){
        utenteRepo.delete(utente);
    }

    public Utente findUtenteById(Long id){
        return utenteRepo.findById(id).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + id + " non è stato trovato"));
    }

    @Transactional
    public void deleteUtente(Long id) throws Exception {
        Utente utente = findUtenteById(id);
        if(utente != null){
            utenteRepo.delete(utente);
        }
        else {
            throw new Exception();
        }

    }

    //Implementazione di spring security in corso; non utilizzare il metodo, nè decommentare il codice
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Utente utente = utenteRepo.findByNome(username);
//        if(utente == null){
//            throw new UsernameNotFoundException("Utente non trovato nel database");
//        }
//        return new org.springframework.security.core.userdetails.User(utente.getU);
        return null;
    }
}
