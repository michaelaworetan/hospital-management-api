package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;

import java.util.List;

@Data
@Builder
public class PrescriptionItemListResponse {
    private String responseCode;
    private String responseMessage;
    private List<PrescriptionItem> prescriptionItems;
}
