package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Staff;

import java.util.List;

@Data
@Builder
public class StaffListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Staff> staffs;
}
