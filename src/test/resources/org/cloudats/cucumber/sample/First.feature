  	
Feature: Feature example

Scenario Outline: Finding some cheese
  Given I am on the Google search page
  When I search for "<query>"
  Then the page title should start with "<output>"

	Examples: Single query
  	|  query	|  output  |
  	|  Chees! |  Chees!  |
  	|  foo 		|  bar		 |
  	|  foo 		|  foo		 |