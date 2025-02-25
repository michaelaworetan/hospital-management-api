package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Medication;
import java.util.List;

public interface MedicationRepository {

    int addMedication(Medication medication);

    List<Medication> getAllMedications();


    Medication getMedicationById(int medicationId);

    int updateMedication(Medication medication);


    int deleteMedicationById(int medicationId);
}
