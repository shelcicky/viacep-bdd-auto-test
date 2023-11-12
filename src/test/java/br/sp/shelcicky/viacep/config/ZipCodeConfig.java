package br.sp.shelcicky.viacep.config;

import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "config")
public class ZipCodeConfig {
    private final Map<String, ZipCode> zipCodes;

    public ZipCodeConfig(Map<String, ZipCode> zipCodes) {
        this.zipCodes = zipCodes;
    }

    public Map<String, ZipCode> getZipCodes() {
        return zipCodes;
    }
}
