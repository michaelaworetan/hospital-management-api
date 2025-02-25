package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionUpdateRequest {
    private int prescriptionId;
    private String prescriptionAppointmentId;
    private String prescriptionNote;
    private String prescriptionPrescribedDate;
    private String prescriptionStatus;
}
