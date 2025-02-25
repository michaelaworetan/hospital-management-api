package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipmentCreateRequest {
    private int equipmentHospitalId;
    private String equipmentName;
    private String equipmentDescription;
    private int equipmentQuantity;
}
