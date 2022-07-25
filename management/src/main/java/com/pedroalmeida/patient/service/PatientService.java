package com.pedroalmeida.patient.service;

import com.pedroalmeida.patient.model.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient updatePatient(Patient patient);

    void deletePatient(Patient patient);

    Patient insertPatient(Patient patient);

    Optional<Patient> getById(Long id);
}
