package com.pedroalmeida.patient.service.impl;

import com.pedroalmeida.doctor.model.repository.DoctorRepository;
import com.pedroalmeida.doctor.service.impl.DoctorServiceImpl;
import com.pedroalmeida.patient.model.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;
    private PatientServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new PatientServiceImpl(patientRepository);
    }

    @Test
    void getAllPatients() {
        underTest.getAllPatients();
        verify(patientRepository).findAll();
    }
}