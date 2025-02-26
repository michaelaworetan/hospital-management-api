package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.HospitalService;
import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
import org.example.hospitalmanagementapi.model.request.HospitalUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping("/create-hospital")
    public ResponseEntity<String> createHospital(@RequestBody HospitalCreateRequest request) {
        var resp = hospitalService.createHospital(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hospital creation failed");
        return ResponseEntity.ok("Hospital created successfully");
    }

    @GetMapping("/get-all-hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("/get-by-id/{hospitalId}")
    public ResponseEntity<?> getHospitalById(@PathVariable int hospitalId) {
        var resp = hospitalService.getHospitalById(hospitalId);
        if (resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hospital not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-hospital")
    public ResponseEntity<String> updateHospital(@RequestBody HospitalUpdateRequest request) {
        var resp = hospitalService.updateHospital(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hospital update failed");
        return ResponseEntity.ok("Hospital updated successfully");
    }

    @DeleteMapping("/delete-by-id/{hospitalId}")
    public ResponseEntity<String> deleteHospitalById(@PathVariable int hospitalId) {
        var resp = hospitalService.deleteHospitalById(hospitalId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hospital deletion failed");
        return ResponseEntity.ok("Hospital deleted successfully");
    }
}
