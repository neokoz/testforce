Feature: travel from to a station

  #Poor Gherkin, to show the syntax of Step Definitions
  Scenario: travel from Amsterdam to Utrecht
    Given I am at www.ns.nl
    And I clicked accept in cookie popup
    And I choose to travel today
    And I travel from Amsterdam

    #Better Gherkin, describing a scenario from (end)user point of view
    Scenario: being able to book a ticket
      Given I am at the mainpage
      When I book a standard ticket
      Then the ticket price is "€ 7,60"
