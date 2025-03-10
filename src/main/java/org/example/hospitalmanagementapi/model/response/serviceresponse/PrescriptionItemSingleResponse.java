package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;

@Data
@Builder
public class PrescriptionItemSingleResponse {
    private String responseCode;
    private String responseMessage;
    private PrescriptionItem prescriptionItem;
}
