package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.StaffService;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.StaffListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.StaffSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/create-staff")
    public BaseResponse createStaff(@RequestBody StaffCreateRequest request) {
        return staffService.createStaff(request);
    }

    @GetMapping("/get-all-staff")
    public StaffListResponse getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/get-by-id/{staffId}")
    public StaffSingleResponse getStaffById(@PathVariable int staffId) {
        return staffService.getStaffById(staffId);
    }

    @GetMapping("/get-all-staff-by-hospital-id/{hospitalId}")
    public StaffListResponse getAllStaffByHospitalId(@PathVariable int hospitalId) {
        return staffService.getAllStaffByHospitalId(hospitalId);
    }

    @PutMapping("/update-staff")
    public BaseResponse updateStaff(@RequestBody StaffUpdateRequest request) {
        return staffService.updateStaff(request);
    }

    @DeleteMapping("/delete-by-id/{staffId}")
    public BaseResponse deleteStaffById(@PathVariable int staffId) {
        return staffService.deleteStaffById(staffId);
    }

    @GetMapping("/get-staff-by-salary-range")
    public StaffListResponse getStaffBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        return staffService.getStaffBySalaryRange(minSalary, maxSalary);
    }
}