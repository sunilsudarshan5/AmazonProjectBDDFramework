@UI @cart
Feature: Amazon Product add to cart Functionality
  I want to use this template for adding product in add to cart 

	@priority4
  Scenario: Add to cart products
   Given I am on Amazon homepage
		When I search for iphone15
		And I click on search button
		Then search result should be displayed
		When I click on add to cart
		Then trash icon should be displayed