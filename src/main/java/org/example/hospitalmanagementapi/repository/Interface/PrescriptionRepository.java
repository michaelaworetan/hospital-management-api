package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Prescription;
import java.util.List;

public interface PrescriptionRepository {

    int createPrescription(Prescription prescription);

    List<Prescription> getAllPrescriptions();

    Prescription getPrescriptionById(int prescriptionId);

    int updatePrescription(Prescription prescription);

    int deletePrescriptionById(int prescriptionId);
}
