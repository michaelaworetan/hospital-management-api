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
    public ResponseEntity<String> createDoctor(@RequestBody DoctorCreateRequest request) {
        var resp = doctorService.createDoctor(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor creation failed");
        return ResponseEntity.ok("Doctor created successfully");
    }

    @GetMapping("/get-all-doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/get-by-id/{doctorId}")
    public ResponseEntity<?> getDoctorById(@PathVariable int doctorId) {
        var resp = doctorService.getDoctorById(doctorId);
        if (resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-doctor")
    public ResponseEntity<String> updateDoctor(@RequestBody DoctorUpdateRequest request) {
        var resp = doctorService.updateDoctor(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor update failed");
        return ResponseEntity.ok("Doctor updated successfully");
    }

    @DeleteMapping("/delete-by-id/{doctorId}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable int doctorId) {
        var resp = doctorService.deleteDoctorById(doctorId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor deletion failed");
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
