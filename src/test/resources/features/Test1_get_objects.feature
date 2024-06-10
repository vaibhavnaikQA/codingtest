Feature: Calculator

  Scenario: Get test for api.restful-api.dev/objects
    Given EndPoint is "https://api.restful-api.dev/objects"
    And Method is "GET"
    And Payload is "dummy"
    When Bot executes
    Then "id" should not be "null"
    And "id" should not be "10000"
    And print lowest in cost
    And print mobile starting with apple
