package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> getAllPatients();

    Patient getPatientById(int patientId);

    int createPatient(Patient patient);

    int updatePatient(Patient patient);

    int deletePatientById(int patientId);
}
