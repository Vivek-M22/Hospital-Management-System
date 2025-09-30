package com.HMS.HospitalManagementSys.Repository;

import com.HMS.HospitalManagementSys.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}