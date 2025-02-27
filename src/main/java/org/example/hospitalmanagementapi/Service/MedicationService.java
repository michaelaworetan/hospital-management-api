package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.model.request.MedicationCreateRequest;
import org.example.hospitalmanagementapi.model.request.MedicationUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
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

    public List<Medication> getAllMedications() {
        return medicationRepository.getAllMedications();
    }

    public Medication getMedicationById(int medicationId) {
        return medicationRepository.getMedicationById(medicationId);
    }

    public int createMedication(MedicationCreateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getMedicationHospitalId());
        if (hospital == null) {
            return -1;
        }
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationStatus("ACTIVE");
        return medicationRepository.addMedication(medication);
    }

    public int updateMedication(int medicationId, MedicationUpdateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getMedicationHospitalId());
        if (hospital == null) {
            return -1;
        }
        var medication = gson.fromJson(gson.toJson(request), Medication.class);
        medication.setMedicationId(medicationId);
        return medicationRepository.updateMedication(medication);
    }

    public int deleteMedicationById(int medicationId) {
        return medicationRepository.deleteMedicationById(medicationId);
    }

    public List<Medication> getMedicationsByHospitalId(int hospitalId) {
        return medicationRepository.getMedicationsByHospitalId(hospitalId);
    }

    public List<Medication> getExpiredMedicationsByHospitalId(int hospitalId) {
        return medicationRepository.getExpiredMedicationsByHospitalId(hospitalId);
    }
}
