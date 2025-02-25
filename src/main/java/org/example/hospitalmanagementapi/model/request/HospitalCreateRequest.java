package org.example.hospitalmanagementapi.model.request;

import lombok.Data;

@Data
public class HospitalCreateRequest {
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalContactNo;
    private String hospitalEmail;
    private String hospitalStatus;
}
