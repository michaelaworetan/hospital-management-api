package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Patient;

@Data
@Builder
public class PatientSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Patient patient;
}
