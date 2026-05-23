Feature: Open Cart cart Module

Scenario: Add product to cart
Given User is on homepage and logged into account
When User search for product and get the product results
And User selected the product and navigated to product page
Then User selected Add to cart button and verify product added to cart

Scenario: Update product quantity
Given User is on open cart homepage and logged in to account
When User select Shopping cart and navigated to cart page
And User updates the quantity of product
Then Verify price changes and quantity updated

Scenario: Remove product from cart
Given User is on demo open cart homepage and logged in to account
When User click on Shopping cart and navigated to cart page
And User remove product from cart
Then Verify product removed from cart

Scenario: Verify empty cart message
Given User is on homepage and log in to account
When User clicked on Shopping cart and navigated to cart page
Then Verify Cart empty message displayed