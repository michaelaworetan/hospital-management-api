package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionItemService {

    private final PrescriptionItemRepository prescriptionItemRepository;

    @Autowired
    public PrescriptionItemService(PrescriptionItemRepository prescriptionItemRepository) {
        this.prescriptionItemRepository = prescriptionItemRepository;
    }

    public List<PrescriptionItem> getAllPrescriptionItems() {
        return prescriptionItemRepository.getAllPrescriptionItems();
    }

    public PrescriptionItem getPrescriptionItemById(int prescriptionItemId) {
        return prescriptionItemRepository.getPrescriptionItemById(prescriptionItemId);
    }

    public int createPrescriptionItem(PrescriptionItemCreateRequest request) {
        Gson gson = new Gson();
        PrescriptionItem prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        prescriptionItem.setPrescriptionStatus("ACTIVE");
        return prescriptionItemRepository.createPrescriptionItem(prescriptionItem);
    }

    public int updatePrescriptionItem(PrescriptionItemUpdateRequest request) {
        Gson gson = new Gson();
        PrescriptionItem prescriptionItem = gson.fromJson(gson.toJson(request), PrescriptionItem.class);
        return prescriptionItemRepository.updatePrescriptionItem(prescriptionItem);
    }

    public int deletePrescriptionItemById(int prescriptionItemId) {
        return prescriptionItemRepository.deletePrescriptionItemById(prescriptionItemId);
    }
}
