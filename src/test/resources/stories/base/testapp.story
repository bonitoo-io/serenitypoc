Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Log in to test app
Given testapp is open
When I click the login link
When I enter the credentials 'krtek' and 'noname'
When I click login submit
Then the poklad is loaded
