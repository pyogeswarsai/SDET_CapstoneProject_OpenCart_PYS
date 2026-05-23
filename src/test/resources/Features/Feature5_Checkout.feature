Feature: Open Cart Checkout Feature

Scenario: Verify Checkout functionality
Given User login to account and search for a product
When User select product and added to cart
And User went to cart page and click on checkout button
And User enters billing details and delivery details
And User enters delivery method and payment method and confirm order
Then User get the order confirmation message