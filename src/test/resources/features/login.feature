@UI @login
Feature: Amazon Login Functionality
  I want to login to Amazon so that I can access my account and make purchases

	@positive	@priority1
  Scenario: Successful login with valid credentials
  	Given I navigate to Amazon login page
    When I enter valid username
    And I click on continue button
    And I enter valid password
    And click on login button
    Then I should be logged in successfully
	
	@negative @priority2
  Scenario: Failed login with invalid credentials
  	Given I navigate to Amazon login page
    When I enter invalid username
    And I click on continue button
    Then Looks like you are new to Amazon text should be visible
