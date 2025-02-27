package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemUpdateRequest;
import org.example.hospitalmanagementapi.model.response.PrescriptionItemResponse;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionItemService {

    private final PrescriptionItemRepository prescriptionItemRepository;
    private final MedicationRepository medicationRepository;

    @Autowired
    public PrescriptionItemService(PrescriptionItemRepository prescriptionItemRepository,
                                   MedicationRepository medicationRepository) {
        this.prescriptionItemRepository = prescriptionItemRepository;
        this.medicationRepository = medicationRepository;
    }

    public List<PrescriptionItem> getAllPrescriptionItems() {
        return prescriptionItemRepository.getAllPrescriptionItems();
    }

    public PrescriptionItem getPrescriptionItemById(int prescriptionItemId) {
        return prescriptionItemRepository.getPrescriptionItemById(prescriptionItemId);
    }

    public int createPrescriptionItem(PrescriptionItemCreateRequest request) {
        Gson gson = new Gson();
        var medication = medicationRepository.getMedicationById(request.getPrescriptionItemMedicationId());
        if (medication == null) {
            return -1;
        }
        var prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        prescriptionItem.setPrescriptionItemStatus("ACTIVE");
        return prescriptionItemRepository.createPrescriptionItem(prescriptionItem);
    }

    public int updatePrescriptionItem(PrescriptionItemUpdateRequest request) {
        Gson gson = new Gson();
        var medication = medicationRepository.getMedicationById(request.getPrescriptionItemMedicationId());
        if (medication == null) {
            return -1;
        }
        var prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        return prescriptionItemRepository.updatePrescriptionItem(prescriptionItem);
    }

    public int deletePrescriptionItemById(int prescriptionItemId) {
        return prescriptionItemRepository.deletePrescriptionItemById(prescriptionItemId);
    }

    public List<PrescriptionItemResponse> getPrescriptionItemsByAppointmentId(int appointmentId) {
        return prescriptionItemRepository.getPrescriptionItemsByAppointmentId(appointmentId);
    }
}
