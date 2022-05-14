package com.pedroalmeida.patient.service.impl;

import com.pedroalmeida.patient.model.entity.Patient;
import com.pedroalmeida.patient.model.repository.PatientRepository;
import com.pedroalmeida.patient.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        log.trace("Retrieving all doctors");
        return repository.findAll();
    }
}
