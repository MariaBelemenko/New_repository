@manual
Feature: As a  user,I want to be able to scroll up and down on the beta feedback form,So that I can submit my feedback

  Scenario: User verifies Beta Feedback form scrollbar
    Given a user is logged in
    When user clicks on the Beta Feedback button
    And Beta feedback forms popup
    Then the user can scroll down to submit the form