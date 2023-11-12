package br.sp.shelcicky.viacep.domain.usecase;

import br.sp.shelcicky.viacep.domain.dataprovider.GetZipCodeDataProvider;
import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;
import br.sp.shelcicky.viacep.domain.service.ZipCodeSanitizerService;
import org.springframework.stereotype.Service;

@Service
public class GetZipCodeUseCase {
    private final ZipCodeSanitizerService sanitizerService;
    private final GetZipCodeDataProvider dataProvider;

    public GetZipCodeUseCase(ZipCodeSanitizerService sanitizerService,
                             GetZipCodeDataProvider dataProvider) {
        this.sanitizerService = sanitizerService;
        this.dataProvider = dataProvider;
    }

    public ZipCode execute(String zipCode) {
        var sanitizedZipCode = sanitizerService.execute(zipCode);
        var zip = dataProvider.execute(sanitizedZipCode);

        return zip.orElse(
                ZipCode.builder().build());
    }
}
