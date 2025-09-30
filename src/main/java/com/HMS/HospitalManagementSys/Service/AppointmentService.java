package com.HMS.HospitalManagementSys.Service;

import com.HMS.HospitalManagementSys.Entity.Appointment;
import com.HMS.HospitalManagementSys.Entity.Doctor;
import com.HMS.HospitalManagementSys.Entity.Patient;
import com.HMS.HospitalManagementSys.Repository.AppointmentRepository;
import com.HMS.HospitalManagementSys.Repository.DoctorRepository;
import com.HMS.HospitalManagementSys.Repository.PatientRepository;
import com.HMS.HospitalManagementSys.dto.AppointmentResponseDto;
import com.HMS.HospitalManagementSys.dto.CreateAppointmentRequestDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));

        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment); // to maintain consistency

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponseDto.class);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); // just for bidirectional consistency

        return appointment;
    }

}
