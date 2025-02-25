package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Prescription {
    private int prescriptionId;
    private String prescriptionAppointmentId;
    private String prescriptionNote;
    private String prescriptionPrescribedDate;
    private String prescriptionStatus;
    private String prescriptionCreatedAt;
    private String prescriptionUpdatedAt;
}
