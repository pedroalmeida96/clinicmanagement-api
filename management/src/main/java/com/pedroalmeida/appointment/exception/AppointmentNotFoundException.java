package com.pedroalmeida.appointment.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String s) {
        super(s);
    }
}
