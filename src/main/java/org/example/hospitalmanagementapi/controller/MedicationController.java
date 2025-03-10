package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.MedicationService;
    import org.example.hospitalmanagementapi.model.request.MedicationCreateRequest;
    import org.example.hospitalmanagementapi.model.request.MedicationUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.CustomMedicationListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.MedicationListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.MedicationSingleResponse;
    import org.example.hospitalmanagementapi.model.response.MedicationResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/medications")
    public class MedicationController {

        private final MedicationService medicationService;

        @Autowired
        public MedicationController(MedicationService medicationService) {
            this.medicationService = medicationService;
        }

        @GetMapping("/")
        public MedicationListResponse getAllMedications() {
            return medicationService.getAllMedications();
        }

        @GetMapping("/{medicationId}")
        public MedicationSingleResponse getMedicationById(@PathVariable("medicationId") int id) {
            return medicationService.getMedicationById(id);
        }

        @PostMapping("/create-medication")
        public BaseResponse createMedication(@RequestBody MedicationCreateRequest request) {
            return medicationService.createMedication(request);
        }

        @PutMapping("/update/{medicationId}")
        public BaseResponse updateMedication(@PathVariable("medicationId") int id,
                                             @RequestBody MedicationUpdateRequest request) {
            return medicationService.updateMedication(id, request);
        }

        @DeleteMapping("/delete/{medicationId}")
        public BaseResponse deleteMedication(@PathVariable("medicationId") int id) {
            return medicationService.deleteMedicationById(id);
        }

        @GetMapping("/hospital/{hospitalId}")
        public MedicationListResponse getMedicationsByHospitalId(@PathVariable("hospitalId") int hospitalId) {
            return medicationService.getMedicationsByHospitalId(hospitalId);
        }

        @GetMapping("/hospital/{hospitalId}/expired")
        public MedicationListResponse getExpiredMedicationsByHospitalId(@PathVariable("hospitalId") int hospitalId) {
            return medicationService.getExpiredMedicationsByHospitalId(hospitalId);
        }

        @GetMapping("/hospital/{hospitalId}/report")
        public CustomMedicationListResponse generateMedicationSalesReport(@PathVariable("hospitalId") int hospitalId) {
            return medicationService.generateMedicationSalesReport(hospitalId);
        }
    }