package com.pedroalmeida.doctor.service.impl;

import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.model.repository.DoctorRepository;
import com.pedroalmeida.doctor.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
