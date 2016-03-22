Feature: Verify email/print/download from document view

  Background:
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When the user clicks on the resources tab on the home page
    And the user clicks on "Checklists" link
    And user clicks on the "IP & IT" Practice Area Link
    And the user clicks on "Industrial designs licence" link

  Scenario: Send document via email
    When the user clicks 'email' widget on the document page
    Then the user verifies that 'Email' Window is displayed
    When the user clicks 'Email' on 'email' overlay
    And the user verifies that 'Ready For Email' is displayed on the overlay

  Scenario: Print document
    When the user clicks 'print' widget on the document page
    Then the user verifies that 'Print' Window is displayed
    When the user clicks 'Print' on 'print' overlay
    Then the user verifies that 'Preparing For Print' is displayed on the overlay

  Scenario: Download document
    When the user clicks 'download' widget on the document page
    Then the user verifies that 'Download' Window is displayed
    When the user clicks 'Download' on 'download' overlay
    Then the user verifies that 'Preparing For Download' is displayed on the overlay
    And the user verifies that 'Ready For Download' is displayed on the overlay
    And the user clicks download on ready to download overlay