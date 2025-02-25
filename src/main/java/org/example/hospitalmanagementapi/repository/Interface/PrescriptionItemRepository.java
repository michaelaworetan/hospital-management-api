package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import java.util.List;

public interface PrescriptionItemRepository {

    int createPrescriptionItem(PrescriptionItem prescriptionItem);

    List<PrescriptionItem> getAllPrescriptionItems();

    PrescriptionItem getPrescriptionItemById(int prescriptionItemId);

    int updatePrescriptionItem(PrescriptionItem prescriptionItem);

    int deletePrescriptionItemById(int prescriptionItemId);
}
