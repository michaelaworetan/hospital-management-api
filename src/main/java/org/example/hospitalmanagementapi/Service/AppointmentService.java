package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.request.AppointmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.AppointmentRepository;
import org.example.hospitalmanagementapi.repository.Interface.PatientRepository;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId);
    }

    public int createAppointment(AppointmentCreateRequest request) {
        Gson gson = new Gson();
        var patient = patientRepository.getPatientById(request.getAppointmentPatientId());
        var doctor = doctorRepository.getDoctorById(request.getAppointmentDoctorId());
        if (patient == null || doctor == null) {
            return -1;
        }
        var appointment = gson.fromJson(gson.toJson(request), Appointment.class);
        return appointmentRepository.createAppointment(appointment);
    }

    public int updateAppointment(AppointmentUpdateRequest request) {
        Gson gson = new Gson();
        var patient = patientRepository.getPatientById(request.getAppointmentPatientId());
        var doctor = doctorRepository.getDoctorById(request.getAppointmentDoctorId());
        if (patient == null || doctor == null) {
            return -1;
        }
        var appointment = gson.fromJson(gson.toJson(request), Appointment.class);
        return appointmentRepository.updateAppointment(appointment);
    }

    public int deleteAppointmentById(int appointmentId) {
        return appointmentRepository.deleteAppointmentById(appointmentId);
    }
}
