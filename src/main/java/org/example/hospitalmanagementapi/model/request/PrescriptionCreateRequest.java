package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PrescriptionCreateRequest {
    private int prescriptionAppointmentId;
    private String prescriptionNote;
    private String prescriptionPrescribedDate;
    private List<CustomPrescriptionItemCreateRequest> prescriptionItems;
}