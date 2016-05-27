Feature: [890525] As a business, I want to deliver Practical Law product on a single product view, so that users can view the homepage features.
         [890080] As a business, I want to deliver WLUK product on a single product view, so that users can view the homepage features.
         [890528] As a business, I want to deliver Commentary product on a single product view, so that users can view the Commentary homepage

  Background:
    Given PL+ user is logged in with following details
      | routing          | SITE_STRUCTURE  |
      | mandatoryRouting | YES             |

  Scenario: As a logged-in subscriber I want to see Practical Law product on a single product view
    When the user opens url "law.thomonreuters.co.uk/" in the browser
    Then the user should see "PL" homepage
    And the user should not see either the "Commentary" or "WLUK" homepage

  Scenario: As a logged-in subscriber I want to see WLUK product on a single product view
    When the user opens url "law.thomonreuters.co.uk/Browse/Home/WLUK" in the browser
    Then the user should see "WLUK" homepage
    And the user should not see either the "Commentary" or "PLUK" homepage

  Scenario: As a logged-in subscriber I want to see Commentary product on a single product view
    When the user opens url "law.thomonreuters.co.uk/Browse/Home/Library" in the browser
    Then the user should see "Library" homepage
    And the user should not see either the "WLUK" or "PL" homepage