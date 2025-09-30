package com.HMS.HospitalManagementSys.Repository;

import com.HMS.HospitalManagementSys.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}