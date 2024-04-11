Feature: FirstTest

  Scenario: User login

    Given The user is on the shop page
    When User logs in with email tomasz.kapibara@gmail.com and password 12345
    And Closing the browser


    Scenario Outline: Introduction of a new address

      Given The user is on the shop page
      When User logs in with email tomasz.kapibara@gmail.com and password 12345
      And The user adds their first address <alias> <address> <city> <postalCode> <country> <phone>
      Then Your address has been saved
      And Closing the browser

      Examples:
      | alias | address | city | postalCode | country | phone|
      | Tomek | Kowalska | Warszawa | 00-001 | Polska | 123456789 |
