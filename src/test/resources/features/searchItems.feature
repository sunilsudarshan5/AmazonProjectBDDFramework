@UI @searchItems
Feature: Amazon Product Search Functionality
  I search a product on amazon home page
	
	@priority3
  Scenario: Search for different products
   Given I am on Amazon homepage
		When I search for iphone15
		And I click on search button
		Then search result should be displayed

