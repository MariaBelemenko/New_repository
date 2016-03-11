Feature: [839936] As a PL+ User I can refine my search results by Resource Type and or Jurisdiction

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario: The user can run a search and results include Resource type and Jurisdiction facets
    When the user runs a free text search for the query "tax"
    Then the jurisdiction and resource type facets are displayed
      | Jurisdiction  |
      | Resource Type |

  Scenario Outline: The user can chose jurisdiction filter
    When the user runs a free text search for the query "tax"
    Then the user selects the "Jurisdiction" facet "<facet>"
    When the user apply filters
    Then the results is refined to only include that "<facet>" jurisdiction
  Examples:
    | facet  |
    | Canada |
    | China  |

  Scenario Outline: The user can chose resource type filter
    When the user runs a free text search for the query "tax"
    Then the user selects the "Resource Type" facet "<facet>"
    When the user apply filters
    Then the results is refined to only include that "<facet>" resource type
  Examples:
    | facet      |
    | Checklists |

  Scenario Outline: The user can chose resource type and jurisdiction filter
    When the user runs a free text search for the query "tax"
    Then the user selects the "Jurisdiction" facet "<jurisdictionsFacet>"
    Then the user selects the "Resource Type" facet "<resourceTypeFacet>"
    When the user apply filters
    Then the results is refined to only include that "<jurisdictionsFacet>" jurisdiction
    Then the results is refined to only include that "<resourceTypeFacet>" resource type
  Examples:
    | jurisdictionsFacet | resourceTypeFacet |
    | Canada             | Checklists        |
