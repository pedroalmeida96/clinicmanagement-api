package com.pedroalmeida.clinicmanagementapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

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