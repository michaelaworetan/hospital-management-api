package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemUpdateRequest;
import org.example.hospitalmanagementapi.model.response.PrescriptionItemResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.CustomPrescriptionItemListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionItemListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionItemSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionItemService {

    private final PrescriptionItemRepository prescriptionItemRepository;
    private final MedicationRepository medicationRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionItemService(PrescriptionItemRepository prescriptionItemRepository,
                                   MedicationRepository medicationRepository, PrescriptionRepository prescriptionRepository) {
        this.prescriptionItemRepository = prescriptionItemRepository;
        this.medicationRepository = medicationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public PrescriptionItemListResponse getAllPrescriptionItems() {
        var prescriptionItems = prescriptionItemRepository.getAllPrescriptionItems();

        return PrescriptionItemListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .prescriptionItems(prescriptionItems)
                .build();
    }

    public PrescriptionItemSingleResponse getPrescriptionItemById(int prescriptionItemId) {
        var prescriptionItem = prescriptionItemRepository.getPrescriptionItemById(prescriptionItemId);

        return PrescriptionItemSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .prescriptionItem(prescriptionItem)
                .build();
    }

    public BaseResponse createPrescriptionItem(PrescriptionItemCreateRequest request) {
        Gson gson = new Gson();
        var medication = medicationRepository.getMedicationById(request.getPrescriptionItemMedicationId());
        var prescription = prescriptionRepository.getPrescriptionById(request.getPrescriptionItemPrescriptionId());
        if (medication == null) {
            return new BaseResponse("106", "Medication not found");
        }
        if(prescription == null){
            return new BaseResponse("106", "Prescription not found");
        }
        var prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        prescriptionItem.setPrescriptionItemStatus("ACTIVE");
        prescriptionItemRepository.createPrescriptionItem(prescriptionItem);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updatePrescriptionItem(PrescriptionItemUpdateRequest request) {
        Gson gson = new Gson();
        var prescription = prescriptionRepository.getPrescriptionById(request.getPrescriptionItemPrescriptionId());
        var medication = medicationRepository.getMedicationById(request.getPrescriptionItemMedicationId());
        if (medication == null) {
            return new BaseResponse("106", "Medication not found");
        }
        if(prescription == null){
            return new BaseResponse("106", "Prescription not found");
        }
        var prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        prescriptionItemRepository.updatePrescriptionItem(prescriptionItem);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deletePrescriptionItemById(int prescriptionItemId) {
        prescriptionItemRepository.deletePrescriptionItemById(prescriptionItemId);
        return ResponseConstants.SUCCESS;
    }

    public CustomPrescriptionItemListResponse getPrescriptionItemsByAppointmentId(int appointmentId) {
        var prescriptionItems = prescriptionItemRepository.getPrescriptionItemsByAppointmentId(appointmentId);

        return CustomPrescriptionItemListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .prescriptionItemResponses(prescriptionItems)
                .build();
    }
}
