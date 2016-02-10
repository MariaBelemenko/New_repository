Feature: Search results shown after being timed out

  Scenario Outline: Checking that facets can be selected after being timed out
    Given PL+ user is logged in with routing details
      | mandatoryRouting | YES                              |
      | routing          | SPECIFIED_USER_TIMEOUT_3_MINUTES |
      | userName         | srm_user                         |
    When the user runs a free text cobalt search with query "taxation"
    And the user expands the know how facet "<facet1>"
    And the user expands the know how facet "<facet2>"
    And the user expands the know how facet "<facet3>"
    And the user selects the know how child facet "<facet4>"
    And the user selects the know how child facet "<facet5>"
    And the user selects the know how option to apply filters
    And he has a session open and timed out
    And he should stay on same document page as OpenWeb user
    And the user verifies that the know how facet is selected "<facet4>"
    And the user verifies that the know how facet is selected "<facet5>"
    And the user clicks Log in button
    And a PPI user enter its username and password
      | userName | srm_user |
    And clicks on Sign in
    Then the user verifies that the know how facet is selected "<facet4>"
    Then the user verifies that the know how facet is selected "<facet5>"
  Examples:
    | facet1    | facet2       | facet3  | facet4          | facet5                 |
    | Corporate | Acquisitions | Finance | Project finance | Acquisitions: Auctions |

  @manual @wip @bug
  Scenario:
    Given a PPI user authenticated through username and password who previously selected the Super remember me cookie option
    And he is viewing the results of a search in PL+
    And have some facets applied
    When he leaves the computer unattended for more than 1 hour
    And he keeps seeing the results of the search in PL+
    And the same facets keep applied(selections are retained)
    And when he does click anywhere
    Then he does not notice anything about the reauthentication process.
 #bug 801106