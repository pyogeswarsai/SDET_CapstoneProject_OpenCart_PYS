Feature: Open Cart Logout Module

Scenario: Verify logout functionality
Given User is on home page and logins to account
When Select My Account Option and click on Logout option
And User logged out from account and verify session termination
Then User click continue to redirect to homepage