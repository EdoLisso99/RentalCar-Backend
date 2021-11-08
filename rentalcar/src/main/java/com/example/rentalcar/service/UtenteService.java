package com.example.rentalcar.service;

import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.exception.UtenteNotFoundException;
import com.example.rentalcar.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class UtenteService implements UserDetailsService {

    private final UtenteRepo utenteRepo;
    private final PasswordEncoder passwordEncoder;

    public Utente findUtenteByUsername(String username){
        return utenteRepo.findByUsername(username).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + username + " non è stato trovato"));
    }

    public Utente addUtente(Utente utente){
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepo.save(utente);
    }

    public List<Utente> getAllUtenti(){
        return utenteRepo.findAll();
    }

    public Utente updateUtente(Utente utente){
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = utenteRepo.findByUsername(username).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + username + " non è stato trovato"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(utente.getRuolo()));
        User x = new org.springframework.security.core.userdetails.User(utente.getUsername(), utente.getPassword(), authorities);
        return x;
    }
}
