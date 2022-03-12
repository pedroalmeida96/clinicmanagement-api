package com.pedroalmeida.management.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public enum AppointmentStatus {
        PENDING,
        APPROVED,
        DENIED,
        CANCELED;
    }

    @Column(name = "STATUS", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus AppointmentStatus;


}