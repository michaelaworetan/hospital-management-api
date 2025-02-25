package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.MedicationService;
import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.model.request.MedicationCreateRequest;
import org.example.hospitalmanagementapi.model.request.MedicationUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> medications = medicationService.getAllMedications();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable("medicationId") int id) {
        Medication medication = medicationService.getMedicationById(id);
        if (medication == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    @PostMapping("/create-medication")
    public ResponseEntity<String> createMedication(@RequestBody MedicationCreateRequest request) {
        int result = medicationService.createMedication(request);
        if (result > 0) {
            return new ResponseEntity<>("Medication created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create medication", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{medicationId}")
    public ResponseEntity<String> updateMedication(@PathVariable("medicationId") int id,
                                                   @RequestBody MedicationUpdateRequest request) {
        int result = medicationService.updateMedication(id, request);
        if (result > 0) {
            return new ResponseEntity<>("Medication updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update medication", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable("medicationId") int id) {
        int result = medicationService.deleteMedicationById(id);
        if (result > 0) {
            return new ResponseEntity<>("Medication deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete medication", HttpStatus.BAD_REQUEST);
        }
    }
}
