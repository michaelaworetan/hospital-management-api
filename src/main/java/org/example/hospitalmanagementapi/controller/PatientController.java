package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.PatientService;
import org.example.hospitalmanagementapi.model.entity.Patient;
import org.example.hospitalmanagementapi.model.request.PatientCreateRequest;
import org.example.hospitalmanagementapi.model.request.PatientUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PatientListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PatientSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create-patient")
    public BaseResponse createPatient(@RequestBody PatientCreateRequest request) {
        return patientService.createPatient(request);
    }

    @GetMapping("/get-all-patients")
    public PatientListResponse getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/get-by-id/{patientId}")
    public PatientSingleResponse getPatientById(@PathVariable int patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/get-by-name/{patientName}")
    public PatientListResponse getPatientByName(@PathVariable String patientName) {
        return patientService.getPatientsByName(patientName);
    }

    @GetMapping("/get-by-hospital/{hospitalId}")
    public PatientListResponse getPatientByHospital(@PathVariable int hospitalId) {
        return patientService.getPatientsByHospitalId(hospitalId);
    }

    @PutMapping("/update-patient")
    public BaseResponse updatePatient(@RequestBody PatientUpdateRequest request) {
        return patientService.updatePatient(request);
    }

    @DeleteMapping("/delete-by-id/{patientId}")
    public BaseResponse deletePatientById(@PathVariable int patientId) {
        return patientService.deletePatientById(patientId);
    }
}