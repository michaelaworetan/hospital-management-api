package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.PrescriptionService;
    import org.example.hospitalmanagementapi.model.request.PrescriptionCreateRequest;
    import org.example.hospitalmanagementapi.model.request.PrescriptionUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionSingleResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/prescriptions")
    public class PrescriptionController {

        private final PrescriptionService prescriptionService;

        @Autowired
        public PrescriptionController(PrescriptionService prescriptionService) {
            this.prescriptionService = prescriptionService;
        }

        @GetMapping("/")
        public PrescriptionListResponse getAllPrescriptions() {
            return prescriptionService.getAllPrescriptions();
        }

        @GetMapping("/{prescriptionId}")
        public PrescriptionSingleResponse getPrescriptionById(@PathVariable("prescriptionId") int id) {
            return prescriptionService.getPrescriptionById(id);
        }

        @PostMapping("/create")
        public BaseResponse createPrescription(@RequestBody PrescriptionCreateRequest request) {
            return prescriptionService.createPrescription(request);
        }

        @PutMapping("/update")
        public BaseResponse updatePrescription(@RequestBody PrescriptionUpdateRequest request) {
            return prescriptionService.updatePrescription(request);
        }

        @DeleteMapping("/delete/{prescriptionId}")
        public BaseResponse deletePrescription(@PathVariable("prescriptionId") int id) {
            return prescriptionService.deletePrescriptionById(id);
        }
    }