package com.pedroalmeida.clinicmanagementapi.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String s) {
        super(s);
    }
}
