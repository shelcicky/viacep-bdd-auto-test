package br.sp.shelcicky.viacep.domain.usecase;

import br.sp.shelcicky.viacep.config.ZipCodeConfig;
import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;
import br.sp.shelcicky.viacep.domain.service.ZipCodeSanitizerService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Service
@EnableConfigurationProperties({
        ZipCodeConfig.class
})
public class ZipCodeValidatorUseCase {
    private static final String ASSERT_FAIL_MESSAGE = "Some zip code property does not match!";

    private final ZipCodeSanitizerService sanitizerService;
    private final Map<String, ZipCode> zipCodes;

    public ZipCodeValidatorUseCase(ZipCodeSanitizerService sanitizerService,
                                   ZipCodeConfig zipCodeConfig) {
        this.sanitizerService = sanitizerService;
        this.zipCodes = zipCodeConfig.getZipCodes();
    }

    public void execute(String plainZipCode, ZipCode zipCode) {
        var sanitizedZipCode = sanitizerService.execute(plainZipCode);
        var expectedZipCode = zipCodes.get(sanitizedZipCode);

        assertThat(ASSERT_FAIL_MESSAGE, zipCode, is(expectedZipCode));
    }
}
