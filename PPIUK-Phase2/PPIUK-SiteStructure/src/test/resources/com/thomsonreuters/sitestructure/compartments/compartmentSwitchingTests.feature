Feature: [890065]As a PL+ user,I want to toggle between Westlaw UK, Practical Law and Commentary products on the homepage, so that I can view the product of my choice


    Background:
        Given PL+ user is logged in with following details
            | routing          | SITE_STRUCTURE  |
            | mandatoryRouting | YES             |

    Scenario: User verifies WestLaw while viewing PL Homepage
        When the user is viewing "Practical Law" homepage
        And the user expands the prodcut drop-down
        And the user selects "Westlaw UK" product
        Then user should see the "Westlaw UK" home page
        And user should see "Westlaw UK " as a text rather than a link in product drop-down

    Scenario: User verifies Commentary while viewing PL Homepage
        When the user is viewing "Practical Law" homepage
        And the user expands the prodcut drop-down
        And the user selects "Library" product
        Then user should see the "Library" home page

    Scenario: User verifies PL while viewing WestLaw Homepage
        When the user is viewing "Westlaw UK" homepage
        And the user expands the prodcut drop-down
        And the user selects "Practical Law" product
        Then user should see the "Practical Law" home page

    Scenario: User verifies Commentary while viewing WestLaw Homepage
        When the user is viewing "Westlaw UK" homepage
        And the user expands the prodcut drop-down
        And the user selects "Library" product
        Then user should see the "Library" home page

    Scenario: User verifies PL while viewing Commentary Homepage
        When the user is viewing "Library" homepage
        And the user expands the prodcut drop-down
        And the user selects "Practical Law" product
        Then user should see the "Practical Law" home page

    Scenario: User verifies WestLaw while viewing Commentary Homepage
        When the user is viewing "Library" homepage
        And the user expands the prodcut drop-down
        And the user selects "Westlaw UK" product
        Then user should see the "Westlaw UK" home page