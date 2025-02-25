package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalContactNo;
    private String hospitalEmail;
    private String hospitalStatus;
    private String hospitalCreatedAt;
    private String hospitalUpdatedAt;
}
