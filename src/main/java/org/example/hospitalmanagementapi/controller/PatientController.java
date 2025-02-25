package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.PatientService;
import org.example.hospitalmanagementapi.model.entity.Patient;
import org.example.hospitalmanagementapi.model.request.PatientCreateRequest;
import org.example.hospitalmanagementapi.model.request.PatientUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create-patient")
    public ResponseEntity<String> createPatient(@RequestBody PatientCreateRequest request) {
        var resp = patientService.createPatient(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient failed to create");
        return ResponseEntity.ok("Patient created successfully");
    }

    @GetMapping("/get-all-patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/get-by-id/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable int patientId) {
        var resp = patientService.getPatientById(patientId);
        if(resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-patient")
    public ResponseEntity<String> updatePatient(@RequestBody PatientUpdateRequest request) {
        var resp = patientService.updatePatient(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient failed to update");
        return ResponseEntity.ok("Patient updated successfully");
    }

    @DeleteMapping("/delete-by-id/{patientId}")
    public ResponseEntity<String> deletePatientById(@PathVariable int patientId) {
        var resp = patientService.deletePatientById(patientId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient failed to delete");
        return ResponseEntity.ok("Patient deleted successfully");
    }
}