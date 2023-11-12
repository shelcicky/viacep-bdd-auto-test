package br.sp.shelcicky.viacep.dataprovider;

import br.sp.shelcicky.viacep.dataprovider.service.RestService;
import br.sp.shelcicky.viacep.domain.dataprovider.GetZipCodeDataProvider;
import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetZipCodeDataProviderImpl implements GetZipCodeDataProvider {
    private static final String ZIP_CODE_ENDPOINT = "/ws/%s/json/";

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final RestService rest;

    public GetZipCodeDataProviderImpl(RestService rest) {
        this.rest = rest;
    }

    @Override
    public Optional<ZipCode> execute(String zipCode) {
        var path = String.format(ZIP_CODE_ENDPOINT, zipCode);
        var response = rest.get(path);

        return this.extractResponse(response);
    }

    private Optional<ZipCode> extractResponse(Response response) {
        try {
            return Optional.of(
                response.then()
                        .extract()
                        .as(ZipCode.class)
            );
        } catch (Exception e) {
            log.error("m=extractResponse, msg='error to deserialize zipCode json response: {}'", e.getMessage());
            return Optional.empty();
        }
    }
}
