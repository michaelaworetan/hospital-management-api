package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentCreateRequest {
    private int appointmentPatientId;
    private int appointmentDoctorId;
    private String appointmentDate;
}
