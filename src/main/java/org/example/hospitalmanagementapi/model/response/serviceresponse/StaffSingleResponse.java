package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Staff;

@Data
@Builder
public class StaffSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Staff staff;
}
