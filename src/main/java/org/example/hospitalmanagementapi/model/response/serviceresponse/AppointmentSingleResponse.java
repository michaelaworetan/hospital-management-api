package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;

@Data
@Builder
public class AppointmentSingleResponse {
    private String responseCode;
    private String responseMessage;
    private AppointmentResponse appointment;
}
