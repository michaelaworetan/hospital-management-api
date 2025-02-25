package org.example.hospitalmanagementapi.model.entity;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
public class Staff {
    private int staffId;
    private int staffHospitalId;
    private String staffName;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
    private String staffStatus;
    private String staffCreatedAt;
    private String staffUpdatedAt;
}