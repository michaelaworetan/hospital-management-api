package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
import org.example.hospitalmanagementapi.model.request.HospitalUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital getHospitalById(int hospitalId) {
        return hospitalRepository.getHospitalById(hospitalId);
    }

    public int createHospital(HospitalCreateRequest request) {
        Gson gson = new Gson();

        var hospital = gson.fromJson(gson.toJson(request), Hospital.class);
        return hospitalRepository.createHospital(hospital);
    }

    public int updateHospital(int hospitalId, HospitalUpdateRequest request) {
        Gson gson = new Gson();

        var hospital = gson.fromJson(gson.toJson(request), Hospital.class);

        // Ensure the hospitalId from the path parameter is correctly assigned
        hospital.setHospitalId(hospitalId);

        return hospitalRepository.updateHospital(hospital);
    }

    public int deleteHospitalById(int hospitalId) {
        return hospitalRepository.deleteHospitalById(hospitalId);
    }
}
