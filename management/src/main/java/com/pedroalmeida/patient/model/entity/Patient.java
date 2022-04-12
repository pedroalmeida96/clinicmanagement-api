package com.pedroalmeida.patient.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "PATIENT", schema = "CLINICMANAGEMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "PATIENT_NAME", length = 50, nullable = false)
    private String patientName;
}