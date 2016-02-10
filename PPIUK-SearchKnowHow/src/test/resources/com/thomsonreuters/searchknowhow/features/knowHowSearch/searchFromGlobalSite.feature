@wip
Feature: Where the Global entry point is used for the Know-How search then results are Global
  This feature covers tests for the following stories:
  [638470]

  Scenario: Search from Global site retrieves Global resources
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |
    And has selected the link to United Kingdom
    And has selected the Know How - Global link
    When the user runs a free text search for the query "china arbitration"
    When the user opens the link associated with the result "1" which opens via the PLC UK site
    And opens the link entitled Resource details
    Then it is clear to the user that results are restricted to Global content because the product details contain at least one of the following categories
    And as a user I want to switch to the WestLawNext window