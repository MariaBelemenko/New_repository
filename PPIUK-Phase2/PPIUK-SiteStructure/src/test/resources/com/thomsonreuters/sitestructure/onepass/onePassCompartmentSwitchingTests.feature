Feature: [890535]As a PL+ user,I want to toggle between Westlaw UK, Practical Law and Commentary products on the homepage, so that I can view the product of my choice

    Background:
        Given PL+ user is applying routing without login
            | routing          | SITE_STRUCTURE_OW  |
            | mandatoryRouting | YES                |

    Scenario: User verifies "Practical Law" gets maintained between OW and login state while viewing initially PL Homepage
        When the user is viewing "Practical Law" homepage
        And user clicks the "Sign in" link
        And user logs in
        Then user should see the "Practical Law" home page

    Scenario: User verifies "West Law" gets maintained between OW and login state while viewing initially WestLaw Homepage
        When the user is viewing "Westlaw UK" homepage
        And user clicks the "Sign in" link
        And user logs in
        Then user should see the "Westlaw UK" home page

    Scenario: User verifies "Library" gets maintained between OW and login state while viewing initially Library Homepage
        When the user is viewing "Library" homepage
        And user clicks the "Sign in" link
        And user logs in
        Then user should see the "Library" home page
