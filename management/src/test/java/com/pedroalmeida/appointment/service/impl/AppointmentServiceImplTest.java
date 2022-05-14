package com.pedroalmeida.appointment.service.impl;

import com.pedroalmeida.appointment.model.entity.Appointment;
import com.pedroalmeida.appointment.model.enums.AppointmentStatus;
import com.pedroalmeida.appointment.model.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;
    private AppointmentServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new AppointmentServiceImpl(appointmentRepository);
    }

    @Test
    void canGetAllAppointments() {
        underTest.getAllAppointments();
        verify(appointmentRepository).findAll();
    }

    @Test
    void canInsertAppointment() {
        Appointment appointment = new Appointment(7L, "Pedro Almeida", "Luis Almeida", "Room 2", AppointmentStatus.APPROVED, LocalDate.now());

        underTest.insertAppointment(appointment);

        ArgumentCaptor<Appointment> appointmentArgumentCaptor = ArgumentCaptor.forClass(Appointment.class);
        verify(appointmentRepository).save(appointmentArgumentCaptor.capture());
        Appointment capturedAppointment = appointmentArgumentCaptor.getValue();
        assertThat(capturedAppointment).isEqualTo(appointment);
    }

    @Test
    void getById() {
    }

    @Test
    void updateAppointment() {
    }

    @Test
    void deleteAppointment() {
    }
}