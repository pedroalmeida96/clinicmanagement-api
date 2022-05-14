package com.pedroalmeida.patient.model.repository;

import com.pedroalmeida.patient.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

