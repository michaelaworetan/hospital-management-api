package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.AppointmentService;
import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.request.AppointmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentDateUpdateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentUpdateRequest;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AppointmentListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AppointmentSingleResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create-appointment")
    public BaseResponse createAppointment(@RequestBody AppointmentCreateRequest request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping("/get-all-appointments")
    public AppointmentListResponse getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/get-by-id/{appointmentId}")
    public AppointmentSingleResponse getAppointmentById(@PathVariable int appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PutMapping("/update-appointment")
    public BaseResponse updateAppointment(@RequestBody AppointmentUpdateRequest request) {
        return appointmentService.updateAppointment(request);
    }

    @PutMapping("/update-appointment-date/")
    public BaseResponse updateAppointmentDate(@RequestBody AppointmentDateUpdateRequest request) {
        return appointmentService.updateAppointmentDate(request);
    }

    @DeleteMapping("/delete-by-id/{appointmentId}")
    public BaseResponse deleteAppointmentById(@PathVariable int appointmentId) {
        return appointmentService.deleteAppointmentById(appointmentId);
    }

    @GetMapping("/get-by-patient-id/{patientId}")
    public AppointmentListResponse getAppointmentsByPatientId(@PathVariable int patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/get-by-doctor-id/{doctorId}")
    public AppointmentListResponse getAppointmentsByDoctorId(@PathVariable int doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/get-by-hospital-id/{hospitalId}")
    public AppointmentListResponse getAppointmentsByHospitalId(@PathVariable int hospitalId) {
        return appointmentService.getAppointmentsByHospitalId(hospitalId);
    }
}