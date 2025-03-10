package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Data;
import lombok.Builder;
import org.example.hospitalmanagementapi.model.entity.Equipment;

import java.util.List;

@Data
@Builder
public class EquipmentListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Equipment> equipments;
}
