package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDateUpdateRequest {
    private int appointmentId;
    private String appointmentDate;
}
