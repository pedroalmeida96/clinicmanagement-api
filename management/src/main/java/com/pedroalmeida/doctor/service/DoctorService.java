package com.pedroalmeida.doctor.service;

import com.pedroalmeida.appointment.model.entity.Appointment;
import com.pedroalmeida.doctor.model.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Doctor updateDoctor(Doctor doctor);

    void deleteDoctor(Doctor doctor);

    Doctor insertDoctor(Doctor doctor);

    Optional<Doctor> getById(Long id);

}
