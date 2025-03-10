package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Admin;

@Data
@Builder
public class AdminSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Admin admin;
}
