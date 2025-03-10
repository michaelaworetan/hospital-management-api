package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.model.request.MedicationCreateRequest;
import org.example.hospitalmanagementapi.model.request.MedicationUpdateRequest;
import org.example.hospitalmanagementapi.model.response.MedicationResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.CustomMedicationListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.MedicationListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.MedicationSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository, HospitalRepository hospitalRepository) {
        this.medicationRepository = medicationRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public MedicationListResponse getAllMedications() {
        var medications =  medicationRepository.getAllMedications();
        return MedicationListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .medications(medications)
                .build();
    }

    public MedicationSingleResponse getMedicationById(int medicationId) {
        var medication = medicationRepository.getMedicationById(medicationId);
        return MedicationSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .medication(medication)
                .build();
    }

    public BaseResponse createMedication(MedicationCreateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getMedicationHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationStatus("ACTIVE");
        medicationRepository.addMedication(medication);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateMedication(int medicationId, MedicationUpdateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getMedicationHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationId(medicationId);
        medicationRepository.updateMedication(medication);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteMedicationById(int medicationId) {
        medicationRepository.deleteMedicationById(medicationId);
        return ResponseConstants.SUCCESS;
    }

    public MedicationListResponse getMedicationsByHospitalId(int hospitalId) {
        var medications =  medicationRepository.getMedicationsByHospitalId(hospitalId);
        return MedicationListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .medications(medications)
                .build();
    }

    public MedicationListResponse getExpiredMedicationsByHospitalId(int hospitalId) {
        var medications = medicationRepository.getExpiredMedicationsByHospitalId(hospitalId);
        return MedicationListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .medications(medications)
                .build();
    }

    public CustomMedicationListResponse generateMedicationSalesReport(int hospitalId) {
        var hospital = hospitalRepository.getHospitalById(hospitalId);
        if (hospital == null) {
            return CustomMedicationListResponse.builder()
                    .responseCode("106")
                    .responseMessage("Hospital not found")
                    .medications(List.of())
                    .build();
        }
        var medications =  medicationRepository.getMedicationSalesReport(hospitalId);
        return CustomMedicationListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .medications(medications)
                .build();
    }
}
