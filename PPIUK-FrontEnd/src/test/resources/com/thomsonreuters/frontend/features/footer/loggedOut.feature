Feature: I want the footer links looks like design document when I am logged out

  Scenario: I want the logged out links visible in footer
    When PL+ user navigates to home page
    Then user should see footer
    And user should see the "Sign in" link
    And user should check the following links
      | About us               |
      | Testimonials           |
      | Careers                |
      | Meet the Team          |
      | Consultation Boards    |
      | Contributing Firms     |
      | Partners               |
      | Networks               |
      | User Guides            |
      | Request Training       |
      | What's New             |
      | Feedback               |
      | Contact Us             |
      | Events and Conferences |
      | Twitter                |
