package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Doctor;

@Data
@Builder
public class DoctorSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Doctor doctor;
}
