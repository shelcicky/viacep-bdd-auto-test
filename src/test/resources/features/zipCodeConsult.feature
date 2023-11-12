@ALL @SUCCESSFUL_REQUESTS
Feature: Must validate get successful requests to viacep webservice endpoint.

  Scenario Outline: Must validate successful requests for the get zipcode endpoint.
    Given the following zip code "<zipCode>"
    When  the zip code is searched in the ViaCep API
    Then  the API response is validated

    Examples:
    | zipCode   |
    | 88010-000 |
    | 05050-000 |
    | 69095-160 |
    | 65052-865 |
    | 71698-906 |