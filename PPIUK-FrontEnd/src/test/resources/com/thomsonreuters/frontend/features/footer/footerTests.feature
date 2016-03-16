Feature: As a user, I want to see the "Legal Information" and "Privacy Policy and Cookies" link functional on the footer

  Scenario: User verifies the functionality of "Privacy Policy and Cookies" and "Legal Information"
    Given PL+ user navigates to home page
    And user should see footer
    And user should see the "Privacy Policy and Cookies" link
    When user clicks on "Privacy Policy and Cookies" link
    Then user should see the "Privacy" page
    When user clicks on "Legal Information" link
    Then user should see the "Legal information" page

  Scenario: User verifies the "Footer Link Items" for the respetive Page's links
    When PL+ user is logged in
    Then user should see footer
    Then user should see the following FooterLinks with links to respective pages link
      | FooterLink             | LinksToPage                               |
      | About us               | /Browse/Home/About/AboutUs                |
      | Testimonials           | /Browse/Home/About/Testimonials           |
      | Careers                | http://thomsonreuters.com/en/careers.html |
      | Meet the Team          | /Browse/Home/About/OurTeam                |
      | Consultation Boards    | /Browse/Home/About/ConsultationBoards     |
      | Contributing Firms     | /Browse/Home/About/Contributors           |
      | Partners               | /Browse/Home/About/OurPartners            |
      | Networks               | /Browse/Home/About/Networks               |
      | User Guides            | /Browse/Home/About/UserGuides             |
      | Request Training       | /Browse/Home/About/RequestTraining        |
      | What's New             | /Browse/Home/About/WhatsNew               |
      | Contact Us             | /Browse/Home/About/ContactUs              |
      | Events and Conferences | /Browse/Home/About/EventsandConferences   |

  Scenario Outline:[811954][812168][812217][812597][812627][812671][812847][812855][812858][812860][812875][814477][814482] User verifies the Footer Pages links functionality
    Given PL+ user is logged in
    When user clicks on "<LinkText>" link
    Then user should see the "<Page Title>" Page according to the design
    And user should see all the "<links or tabs>" on the page
    Examples:
      |LinkText               | Page Title            | links or tabs  |
      |About us               | About us              |      -         |
      |Testimonials           | Testimonials          |      -         |
      |Careers                | Careers               |      -         |
      |Meet the Team          | Team members          |Arbitration,Commercial,Corporate,Finance,Private Client,Property,Tax|
      |Consultation Boards    | Consultation boards   |Arbitration,Commercial,Corporate,Finance,Private Client,Property,Tax|
      |Contributing Firms     | Contributors          | AnJie Law Firm |
      |Partners               | Partners              |      -         |
      |Networks               | Networks              |      -         |
      |Contact Us             | Contact us            |      -         |
      |Events and Conferences | Events and conferences|      -         |
