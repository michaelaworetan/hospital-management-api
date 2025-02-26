package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.AppointmentService;
import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.request.AppointmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentUpdateRequest;
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
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentCreateRequest request) {
        var resp = appointmentService.createAppointment(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Appointment failed to create");
        return ResponseEntity.ok("Appointment created successfully");
    }

    @GetMapping("/get-all-appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/get-by-id/{appointmentId}")
    public ResponseEntity<?> getAppointmentById(@PathVariable int appointmentId) {
        var resp = appointmentService.getAppointmentById(appointmentId);
        if(resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Appointment not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-appointment")
    public ResponseEntity<String> updateAppointment(@RequestBody AppointmentUpdateRequest request) {
        var resp = appointmentService.updateAppointment(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Appointment failed to update");
        return ResponseEntity.ok("Appointment updated successfully");
    }

    @DeleteMapping("/delete-by-id/{appointmentId}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable int appointmentId) {
        var resp = appointmentService.deleteAppointmentById(appointmentId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Appointment failed to delete");
        return ResponseEntity.ok("Appointment deleted successfully");
    }

    @GetMapping("/get-by-patient-id/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable int patientId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientId(patientId));
    }

    @GetMapping("/get-by-doctor-id/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable int doctorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorId(doctorId));
    }

    @GetMapping("/get-by-hospital-id/{hospitalId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByHospitalId(@PathVariable int hospitalId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByHospitalId(hospitalId));
    }
}