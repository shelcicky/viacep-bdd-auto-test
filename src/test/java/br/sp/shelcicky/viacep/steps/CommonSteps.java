package br.sp.shelcicky.viacep.steps;

import br.sp.shelcicky.viacep.domain.usecase.GetStatusCodeUseCase;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@CucumberContextConfiguration
public class CommonSteps {
    private static final String STATUS_CODE_ASSERT_FAIL_MESSAGE = "The request status code does not match!";

    private final GetStatusCodeUseCase getStatusCodeUseCase;

    @Autowired
    public CommonSteps(GetStatusCodeUseCase getStatusCodeUseCase) {
        this.getStatusCodeUseCase = getStatusCodeUseCase;
    }

    @Then("the request status code must be {int}")
    public void theRequestStatusCodeMustBe(int expectedStatusCode) {
        assertThat(STATUS_CODE_ASSERT_FAIL_MESSAGE, getStatusCodeUseCase.execute(), is(expectedStatusCode));
    }
}
