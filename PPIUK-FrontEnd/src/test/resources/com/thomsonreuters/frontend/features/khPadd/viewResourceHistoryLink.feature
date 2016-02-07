Feature: As a KH user, I want to view the "View Resource History" link for each type of resource page

  Scenario: User checks the "View Resource History" link appearance and functionality
    Given PL+ user is logged in
    And the user runs a free text search for the query "Disability discrimination"
    When the user clicks on search result "Disability discrimination" title link
    When the user clicks on "View Resource History" link
    Then the user can see 3 latest resource histories displayed

  @manual
  Scenario: User checks the "View Resource History" link appearance and functionality
    Given PL+ user is logged in
    And user navigates directly to document with plcref "3-502-7601"
    When the user clicks on "View Resource History" link.
    And the user is taken to the "Resource History" section
    And user clicks on the "View All" link
    Then it shows the more than 3 resource history results
    And it should show the "View Latest" link
    And the user clicks on the "View Latest"
    And the resource history displays 2 results with "View All" link