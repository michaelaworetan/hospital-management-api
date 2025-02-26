package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Patient;
import org.example.hospitalmanagementapi.model.request.PatientCreateRequest;
import org.example.hospitalmanagementapi.model.request.PatientUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    public Patient getPatientById(int patientId) {
        return patientRepository.getPatientById(patientId);
    }

    public int createPatient(PatientCreateRequest request) {
        Gson gson = new Gson();
        var patient = gson.fromJson(gson.toJson(request), Patient.class);
        return patientRepository.createPatient(patient);
    }

    public int updatePatient(PatientUpdateRequest request) {
        Gson gson = new Gson();
        var patient = gson.fromJson(gson.toJson(request), Patient.class);
        return patientRepository.updatePatient(patient);
    }

    public int deletePatientById(int patientId) {
        return patientRepository.deletePatientById(patientId);
    }

    public List<Patient> getPatientsByName(String patientName) {
        return patientRepository.getPatientsByName(patientName);
    }

    public List<Patient> getPatientsByHospitalId(int hospitalId) {
        return patientRepository.getPatientsByHospitalId(hospitalId);
    }
}