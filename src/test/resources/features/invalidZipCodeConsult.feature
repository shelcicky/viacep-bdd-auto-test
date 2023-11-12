@ALL @SUCCESSFUL_REQUESTS
Feature: Must validate get invalid requests to viacep webservice endpoint.

  Scenario: Must validate requests with space in zip code.
  Given the following zip code "01001 000"
  When  the zip code is searched in the ViaCep API
  Then  the request status code must be 400

  Scenario: Must validate requests with invalid character in zip code.
  Given the following zip code "01001S000"
  When  the zip code is searched in the ViaCep API
  Then  the request status code must be 400

  Scenario: Must validate requests with nine characters in zip code.
  Given the following zip code "010011000"
  When  the zip code is searched in the ViaCep API
  Then  the request status code must be 400