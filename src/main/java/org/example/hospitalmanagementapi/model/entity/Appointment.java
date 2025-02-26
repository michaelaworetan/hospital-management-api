package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Appointment {
    private int appointmentId;
    private int appointmentPatientId;
    private int appointmentDoctorId;
    private int appointmentHospitalId;
    private String appointmentDate;
    private String appointmentStatus;
    private String appointmentCreatedAt;
    private String appointmentUpdatedAt;
}
