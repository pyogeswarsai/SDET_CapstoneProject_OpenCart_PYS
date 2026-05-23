Feature: Open Cart Product Module

Scenario: Search Product using valid keyword
Given User is on hompage and select login option in account tab and login to account
When User enters "<validProduct>" name using valid keyword and click search button
Then User redirect to product results page and verify user got the related "<validProduct>"
Examples:
	|validProduct|
	|iMac|
	|iPhone|

Scenario: Search Product using invalid keyword
Given User is on hompage and select login option in account tab and loggedin to account
When User enter "<invalidProduct>" name using invalid keyword and click search button
Then User redirect to product result page and verify user got the related "<invalidProduct>"
Examples:
	|invalidProduct|
	|abcd123|
	|dummy45cc|

Scenario: Search Product with empty field
Given User is on home page and selected register option in my accounts tab
When User click search button with empty filed
Then User navigated to page with no products displayed
