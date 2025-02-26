package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentResponse {
    private int appointmentId;
    private int appointmentPatientId;
    private int appointmentDoctorId;
    private int appointmentHospitalId;
    private String appointmentDate;
    private String appointmentStatus;
    private String appointmentCreatedAt;
    private String appointmentUpdatedAt;
    private String appointmentPatientName;
    private String appointmentDoctorName;
}
