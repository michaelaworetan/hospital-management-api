package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.AdminService;
import org.example.hospitalmanagementapi.model.entity.Admin;
import org.example.hospitalmanagementapi.model.request.AdminCreateRequest;
import org.example.hospitalmanagementapi.model.request.AdminUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody AdminCreateRequest request) {
        var resp = adminService.createAdmin(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin failed to create");
        return ResponseEntity.ok("Admin created successfully");
    }

    @GetMapping("/get-all-admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/get-by-id/{adminId}")
    public ResponseEntity<?> getAdminById(@PathVariable int adminId) {
        var resp = adminService.getAdminById(adminId);
        if(resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-admin")
    public ResponseEntity<String> updateAdmin(@RequestBody AdminUpdateRequest request) {
        var resp = adminService.updateAdmin(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin failed to update");
        return ResponseEntity.ok("Admin updated successfully");
    }

    @DeleteMapping("/delete-by-id/{adminId}")
    public ResponseEntity<String> deleteAdminById(@PathVariable int adminId) {
        var resp = adminService.deleteAdminById(adminId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin failed to delete");
        return ResponseEntity.ok("Admin deleted successfully");
    }

}
