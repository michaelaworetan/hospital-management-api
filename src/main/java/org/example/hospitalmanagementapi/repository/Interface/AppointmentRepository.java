package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int appointmentId);

    int createAppointment(Appointment appointment);

    int updateAppointment(Appointment appointment);

    int deleteAppointmentById(int appointmentId);

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByDoctorId(int doctorId);

    List<Appointment> getAppointmentsByHospitalId(int hospitalId);
}
