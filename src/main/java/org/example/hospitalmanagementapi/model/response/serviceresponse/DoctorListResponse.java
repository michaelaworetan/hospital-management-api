package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Doctor;

import java.util.List;

@Data
@Builder
public class DoctorListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Doctor> doctors;
}
