package com.pedroalmeida.doctor.service.impl;

import com.pedroalmeida.doctor.model.entity.Doctor;
import com.pedroalmeida.doctor.model.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DoctorServiceImplTest {

    @Mock
    private DoctorRepository doctorRepository;
    private DoctorServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new DoctorServiceImpl(doctorRepository);
    }

    @Test
    void getAllDoctors() {
        underTest.getAllDoctors();
        verify(doctorRepository).findAll();
    }

    @Test
    void insertDoctor() {
        Doctor doctor = new Doctor(176L, "Dr. Oliveira Salazar");
        underTest.insertDoctor(doctor);

        ArgumentCaptor<Doctor> doctorArgumentCaptor = ArgumentCaptor.forClass(Doctor.class);
        verify(doctorRepository).save(doctorArgumentCaptor.capture());
        Doctor capturedDoctor = doctorArgumentCaptor.getValue();
        assertThat(capturedDoctor).isEqualTo(doctor);
    }

    @Test
    @Disabled
    void updateDoctor() {
    }

    @Test
    @Disabled
    void deleteDoctor() {
    }


    @Test
    @Disabled
    void getById() {
    }
}