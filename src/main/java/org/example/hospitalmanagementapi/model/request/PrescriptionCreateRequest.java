package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionCreateRequest {
    private String prescriptionNote;
    private String prescriptionPrescribedDate;
}
