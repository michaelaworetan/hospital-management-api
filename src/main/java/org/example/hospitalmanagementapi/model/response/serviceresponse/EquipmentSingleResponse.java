package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Equipment;

@Data
@Builder
public class EquipmentSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Equipment equipment;
}
