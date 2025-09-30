package com.HMS.HospitalManagementSys.Repository;

import com.HMS.HospitalManagementSys.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}