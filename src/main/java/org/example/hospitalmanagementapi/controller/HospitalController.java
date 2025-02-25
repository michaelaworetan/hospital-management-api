package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.HospitalService;
import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
import org.example.hospitalmanagementapi.model.response.HospitalCreateResponse;
import org.example.hospitalmanagementapi.model.response.HospitalGetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

    // Endpoint to create a hospital
    @PostMapping("/create-hospital")
    public ResponseEntity<HospitalCreateResponse> createHospital(
            @RequestBody HospitalCreateRequest request
    ) {
        HospitalCreateResponse response = hospitalService.createHospital(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(response);
    }

    // Endpoint to get all hospitals
    @GetMapping
    public ResponseEntity<List<HospitalGetByIdResponse>> getHospitals() {
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    // Endpoint to get hospital by ID
    @GetMapping("/get-by-id/{hospitalId}")
    public ResponseEntity<HospitalGetByIdResponse> getHospitalById(
            @PathVariable int hospitalId
    ) {
        HospitalGetByIdResponse hospital = hospitalService.getHospitalById(hospitalId);
        if (hospital == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hospital);
    }

    // Endpoint to update hospital by ID
    @PutMapping("/update/{hospitalId}")
    public ResponseEntity<String> updateHospital(
            @PathVariable int hospitalId, @RequestBody HospitalCreateRequest request
    ) {
        int resp = hospitalService.updateHospital(hospitalId, request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital not found or update failed");
        }
        return ResponseEntity.ok("Hospital updated successfully");
    }

    // Endpoint to deactivate (soft delete) a hospital by ID
    @DeleteMapping("/{hospitalId}")
    public ResponseEntity<String> deleteHospital(
            @PathVariable int hospitalId
    ) {
        int updatedRows = hospitalService.deleteHospitalById(hospitalId);

        if (updatedRows < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital not found or update failed");
        }

        return ResponseEntity.ok("Hospital marked as 'DELETED' successfully");
    }
}
