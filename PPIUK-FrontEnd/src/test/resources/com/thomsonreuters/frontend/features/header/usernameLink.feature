Feature: As a PL+ user, I want to see the user dropdown in the header with "Edit Profile", "Email Preferences" and "Sign Out" options so that I can use them approprately

  Scenario Outline: I want the username links to display and function accordingly.
    Given PL+ user is logged in
    Then user should see user icon link
    And  user clicks on user icon
    And user should see the user popup
    And user clicks on "<Link>" link
    And user should navigate to <result page>
  Examples:
    | Link              | result page       |
    | Edit profile      | One Pass          |
    | Email preferences | Email preferences |
    | Sign out          | Session Summary   |
