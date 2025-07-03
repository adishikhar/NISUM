package com.service.inventoryservice;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final FeatureConfig featureConfig;

    public DemoController(FeatureConfig featureConfig) {
        this.featureConfig = featureConfig;
    }

    @GetMapping("/feature")
    public String getFeatureFlag() {
        return "Discount feature enabled: " + featureConfig.isEnableDiscount();
    }
}
