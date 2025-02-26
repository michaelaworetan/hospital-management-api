package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.StaffService;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create-staff")
    public ResponseEntity<String> createStaff(@RequestBody StaffCreateRequest request) {
        var resp = staffService.createStaff(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Staff creation failed");
        return ResponseEntity.ok("Staff created successfully");
    }

    @GetMapping("/get-all-staff")
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @GetMapping("/get-by-id/{staffId}")
    public ResponseEntity<?> getStaffById(@PathVariable int staffId) {
        var resp = staffService.getStaffById(staffId);
        if (resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Staff not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-staff")
    public ResponseEntity<String> updateStaff(@RequestBody StaffUpdateRequest request) {
        var resp = staffService.updateStaff(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Staff update failed");
        return ResponseEntity.ok("Staff updated successfully");
    }

    @DeleteMapping("/delete-by-id/{staffId}")
    public ResponseEntity<String> deleteStaffById(@PathVariable int staffId) {
        var resp = staffService.deleteStaffById(staffId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Staff deletion failed");
        return ResponseEntity.ok("Staff deleted successfully");
    }
}
