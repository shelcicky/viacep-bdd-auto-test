package br.sp.shelcicky.viacep.steps;

import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;
import br.sp.shelcicky.viacep.domain.usecase.GetZipCodeUseCase;
import br.sp.shelcicky.viacep.domain.usecase.ZipCodeValidatorUseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchZipCodeSteps {
    private final GetZipCodeUseCase getZipCodeUseCase;
    private final ZipCodeValidatorUseCase validatorUseCase;

    private String plainZipCode;
    private ZipCode zipCode;

    @Autowired
    public SearchZipCodeSteps(GetZipCodeUseCase getZipCodeUseCase,
                              ZipCodeValidatorUseCase validatorUseCase) {
        this.getZipCodeUseCase = getZipCodeUseCase;
        this.validatorUseCase = validatorUseCase;
    }

    @Given("the following zip code {string}")
    public void theFollowingZipCode(String plainZipCode) {
        this.plainZipCode = plainZipCode;
    }


    @When("the zip code is searched in the ViaCep API")
    public void theZipCodeIsSearchedInTheViaCepAPI() {
        zipCode = getZipCodeUseCase.execute(plainZipCode);
    }

    @Then("the API response is validated")
    public void theAPIResponseIsValidated() {
        validatorUseCase.execute(plainZipCode, zipCode);
    }
}
