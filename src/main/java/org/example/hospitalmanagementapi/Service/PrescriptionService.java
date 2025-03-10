package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Prescription;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.request.PrescriptionCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    private final PrescriptionItemRepository prescriptionItemRepository;

    private final MedicationRepository medicationRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, PrescriptionItemRepository prescriptionItemRepository, MedicationRepository medicationRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionItemRepository = prescriptionItemRepository;
        this.medicationRepository = medicationRepository;
    }

    public PrescriptionListResponse getAllPrescriptions() {
        var prescriptions = prescriptionRepository.getAllPrescriptions();
        return PrescriptionListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .prescriptions(prescriptions)
                .build();
    }

    public PrescriptionSingleResponse getPrescriptionById(int prescriptionId) {
        var prescription = prescriptionRepository.getPrescriptionById(prescriptionId);
        return PrescriptionSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .prescription(prescription)
                .build();
    }

    public BaseResponse createPrescription(PrescriptionCreateRequest request) {
        Gson gson = new Gson();
        //create the prescription row
        var prescription = gson.fromJson(gson.toJson(request), Prescription.class);
        var prescriptionId =  prescriptionRepository.createPrescription(prescription);
        //create the prescription items using for each loop
        for(var item : request.getPrescriptionItems()) {
            //creating each item but converting to prescription item class first
            var prescriptionItem = gson.fromJson(gson.toJson(item), PrescriptionItem.class);
            prescriptionItem.setPrescriptionItemPrescriptionId(prescriptionId);
            var medication = medicationRepository.getMedicationById(item.getPrescriptionItemMedicationId());
            //validating if the medication exists
            if (medication == null) {
                return new BaseResponse("106", "Medication not found");
            }
            var remainingStock = medication.getMedicationStockQuantity() - item.getPrescriptionItemQuantity();
            //validating if the stock is enough
            if (remainingStock < 0) {
                return new BaseResponse("106", "Stock not enough");
            }
//            medication.setMedicationStockQuantity(remainingStock);
//            medicationRepository.updateMedication(medication);
            prescriptionItemRepository.createPrescriptionItem(prescriptionItem);
        }
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updatePrescription(PrescriptionUpdateRequest request) {
        Gson gson = new Gson();
        var prescription = gson.fromJson(gson.toJson(request), Prescription.class);
        prescriptionRepository.updatePrescription(prescription);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deletePrescriptionById(int prescriptionId) {
        prescriptionRepository.deletePrescriptionById(prescriptionId);
        return ResponseConstants.SUCCESS;
    }
}
