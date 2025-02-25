package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Prescription;
import org.example.hospitalmanagementapi.model.request.PrescriptionCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.getAllPrescriptions();
    }

    public Prescription getPrescriptionById(int prescriptionId) {
        return prescriptionRepository.getPrescriptionById(prescriptionId);
    }

    public int createPrescription(PrescriptionCreateRequest request) {
        Gson gson = new Gson();
        var prescription = gson.fromJson(gson.toJson(request), Prescription.class);
        prescription.setPrescriptionStatus("ACTIVE");
        return prescriptionRepository.createPrescription(prescription);
    }

    public int updatePrescription(PrescriptionUpdateRequest request) {
        Gson gson = new Gson();
        var prescription = gson.fromJson(gson.toJson(request), Prescription.class);
        return prescriptionRepository.updatePrescription(prescription);
    }

    public int deletePrescriptionById(int prescriptionId) {
        return prescriptionRepository.deletePrescriptionById(prescriptionId);
    }
}
