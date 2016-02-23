Feature: [851088] As a PL+ User, I can open core country link from country page

  Scenario Outline: verify core country links
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    When the user navigates to the main PLCUK page
    When the user selects "International" tab
    When the user clicks on "View all" link
    Then the user verifies that the current PageTitle contains 'All countries'
    When the user selects "<country>"
    When the user selects "please switch to the <link> website to find out more about our detailed <link> resources and tools"
    Then the user is taken to the "<webSite>" web site in the same window and tab

    Examples: 
      | country        | link   | webSite                                     |
      | China          | China  | thomsonreuters.com/Browse/Home/Global/China |
      | United States  | US     | westlaw.com                                 |
      | Canada         | Canada | ca.practicallaw.com                         |
      | United Kingdom | UK     | thomsonreuters.com/Search/Home              |
