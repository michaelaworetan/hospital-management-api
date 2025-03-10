package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.AdminService;
import org.example.hospitalmanagementapi.model.entity.Admin;
import org.example.hospitalmanagementapi.model.request.AdminCreateRequest;
import org.example.hospitalmanagementapi.model.request.AdminUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AdminListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AdminSingleResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
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
    public BaseResponse createAdmin(@RequestBody AdminCreateRequest request) {
        return adminService.createAdmin(request);
    }

    @GetMapping("/get-all-admins")
    public AdminListResponse getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/get-by-id/{adminId}")
    public AdminSingleResponse getAdminById(@PathVariable int adminId) {
        return adminService.getAdminById(adminId);
    }

    @PutMapping("/update-admin")
    public BaseResponse updateAdmin(@RequestBody AdminUpdateRequest request) {
        return adminService.updateAdmin(request);
    }

    @DeleteMapping("/delete-by-id/{adminId}")
    public BaseResponse deleteAdminById(@PathVariable int adminId) {
        return adminService.deleteAdminById(adminId);
    }

}
