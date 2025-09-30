package com.HMS.HospitalManagementSys.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.util.pattern.PathPattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 50)
    private String reason;

//    @Column(nullable = false)
//    private String status;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_id", nullable = false) // patient is required and not nullable
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
