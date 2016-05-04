# Tests are ready and pass for 100%. Please, remove @wip tag after Go Live release
# The requirements for scenarios described in E2E spreadsheet (https://thehub.thomsonreuters.com/docs/DOC-1536366)
# Advanced access tab -> rows 10-13
@e2e @wip
Feature: International documents

  Background:
    Given PL+ user is logged in

  Scenario Outline: Country Q&A Document From International tab
    When the user selects "International" tab
    And the user clicks on "<Country>" link
    And the user clicks on "<Document>" link
    Then resource type is displayed as "Country Q&A" on right hand panel
    And following jurisdictions are displayed on the document right hand panel
      | <Country> |

    Examples:
      | Country      | Document                                  |
      | Australia    | Cartel leniency: overview                 |
      | Hong Kong    | Investing in Hong Kong                    |
      | India        | Doing business in India                   |
      | South Africa | Employee share plans: regulatory overview |

  Scenario Outline: Back to Country page from the search topic
    When the user selects "International" tab
    And the user clicks on "<Country>" link
    When the user selects "All <Country> resources" tab
    And the user clicks on "<Topic>" link
    And the user clicks on "Back to <Country>" link
    Then the user is presented with a page with header "<Country>"

    Examples:
      | Country      | Topic       |
      | Australia    | Commercial  |
      | Hong Kong    | Environment |
      | India        | Arbitration |
      | South Africa | Real Estate |

  Scenario Outline: Search results contains selected Country
    When the user selects "International" tab
    And the user clicks on the 'View all' link on active tab
    And the user clicks on "<Country>" link
    And the user searches for "tax"
    Then the search results contains '<Country>' jurisdiction in each result

    Examples:
      | Country      |
      | Australia    |
      | Hong Kong    |
      | India        |
      | South Africa |

  Scenario Outline: Country Q&A Document From View all countries
    When the user selects "International" tab
    And the user clicks on the 'View all' link on active tab
    And the user clicks on "<Country>" link
    And the user clicks on "<Document>" link
    Then resource type is displayed as "Country Q&A" on right hand panel
    And following jurisdictions are displayed on the document right hand panel
      | <Country> |

    Examples:
      | Country      | Document                                  |
      | Australia    | Cartel leniency: overview                 |
      | Hong Kong    | Investing in Hong Kong                    |
      | India        | Doing business in India                   |
      | South Africa | Employee share plans: regulatory overview |