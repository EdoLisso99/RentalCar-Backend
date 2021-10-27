package com.example.rentalcar.exception;

public class UtenteNotFoundException extends RuntimeException{
    public UtenteNotFoundException(String message) {
        super(message);
    }
}
