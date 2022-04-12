package com.pedroalmeida.doctor.service.impl;

import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.model.repository.DoctorRepository;
import com.pedroalmeida.doctor.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository repository;

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
