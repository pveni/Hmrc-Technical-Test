Feature: SauceDemo Shopping

  Scenario: Add highest priced item to cart
    Given I navigate to the SauceDemo website
    When I login with valid credentials
    And I add the highest priced item to the cart
    Then I close the browser
