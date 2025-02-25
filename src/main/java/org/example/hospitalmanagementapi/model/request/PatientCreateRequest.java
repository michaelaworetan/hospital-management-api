package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientCreateRequest {
    private String patientName;
    private String patientDateOfBirth;
    private String patientGender;
    private String patientMedicalHistory;
}
