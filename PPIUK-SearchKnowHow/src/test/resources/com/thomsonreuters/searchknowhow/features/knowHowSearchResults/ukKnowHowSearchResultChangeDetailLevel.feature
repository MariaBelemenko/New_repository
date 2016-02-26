Feature: [702211][779805] ukKnowHowSearchResultChangeDetailLevelS2-90.feature
  [702211] As a PL+ user I should be able to change my view of the level of detail that I can see for my search results,  so that I can view either full or limited information about each search result.
  [779805] Practice Area Legal Update Results: Less/More/Most

  Scenario Outline: [702211]Verify default setting for more detail reflects previous user session setting
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user can select the option to show more detail
  Examples:
    | query    |
    | taxation |

  @e2e
  Scenario Outline:[702211] Verify setting for more detail
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    Then the user can verify that the more detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify that terms in context are displayed appropriate to the more setting
  Examples:
    | query    |
    | taxation |

  @e2e
  Scenario Outline:[702211] Verify setting for most detail
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    Then the user can select the option to show most detail
    And the user can verify that the most detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify that terms in context are displayed appropriate to the most setting
  Examples:
    | query    |
    | taxation |

  @e2e
  Scenario Outline:[702211] Verify setting for less detail
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    Then the user can select the option to show less detail
    And the user can verify that the less detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify a brief description of the content is not displayed
    And the user is able to verify that terms in context are displayed appropriate to the less setting
  Examples:
    | query    |
    | taxation |

  Scenario Outline:[779805] Verify default setting for more detail reflects previous user session setting for practice area legal updates
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user can select the option to show more detail
  Examples:
    | query    |
    | taxation |

  Scenario:[779805] verify more setting for practice area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Arbitration"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can verify that the more detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained

  Scenario:[779805] verify most setting for practice area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Arbitration"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can select the option to show most detail
    And the user can verify that the most detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained

  Scenario:[779805] verify less setting for practice area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Arbitration"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can select the option to show less detail
    And the user can verify that the less detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify a brief description of the content is not displayed

  Scenario Outline:[780171] Verify default setting for more detail reflects previous user session setting for topic level legal updates
    Given PL+ user is logged in
    When the user runs a free text search for the query "<query>"
    And the user can select the option to show more detail
  Examples:
    | query    |
    | taxation |

  Scenario:[780171] verify more setting for topic level area legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Corporate"
    And has selected the topic link to "Directors"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can verify that the more detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained

  Scenario:[780171] verify most setting for topic level legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Corporate"
    And has selected the topic link to "Directors"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can select the option to show most detail
    And the user can verify that the most detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify a brief description of the content
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained

  Scenario:[780171] verify less setting for topic level legal updates
    Given PL+ user is logged in
    And has selected the homepage practice area link to "Corporate"
    And has selected the topic link to "Directors"
    And has selected the link to View All on the Legal Updates Widget
    And the user pauses for "5" seconds
    Then the user can select the option to show less detail
    And the user can verify that the less detail icon is displayed
    And the user is able to verify the presence of the title of the first result
    And the user is able to verify the presence of a resource type description
    And the user is able to verify that jurisdiction information is displayed
    And the user is able to verify that the content is either maintained or non maintained
    And the user is able to verify a brief description of the content is not displayed
