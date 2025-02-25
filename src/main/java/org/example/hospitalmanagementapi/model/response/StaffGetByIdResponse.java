package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class StaffGetByIdResponse {
    private int staffId;
    private int staffHospitalId;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
    private String staffStatus;
    private String staffCreatedAt;
    private String staffUpdatedAt;
}
