package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipmentUpdateRequest {
    private int equipmentId;
    private int equipmentHospitalId;
    private String equipmentName;
    private String equipmentDescription;
    private int equipmentQuantity;
    private String EquipmentStatus;
}

