Feature: Open Cart Registration Module

Scenario: Verify navigation to Registration page
Given User is on homepage
When User select Register option in account tab
Then User navigated to regsiter page and verify registration page is displayed

Scenario: Register user with valid Details
Given User is on hompage and select register option in account tab
When User enter all necessary details 
And Click checkbox and click on continue
Then User successfully registered and verify successful account creation

Scenario: Register User with existing email
Given User is on hompage and selected register option in my account tab
When User enters all updated details but used existing "<email>"
Then Click continue and verify warning message
Examples:
	| email |
	| yoge@gmail.com |
	|yoges@gmail.com |

Scenario: Verify mandatory field validation messages
Given User is on hompage and select register option in my account tab
When User not entered any details and click on continue
Then User gets a warning message

Scenario: Verify password mismatch validation
Given User is on hompage and selected register option in my accounts tab
When User entered all details but used two different passwords and click continue
Then User gets the Password mismatch error message and verify