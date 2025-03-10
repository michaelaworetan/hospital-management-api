package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.SaleService;
    import org.example.hospitalmanagementapi.model.request.SaleCreateRequest;
    import org.example.hospitalmanagementapi.model.request.SaleUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.SaleListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.SaleSingleResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/sale")
    public class SaleController {
        private final SaleService saleService;

        @Autowired
        public SaleController(SaleService saleService) {
            this.saleService = saleService;
        }

        @PostMapping("/create-sale")
        public BaseResponse createSale(@RequestBody SaleCreateRequest request) {
            return saleService.createSale(request);
        }

        @GetMapping("/get-all-sales")
        public SaleListResponse getAllSales() {
            return saleService.getAllSales();
        }

        @GetMapping("/get-by-id/{salesId}")
        public SaleSingleResponse getSaleById(@PathVariable int salesId) {
            return saleService.getSaleById(salesId);
        }

        @GetMapping("/get-by-hospital/{saleHospitalId}")
        public SaleListResponse getSalesByHospitalId(@PathVariable int saleHospitalId) {
            return saleService.getSalesByHospitalId(saleHospitalId);
        }

        @PutMapping("/update-sale")
        public BaseResponse updateSale(@RequestBody SaleUpdateRequest request) {
            return saleService.updateSale(request);
        }

        @DeleteMapping("/delete-by-id/{salesId}")
        public BaseResponse deleteSaleById(@PathVariable int salesId) {
            return saleService.deleteSaleById(salesId);
        }
    }