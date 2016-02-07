Feature: I want the footer links looks like design document when I am logged in

  Scenario: I want the logged in links visible
    Given PL+ user is logged in
    Then user should see footer
    And user should see the "Permitted Use FAQs" link
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