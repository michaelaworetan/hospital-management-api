package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.model.request.MedicationCreateRequest;
import org.example.hospitalmanagementapi.model.request.MedicationUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.getAllMedications();
    }

    public Medication getMedicationById(int medicationId) {
        return medicationRepository.getMedicationById(medicationId);
    }

    public int createMedication(MedicationCreateRequest request) {
        Gson gson = new Gson();
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationStatus("ACTIVE");
        return medicationRepository.addMedication(medication);
    }

    public int updateMedication(int medicationId, MedicationUpdateRequest request) {
        Gson gson = new Gson();
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationId(medicationId);
        return medicationRepository.updateMedication(medication);
    }

    public int deleteMedicationById(int medicationId) {
        return medicationRepository.deleteMedicationById(medicationId);
    }
}
