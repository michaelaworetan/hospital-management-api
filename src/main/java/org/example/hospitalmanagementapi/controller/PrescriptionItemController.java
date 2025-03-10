package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.PrescriptionItemService;
    import org.example.hospitalmanagementapi.model.request.PrescriptionItemCreateRequest;
    import org.example.hospitalmanagementapi.model.request.PrescriptionItemUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.CustomPrescriptionItemListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionItemListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.PrescriptionItemSingleResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/prescription-items")
    public class PrescriptionItemController {

        private final PrescriptionItemService prescriptionItemService;

        @Autowired
        public PrescriptionItemController(PrescriptionItemService prescriptionItemService) {
            this.prescriptionItemService = prescriptionItemService;
        }

        @GetMapping("/")
        public PrescriptionItemListResponse getAllPrescriptionItems() {
            return prescriptionItemService.getAllPrescriptionItems();
        }

        @GetMapping("/{prescriptionItemId}")
        public PrescriptionItemSingleResponse getPrescriptionItemById(@PathVariable("prescriptionItemId") int id) {
            return prescriptionItemService.getPrescriptionItemById(id);
        }

        @PostMapping("/create")
        public BaseResponse createPrescriptionItem(@RequestBody PrescriptionItemCreateRequest request) {
            return prescriptionItemService.createPrescriptionItem(request);
        }

        @PutMapping("/update")
        public BaseResponse updatePrescriptionItem(@RequestBody PrescriptionItemUpdateRequest request) {
            return prescriptionItemService.updatePrescriptionItem(request);
        }

        @DeleteMapping("/delete/{prescriptionItemId}")
        public BaseResponse deletePrescriptionItem(@PathVariable("prescriptionItemId") int id) {
            return prescriptionItemService.deletePrescriptionItemById(id);
        }

        @GetMapping("/appointment/{appointmentId}")
        public CustomPrescriptionItemListResponse getPrescriptionItemsByAppointmentId(@PathVariable("appointmentId") int appointmentId) {
            return prescriptionItemService.getPrescriptionItemsByAppointmentId(appointmentId);
        }
    }