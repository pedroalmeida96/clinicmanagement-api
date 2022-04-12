package com.pedroalmeida.doctor.service;

import com.pedroalmeida.doctor.model.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();
}
