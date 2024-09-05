Feature: Amazon Search and Add to Cart

  @MobileTest @SKIP
  Scenario Outline: 18881_Searching a product and Add to cart Valid
    Given open the Amazon app on "<DeviceDetails>"
    And click on skip sign in
    And search for product
    And add the item to amazoncart
    Then verify item is added to cart

    Examples: 
      | DeviceDetails      |
      | Google Pixel 3_9.0 |
      
  @MobileTest @SKIP
  Scenario Outline: 18881_Searching a product and Add to cart InValid
    Given open the Amazon app on "<DeviceDetails>"
    And click on skip sign in
    And search for product
    And add the item to amazoncart
    Then verify item is not added to cart

    Examples: 
      | DeviceDetails      |
      | Google Pixel 3_9.0 |
