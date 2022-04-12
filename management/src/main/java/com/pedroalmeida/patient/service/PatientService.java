package com.pedroalmeida.patient.service;

import com.pedroalmeida.patient.model.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
}
