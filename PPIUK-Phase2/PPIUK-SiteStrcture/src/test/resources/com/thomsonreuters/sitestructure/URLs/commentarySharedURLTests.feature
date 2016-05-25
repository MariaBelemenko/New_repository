Feature: As a user, I want to access Practical Law product via the shared URL domain, so that I can view Practical Law content.

    Background:
     Given PL+ user is logged in with following details
            | routing          | SITE_STRUCTURE  |
            | mandatoryRouting | YES             |

    Scenario: User verifies PL Shared URL
    When the user opens "/?comp=library" url on plcuk website
    Then user should see the page with heading "Home"

    @wip
    Scenario: User verifies PL Shared URL for unauthenticated user
        When the user opens "/?comp=pluk" url on plcuk website
        Then user should see the page with heading "Home"
    @wip
     Scenario: User verifies PL Shared URL
        When the user opens "/?comp=pluk1" url on plcuk website
        Then user should see the error page