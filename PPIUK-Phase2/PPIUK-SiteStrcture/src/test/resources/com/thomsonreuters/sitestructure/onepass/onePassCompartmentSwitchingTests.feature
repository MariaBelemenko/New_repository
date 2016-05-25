Feature: [890535]As a PL+ user,I want to toggle between Westlaw UK, Practical Law and Commentary products on the homepage, so that I can view the product of my choice

    Background:
        Given PL+ user is applying routing without login
            | routing          | SITE_STRUCTURE_OW  |
            | mandatoryRouting | YES                |

    Scenario: User verifies WestLaw while viewing PL Homepage
        When the user is viewing "PL" homepage
        And the user expands the prodcut drop-down
        And the user selects "Westlaw UK" product
        Then user should see the "Westlaw" home page
        And user clicks the "Sign in" link
        And user logs in
        Then user should see the "Westlaw" home page

