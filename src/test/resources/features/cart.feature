Feature: To search the product and add that product into the cart.

  Scenario: Verify that user is able to log-in with valid credentials.
    Given The user navigate to home page.
    When The user goes to login page.
    And Enters valid credentials.
    Then The user should Logged-in Successfully.

  Scenario: Verify that user able to search the product in Search Box.
    Given The user navigate to the home page.
    When The user enters Product Name.
    Then The user should get entered product result.

    #addCart
  Scenario:Verify that user able to select quantity of the product and able to add it,in the cart.
    Given The user navigate to selected product page.
    When User selects the quantity of the product
    And Clicks to the Add_To_Cart Button.
    Then The message Added To Cart should displayed.

  Scenario: Check that Product Stock information is available or not.
    Given The user goes to selected product page.
    When The user checks the stock updates.
    Then The message In Stock or Out Of Stock should display.

  Scenario:Verify that user is able to view the Ratings and Reviews.
    Given User navigate to product page.
    When Click On Review Link.
    And Click On Images with Review.
    Then Reviews with Images page should get open.

  Scenario:Check whether Shipping charges updates s available or not.
    Given User navigate to the product page.
    When check the delivery charges update.
    Then Either Free Delivery or Shipping charges should visible.

  Scenario: Verify that user is able to add his address or not.
    Given User navigates to product page.
    When Click Add address Link.
    Then Choose your Location page should display.


  Scenario Outline: User should not able login with invalid credentials.
    Given The user goes to the home page.
    When The user navigates to sing in page.
    And enter "<phoneNumber>"
    Then  Error "<EMessage>" should Displayed.
    Examples:
      | phoneNumber | EMessage               |
      | 1234694     | Incorrect phone number |
      | 8877665500  | Incorrect phone number |
      | 0987654321  | Incorrect phone number |



