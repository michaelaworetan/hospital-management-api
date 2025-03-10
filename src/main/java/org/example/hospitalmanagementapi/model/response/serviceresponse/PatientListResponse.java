package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Patient;

import java.util.List;

@Data
@Builder
public class PatientListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Patient> patients;

}
