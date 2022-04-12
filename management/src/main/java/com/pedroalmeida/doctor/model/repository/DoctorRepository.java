package com.pedroalmeida.doctor.model.repository;

import com.pedroalmeida.doctor.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    void deleteDoctorById(Long id);

    Optional<Doctor> getDoctorById(Long id);
}

