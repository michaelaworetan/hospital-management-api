package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Doctor;

import java.util.List;

public interface DoctorRepository {

    int createDoctor(Doctor doctor);

    Doctor getDoctorById(int doctorId, int hospitalId);

    List<Doctor> getDoctorsByHospitalId(int hospitalId);

    int updateDoctor(Doctor doctor, int hospitalId);

    int deleteDoctorById(int doctorId, int hospitalId);
}
