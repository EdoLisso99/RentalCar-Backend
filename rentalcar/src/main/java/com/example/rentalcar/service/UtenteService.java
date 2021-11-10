package com.example.rentalcar.service;

import com.example.rentalcar.dto.utenti.UtenteDto;
import com.example.rentalcar.entities.Utente;
import com.example.rentalcar.exception.UtenteNotFoundException;
import com.example.rentalcar.repo.UtenteRepo;
import com.example.rentalcar.util.UtentiDtoFunctions;
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
    private UtentiDtoFunctions utentiDtoFunctions = new UtentiDtoFunctions();

    public UtenteDto findUtenteByUsername(String username){
        Utente utente = utenteRepo.findByUsername(username).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + username + " non è stato trovato"));
        return utentiDtoFunctions.fromUtenteToUtenteDto(utente);
    }

    public UtenteDto addUtente(UtenteDto utente, boolean flag){
        if(flag){
            utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        }
        utenteRepo.save(utentiDtoFunctions.fromUtenteDtoToUtente(utente));
        return utente;
    }

    public List<UtenteDto> getAllUtenti(){
        List<Utente> utenti = utenteRepo.findAll();
        List<UtenteDto> utentiDto = new ArrayList<>();
        utenti.forEach(utente -> {
            utentiDto.add(utentiDtoFunctions.fromUtenteToUtenteDto(utente));
        });
        return utentiDto;
    }

    public UtenteDto updateUtente(UtenteDto utente, boolean flag){
        if(flag){
            utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        }
        utenteRepo.save(utentiDtoFunctions.fromUtenteDtoToUtente(utente));
        return utente;
    }

    public void deleteUtente(Utente utente){
        utenteRepo.delete(utente);
    }

    public UtenteDto findUtenteById(Long id){
        Utente utente = utenteRepo.findById(id).orElseThrow(() ->
                new UtenteNotFoundException("Utente " + id + " non è stato trovato"));
        return utentiDtoFunctions.fromUtenteToUtenteDto(utente);
    }

    public void deleteUtente(Long id) throws Exception {
        UtenteDto utente = findUtenteById(id);
        if(utente != null){
            utenteRepo.delete(utentiDtoFunctions.fromUtenteDtoToUtente(utente));
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
