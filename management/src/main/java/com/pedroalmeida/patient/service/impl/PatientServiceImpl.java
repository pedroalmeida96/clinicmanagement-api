package com.pedroalmeida.patient.service.impl;

import com.pedroalmeida.patient.model.entity.Patient;
import com.pedroalmeida.patient.model.entity.Patient;
import com.pedroalmeida.patient.model.repository.PatientRepository;
import com.pedroalmeida.patient.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    /**
     * Gets all appointment that are in the future/valid. If the appointment is no longer active its not returned.
     *
     * @return appointment
     */

    @Override
    public List<Patient> getAllPatients() {
        log.trace("Retrieving all patients");
        return repository.findAll();
    }

    @Override
    public Optional<Patient> getById(Long id) {
        log.trace("Retrieving patient with patient_id= " + id);
        return repository.findById(id);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        repository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(Patient patient) {
        log.trace("Deleting patient with patient_id= " + patient.getId());
        Objects.requireNonNull(patient.getId());
        repository.delete(patient);
    }

    @Override
    public Patient insertPatient(Patient patient) {
        log.trace("Inserting patient");
        repository.save(patient);
        return patient;
    }


}
