package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.PrescriptionService;
import org.example.hospitalmanagementapi.model.entity.Prescription;
import org.example.hospitalmanagementapi.model.request.PrescriptionCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("prescriptionId") int id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        if (prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPrescription(@RequestBody PrescriptionCreateRequest request) {
        int result = prescriptionService.createPrescription(request);
        if (result > 0) {
            return new ResponseEntity<>("Prescription created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create prescription", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePrescription(@RequestBody PrescriptionUpdateRequest request) {
        int result = prescriptionService.updatePrescription(request);
        if (result > 0) {
            return new ResponseEntity<>("Prescription updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update prescription", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{prescriptionId}")
    public ResponseEntity<String> deletePrescription(@PathVariable("prescriptionId") int id) {
        int result = prescriptionService.deletePrescriptionById(id);
        if (result > 0) {
            return new ResponseEntity<>("Prescription deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete prescription", HttpStatus.BAD_REQUEST);
        }
    }
}
