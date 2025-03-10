package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.DoctorService;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.request.DoctorUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorDetailsListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorSingleResponse;
import org.example.hospitalmanagementapi.model.response.DoctorDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BaseResponse createDoctor(@RequestBody DoctorCreateRequest request) {
        return doctorService.createDoctor(request);
    }

    @GetMapping("/get-all-doctors")
    public DoctorListResponse getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/get-by-id/{doctorId}")
    public DoctorSingleResponse getDoctorById(@PathVariable int doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @PutMapping("/update-doctor")
    public BaseResponse updateDoctor(@RequestBody DoctorUpdateRequest request) {
        return doctorService.updateDoctor(request);
    }

    @DeleteMapping("/delete-by-staff-id/{doctorStaffId}")
    public BaseResponse deleteDoctorByStaffId(@PathVariable int doctorStaffId) {
        return doctorService.deleteDoctorByStaffId(doctorStaffId);
    }

    @GetMapping("/get-doctor-details-by-hospital/{hospitalId}")
    public DoctorDetailsListResponse getDoctorDetailsByHospitalId(@PathVariable int hospitalId) {
        return doctorService.getDoctorDetailsByHospitalId(hospitalId);
    }
}