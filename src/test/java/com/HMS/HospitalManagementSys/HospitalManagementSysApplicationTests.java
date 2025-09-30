package com.HMS.HospitalManagementSys;

import com.HMS.HospitalManagementSys.Entity.Patient;
import com.HMS.HospitalManagementSys.Repository.PatientRepository;
import com.HMS.HospitalManagementSys.dto.BloodGroupCountResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class HospitalManagementSysApplicationTests {

	@Test
	void contextLoads() {
	}

}
