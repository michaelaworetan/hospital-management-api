package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Patient {
    private int patientId;
    private String patientName;
    private String patientDateOfBirth;
    private String patientGender;
    private String patientMedicalHistory;
    private String patientStatus;
    private String patientCreatedAt;
    private String patientUpdatedAt;
}
