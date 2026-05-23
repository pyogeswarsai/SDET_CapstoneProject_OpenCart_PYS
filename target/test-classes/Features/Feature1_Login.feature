Feature:  Open Cart Login Module

Scenario: Login with valid email and password
Given User is on hompage and select login option in account tab
When User enters valid email and password and click on sign in
Then User navigated to users account homepage and verified the page

Scenario: Login with invalid email and password
Given User is on hompage and select login option in my account tab
When User enters invalid "<email>" and "<password>" and click on sign in
Then User will get the Error message
Examples:
	| email | password |
	|yog@gmail.com | Yog@123 |
	|yoges@gmail.com | Yoges@123|

Scenario: Login with blank credentials
Given User is on hompage and select login option in my accounts tab
When User not entered both email and password and click on login
Then User get the error message