@manual
Feature: As a  user, I want to see the topic page styling according to the design

  Scenario: User verifies topic page LU styling
    Given a user is logged in
    When user navigates to the practice area like Competition
    And user navigates to one of its topic page like Cartels
    Then the user see the legal update styling according to the design document.

  Scenario: User verifies delivery toolbar styling
    Given a user is logged in
    When user navigates to the practice area like Competition
    And user navigates to one of its topic page like Cartels
    Then the user see the delivery toolbar(email,Add to Folder, download and print) according to the design document.

  Scenario: User verifies topic page background clolor styling
    Given a user is logged in
    When user navigates to the practice area like Competition
    And user navigates to one of its topic page like Cartels
    Then the user see the topic page with blue background according to the design document.

  Scenario: User verifies the delivery options on topic page
    Given a user using the delivery options from topic page
    When I select Print, email of download from the delivery toolbar
    Then I will see the delivery modal box
    And I will be able to select the Basic and Advanced tabs to see the options on each tab.