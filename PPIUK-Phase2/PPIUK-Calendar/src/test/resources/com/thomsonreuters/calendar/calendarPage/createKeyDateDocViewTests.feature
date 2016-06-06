@keyDateDoc
Feature: [883877]As a Product user, the user should be able to view the key date document that is in line with the Calendar Designs

  Scenario Outline: User verifies the month drop-down with the current month selected
    Given PL+ user is logged in with following details
      | routing          | CALENDAR_KEY_DATE_DOC  |
      | mandatoryRouting | YES                    |
    When the user navigates to "<Doc Resource ID>" url
    Then the user is on key date document view
    And the user should be presented with the document body,
    And the user should be presented with the resource links,
    And the user should be presented with the metadata,
    And the user should be presented with a maximum of 5 jurisdictions
    And the user should be presented with the display date at the top of the page.

   Examples:
         |Doc Resource ID |
         |/w-002-1782 |
         |/w-002-1782 |
