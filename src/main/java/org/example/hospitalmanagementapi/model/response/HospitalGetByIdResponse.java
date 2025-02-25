package org.example.hospitalmanagementapi.model.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalGetByIdResponse {
    private int hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalEmail;
    private String hospitalContactNo;
    private String hospitalCreatedAt;
}
