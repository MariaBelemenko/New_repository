Feature: [890525] As a business, I want to deliver Practical Law product on a single product view, so that users can view the homepage features.

  Background:
    Given PL+ user is logged in with following details
      | routing          | SITE_STRUCTURE  |
      | mandatoryRouting | YES             |

  Scenario: As a logged-in subscriber I want to see Practical Law product on a single product view
    When the user opens "law.thomonreuters.co.uk/Browse/Home/practicallaw/practicallaw" in the browser
    Then the user should see PL homepage
    Then the user should not see either the Commentary or WLUK homepages