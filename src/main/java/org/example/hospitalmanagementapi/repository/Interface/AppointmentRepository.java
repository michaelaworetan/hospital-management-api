package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;

import java.util.List;

public interface AppointmentRepository {
    List<AppointmentResponse> getAllAppointments();

    AppointmentResponse getAppointmentById(int appointmentId);

    int createAppointment(Appointment appointment);

    int updateAppointment(Appointment appointment);

    int updateAppointmentDate(int appointmentId, String appointmentDate);

    int deleteAppointmentById(int appointmentId);

    List<AppointmentResponse> getAppointmentsByPatientId(int patientId);

    List<AppointmentResponse> getAppointmentsByDoctorId(int doctorId);

    List<AppointmentResponse> getAppointmentsByHospitalId(int hospitalId);
}
