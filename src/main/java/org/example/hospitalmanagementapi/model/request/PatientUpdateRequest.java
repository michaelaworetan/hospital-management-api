package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientUpdateRequest {
    private int patientId;
    private String patientName;
    private String patientDateOfBirth;
    private String patientGender;
    private String patientMedicalHistory;
    private String patientStatus;
}
