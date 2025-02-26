package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Doctor;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAllDoctors();

    Doctor getDoctorById(int doctorId);

    int createDoctor(Doctor doctor);

    int updateDoctor(Doctor doctor);

    int deleteDoctorById(int doctorId);
}
