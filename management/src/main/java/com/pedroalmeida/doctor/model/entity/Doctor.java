package com.pedroalmeida.doctor.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "DOCTOR", schema = "CLINICMANAGEMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCTOR_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "DOCTOR_NAME", length = 50, nullable = false)
    private String doctorName;
}