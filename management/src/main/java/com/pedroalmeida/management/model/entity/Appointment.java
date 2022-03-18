package com.pedroalmeida.management.model.entity;

import com.pedroalmeida.management.model.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "APPOINTMENT", schema = "CLINICMANAGEMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APPOINTMENT_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "PATIENT_NAME", length = 50, nullable = false)
    private String patientName;

    @Column(name = "DOCTOR_NAME", length = 50, nullable = false)
    private String doctorName;

    @Column(name = "ROOM", length = 50, nullable = false)
    private String room;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus AppointmentStatus;

    @Column(name = "APPOINTMENT_DATE")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate appointmentDate;

}