package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.StaffService;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.response.StaffCreateResponse;
import org.example.hospitalmanagementapi.model.response.StaffGetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // Endpoint to create a staff member
    @PostMapping("/create")
    public ResponseEntity<StaffCreateResponse> createStaff(
            @RequestBody StaffCreateRequest request
    ) {
        StaffCreateResponse response = staffService.createStaff(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(response);
    }

    // Endpoint to get all staff members for a specific hospital
    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<StaffGetByIdResponse>> getStaffByHospitalId(
            @PathVariable int hospitalId
    ) {
        return ResponseEntity.ok(staffService.getStaffByHospitalId(hospitalId));
    }

    // Endpoint to get a specific staff member by ID
    @GetMapping("/{staffId}/hospital/{hospitalId}")
    public ResponseEntity<StaffGetByIdResponse> getStaffById(
            @PathVariable int staffId,
            @PathVariable int hospitalId
    ) {
        StaffGetByIdResponse staff = staffService.getStaffById(staffId, hospitalId);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(staff);
    }

    // Endpoint to update staff details
    @PutMapping("/update/{staffId}/hospital/{hospitalId}")
    public ResponseEntity<String> updateStaff(
            @PathVariable int staffId,
            @PathVariable int hospitalId,
            @RequestBody StaffCreateRequest request
    ) {
        int resp = staffService.updateStaff(staffId, hospitalId, request);
        if (resp < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found or update failed");
        }
        return ResponseEntity.ok("Staff updated successfully");
    }

    // Endpoint to delete (soft delete) a staff member by ID
    @DeleteMapping("/{staffId}/hospital/{hospitalId}")
    public ResponseEntity<String> deleteStaff(
            @PathVariable int staffId,
            @PathVariable int hospitalId
    ) {
        int updatedRows = staffService.deleteStaffById(staffId, hospitalId);

        if (updatedRows < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found or deletion failed");
        }

        return ResponseEntity.ok("Staff member removed successfully");
    }
}
