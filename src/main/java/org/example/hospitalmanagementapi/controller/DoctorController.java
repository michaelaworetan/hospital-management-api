package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.DoctorService;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.response.DoctorCreateResponse;
import org.example.hospitalmanagementapi.model.response.DoctorGetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Endpoint to create a doctor
    @PostMapping("/create")
    public ResponseEntity<DoctorCreateResponse> createDoctor(
            @RequestBody DoctorCreateRequest request
    ) {
        DoctorCreateResponse response = doctorService.createDoctor(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(response);
    }


    // Endpoint to get a specific doctor by ID
    @GetMapping("/{doctorId}/staff/{doctorStaffId}")
    public ResponseEntity<DoctorGetByIdResponse> getDoctorById(
            @PathVariable int doctorId,
            @PathVariable int doctorStaffId
    ) {
        DoctorGetByIdResponse doctor = doctorService.getDoctorById(doctorId, doctorStaffId);
        if (doctor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(doctor);
    }

    // Endpoint to update doctor details
    @PutMapping("/update/{doctorId}/staff/{doctorStaffId}")
    public ResponseEntity<String> updateDoctor(
            @PathVariable int doctorId,
            @PathVariable int doctorStaffId,
            @RequestBody DoctorCreateRequest request
    ) {
        int resp = doctorService.updateDoctor(doctorId, doctorStaffId, request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found or update failed");
        }
        return ResponseEntity.ok("Doctor updated successfully");
    }

    // Endpoint to delete a doctor by ID
    @DeleteMapping("/{doctorId}/staff/{doctorStaffId}")
    public ResponseEntity<String> deleteDoctor(
            @PathVariable int doctorId,
            @PathVariable int doctorStaffId
    ) {
        int updatedRows = doctorService.deleteDoctorById(doctorId, doctorStaffId);

        if (updatedRows < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found or deletion failed");
        }

        return ResponseEntity.ok("Doctor removed successfully");
    }
}
