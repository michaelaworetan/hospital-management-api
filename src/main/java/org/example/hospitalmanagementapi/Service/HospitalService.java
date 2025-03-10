package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
import org.example.hospitalmanagementapi.model.request.HospitalUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.HospitalListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.HospitalSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalListResponse getAllHospitals() {
        var hospitals =  hospitalRepository.getAllHospitals();

        return HospitalListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .hsopitals(hospitals)
                .build();
    }

    public HospitalSingleResponse getHospitalById(int hospitalId) {
        var hospital =  hospitalRepository.getHospitalById(hospitalId);
        return HospitalSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .hospital(hospital)
                .build();
    }

    public BaseResponse createHospital(HospitalCreateRequest request) {
        Gson gson = new Gson();
        var hospital = gson.fromJson(gson.toJson(request), Hospital.class);
        hospitalRepository.createHospital(hospital);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateHospital(HospitalUpdateRequest request) {
        Gson gson = new Gson();
        var hospital = gson.fromJson(gson.toJson(request), Hospital.class);
        hospitalRepository.updateHospital(hospital);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteHospitalById(int hospitalId) {
        hospitalRepository.deleteHospitalById(hospitalId);
        return ResponseConstants.SUCCESS;
    }
}
