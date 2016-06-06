Feature: tabSwitching.feature

  Background:
    Given PL+ user is logged in


    Scenario: Verify that following a search practical law tab and westlaw uk tab are displayed and can be selected
      And the user runs a free text search
      And the user can verify the presence of a Practical Law tab
      And the user can verify the presence of a Westlaw UK tab
      And the user can verify that the Practical Law tab is displayed by default
      When the user clicks on Results from Westlaw UK tab
      Then the Westlaw UK tab is displayed

    Scenario: Verify that following a search from the Global page the Westlaw UK tab is not rendered on search results
      And the user has selected a Global Page
      When the user runs a free text search
      Then the user can verify the presence of a Practical Law tab
      And the Westlaw UK tab is not displayed

    Scenario: Verify that following a search from the Whats Market page the Westlaw UK tab is not rendered on search results
       And the user has selected the link to resources
       And the user has selected the link to what's market
       When the user runs a free text search
       Then the user can verify the presence of a Practical Law tab
       And the Westlaw UK tab is not displayed

      Scenario: Verify that following a search from the Ask page the Westlaw UK tab is not rendered on search results
        And the user has selected the link to resources
        And the user has selected the Ask page
        When the user runs a free text search
        Then the user can verify the presence of a Practical Law tab
        And the Westlaw UK tab is not displayed

      Scenario: Verify that following a search from an individual country page the Westlaw UK tab is not rendered on search results
        And the user has selected the country page "Australia"
        When the user runs a free text search
        Then the user can verify the presence of a Practical Law tab
        And the Westlaw UK tab is not displayed

