package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;

import java.util.List;

@Data
@Builder
public class AppointmentListResponse {
    private String responseCode;
    private String responseMessage;
    private List<AppointmentResponse> appointments;
}
