package org.example.hospitalmanagementapi.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StaffCreateRequest {
    private int staffHospitalId;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
    private String staffStatus;
}