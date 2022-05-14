package com.pedroalmeida.doctor.service.impl;

import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.model.repository.DoctorRepository;
import com.pedroalmeida.doctor.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService {

   private final DoctorRepository repository;

    /**
     * Gets all appointment that are in the future/valid. If the appointment is no longer active its not returned.
     *
     * @return appointment
     */

    @Override
    public List<Doctor> getAllDoctors() {
        log.trace("Retrieving all doctors");
        return repository.findAll();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        repository.save(doctor);
        return doctor;
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        log.trace("Deleting doctor with doctor_id= " + doctor.getId());
        Objects.requireNonNull(doctor.getId());
        repository.delete(doctor);
    }

    @Override
    public Doctor insertDoctor(Doctor doctor) {
        log.trace("Inserting doctor");
        repository.save(doctor);
        return doctor;
    }

    @Override
    public Optional<Doctor> getById(Long id) {
        log.trace("Retrieving doctor with appointment_id= " + id);
        return repository.findById(id);
    }
}
