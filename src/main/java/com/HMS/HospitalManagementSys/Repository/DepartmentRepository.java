package com.HMS.HospitalManagementSys.Repository;

import com.HMS.HospitalManagementSys.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}