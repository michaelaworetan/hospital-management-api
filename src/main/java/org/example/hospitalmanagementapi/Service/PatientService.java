package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Patient;
import org.example.hospitalmanagementapi.model.request.PatientCreateRequest;
import org.example.hospitalmanagementapi.model.request.PatientUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PatientListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PatientSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.PatientRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
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

    public PatientListResponse getAllPatients() {
        var patients = patientRepository.getAllPatients();

        return PatientListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .patients(patients)
                .build();
    }

    public PatientSingleResponse getPatientById(int patientId) {
        var patient = patientRepository.getPatientById(patientId);

        return PatientSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .patient(patient)
                .build();
    }

    public BaseResponse createPatient(PatientCreateRequest request) {
        Gson gson = new Gson();
        var patient = gson.fromJson(gson.toJson(request), Patient.class);
        patientRepository.createPatient(patient);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updatePatient(PatientUpdateRequest request) {
        Gson gson = new Gson();
        var patient = gson.fromJson(gson.toJson(request), Patient.class);
        patientRepository.updatePatient(patient);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deletePatientById(int patientId) {
        patientRepository.deletePatientById(patientId);
        return ResponseConstants.SUCCESS;
    }

    public PatientListResponse getPatientsByName(String patientName) {
        var patients =  patientRepository.getPatientsByName(patientName);

        return PatientListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .patients(patients)
                .build();
    }

    public PatientListResponse getPatientsByHospitalId(int hospitalId) {
        var patients = patientRepository.getPatientsByHospitalId(hospitalId);

        return PatientListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .patients(patients)
                .build();
    }
}