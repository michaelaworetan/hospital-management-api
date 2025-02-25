package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
import org.example.hospitalmanagementapi.model.response.HospitalCreateResponse;
import org.example.hospitalmanagementapi.model.response.HospitalGetByIdResponse;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // get all hospitals
    public List<HospitalGetByIdResponse> getAllHospitals() {
        return hospitalRepository.getAllHospitals().stream()
                .map(hospital -> HospitalGetByIdResponse.builder()
                        .hospitalId(hospital.getHospitalId())
                        .hospitalName(hospital.getHospitalName())
                        .hospitalEmail(hospital.getHospitalEmail())
                        .hospitalContactNo(hospital.getHospitalContactNo())
                        .hospitalCreatedAt(hospital.getHospitalCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    // get hospital by id
    public HospitalGetByIdResponse getHospitalById(int hospitalId) {
        // Check if the hospital exists
        Hospital existingHospital = hospitalRepository.getHospitalById(hospitalId);

        if (existingHospital != null) {
            // Convert the entity to a response DTO
            return HospitalGetByIdResponse.builder()
                    .hospitalId(existingHospital.getHospitalId())
                    .hospitalName(existingHospital.getHospitalName())
                    .hospitalEmail(existingHospital.getHospitalEmail())
                    .hospitalAddress(existingHospital.getHospitalAddress())
                    .hospitalContactNo(existingHospital.getHospitalContactNo())
                    .hospitalCreatedAt(existingHospital.getHospitalUpdatedAt())
                    .build();
        }

        return null; // Return null if hospital is not found
    }

    // create hospital
    public HospitalCreateResponse createHospital(HospitalCreateRequest request) {
        Gson gson = new Gson();

        // Convert CreateRequest DTO to Hospital entity
        var hospital = gson.fromJson(gson.toJson(request), Hospital.class);

        // Insert the hospital and get the generated ID
        int hospitalId = hospitalRepository.createHospital(hospital);

        if (hospitalId < 1) {
            return null; // Return null if creation failed
        }

        // Convert back to response DTO
        return HospitalCreateResponse.builder()
                .hospitalId(hospitalId)
                .hospitalName(hospital.getHospitalName())
                .hospitalEmail(hospital.getHospitalEmail())
                .hospitalAddress(hospital.getHospitalAddress())
                .hospitalContactNo(hospital.getHospitalContactNo())
                .hospitalStatus(hospital.getHospitalStatus())
                .hospitalCreatedAt(hospital.getHospitalCreatedAt())
                .build();
    }

    // update hospital
    public int updateHospital(int hospitalId, HospitalCreateRequest request) {
        // First, check if the hospital exists
        Hospital existingHospital = hospitalRepository.getHospitalById(hospitalId);
        if (existingHospital != null) {
            // Map the update request fields to the existing hospital
            existingHospital.setHospitalName(request.getHospitalName());
            existingHospital.setHospitalEmail(request.getHospitalEmail());
            existingHospital.setHospitalAddress(request.getHospitalAddress());
            existingHospital.setHospitalContactNo(request.getHospitalContactNo());
            existingHospital.setHospitalStatus(request.getHospitalStatus());
            existingHospital.setHospitalUpdatedAt("GETDATE()");

            // Perform the update operation
            return hospitalRepository.updateHospital(existingHospital);
        }
        return 0; // Return 0 if hospital not found
    }

    // delete hospital by id
    public int deleteHospitalById(int hospitalId) {
        return hospitalRepository.deleteHospitalById(hospitalId);
    }

}
