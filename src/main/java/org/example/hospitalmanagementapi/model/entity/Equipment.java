package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Equipment {
    private int equipmentId;
    private int equipmentHospitalId;
    private String equipmentName;
    private String equipmentDescription;
    private int equipmentQuantity;
    private String equipmentStatus;
    private String equipmentCreatedAt;
    private String equipmentUpdatedAt;
}
