package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.DoctorService;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.request.DoctorUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create-doctor")
    public ResponseEntity<String> createDoctor(
            @RequestBody DoctorCreateRequest request
    ) {
        var resp = doctorService.createDoctor(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor creation failed");
        return ResponseEntity.ok("Doctor created successfully");
    }

    @GetMapping("/get-by-hospital/{hospitalId}")
    public ResponseEntity<List<Doctor>> getDoctorsByHospitalId(
            @PathVariable int hospitalId
    ) {
        return ResponseEntity.ok(doctorService.getDoctorsByHospitalId(hospitalId));
    }

    @GetMapping("/get-by-id/{doctorId}/hospital/{hospitalId}")
    public ResponseEntity<?> getDoctorById(
            @PathVariable int doctorId, @PathVariable int hospitalId
    ) {
        var resp = doctorService.getDoctorById(doctorId, hospitalId);
        if (resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-doctor/{doctorId}/hospital/{hospitalId}")
    public ResponseEntity<String> updateDoctor(
            @PathVariable int doctorId, @PathVariable int hospitalId,
            @RequestBody DoctorUpdateRequest request
    ) {
        var resp = doctorService.updateDoctor(doctorId, hospitalId, request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor update failed");
        return ResponseEntity.ok("Doctor updated successfully");
    }

    @DeleteMapping("/delete-by-id/{doctorId}/hospital/{hospitalId}")
    public ResponseEntity<String> deleteDoctorById(
            @PathVariable int doctorId, @PathVariable int hospitalId
    ) {
        var resp = doctorService.deleteDoctorById(doctorId, hospitalId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor deletion failed");
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
