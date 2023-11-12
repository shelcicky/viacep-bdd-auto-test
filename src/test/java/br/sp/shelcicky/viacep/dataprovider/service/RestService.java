package br.sp.shelcicky.viacep.dataprovider.service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    private final String baseUri;
    private Response response;

    public RestService(@Value("${integration.via-cep.url}") String baseUri) {
        this.baseUri = baseUri;
    }

    private void setResponse(Response response) {
        this.response = response;
        this.response.then().log().all();
    }

    private RequestSpecification given() {
        return SerenityRest.given()
                .baseUri(baseUri);
    }

    public Response get(String path) {
        this.setResponse(
            this.given().get(path)
        );

        return this.response;
    }

    public Response getResponse() {
        return response;
    }
}
