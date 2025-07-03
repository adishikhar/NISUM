package com.service.inventoryservice;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class FeatureConfig {

    @Value("${feature.enable-discount:false}")
    private boolean enableDiscount;

    public boolean isEnableDiscount() {
        return enableDiscount;
    }
}

