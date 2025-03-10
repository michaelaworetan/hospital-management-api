package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.model.response.MedicationResponse;

import java.util.List;

public interface MedicationRepository {

    int addMedication(Medication medication);

    List<Medication> getAllMedications();

    Medication getMedicationById(int medicationId);

    int updateMedication(Medication medication);

    int updateMedicationStockQuantity(int medicationId, int medicationStockQuantity);

    List<MedicationResponse> getMedicationSalesReport(int hospitalId);

    int deleteMedicationById(int medicationId);

    List<Medication> getMedicationsByHospitalId(int medicationHospitalId);

    List<Medication> getExpiredMedicationsByHospitalId(int medicationHospitalId);
}
