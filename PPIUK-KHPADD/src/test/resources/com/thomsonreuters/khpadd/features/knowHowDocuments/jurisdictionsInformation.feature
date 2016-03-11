Feature: [730581, 738469, 738519, 767108] Verify Jurisdictions functionality
  I want: to view Jurisdictions in right hand side column
  So that: I can view jurisdictions information in alphabetical order and without "Any UK Jurisdiction"
  I want: to select a "View All" link under jurisdiction information
  So that: I can see more than 5 jurisdictions where applicable

  Scenario: Verify the "View All" Jurisdictions link is not available for resources coded to less than 5 jurisdictions
    Given PL+ user is logged in
    And user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    Then following jurisdictions are displayed on the document right hand panel
      | England |
      | Wales   |
    And link 'View all' to display more jurisdictions is not displayed

  Scenario: Verify the "View All" Jurisdictions link is not available for resources coded to 4 jurisdictions
    Given PL+ user is logged in
    And user navigates directly to document with guid "I2030a03e1cb611e38578f7ccc38dcbee"
    Then following jurisdictions are displayed on the document right hand panel
      | France         |
      | Germany        |
      | Spain          |
      | United Kingdom |
    And link 'View all' to display more jurisdictions is not displayed

  Scenario: Verify the "View All" Jurisdictions link is available for resources coded to more than 5 jurisdictions
    Given PL+ user is logged in
    And user navigates directly to document with guid "I2ef12abf1ed511e38578f7ccc38dcbee"
    And user agrees to view the document if out of plan
    Then following jurisdictions are displayed on the document right hand panel
      | Argentina      |
      | Belgium        |
      | Brazil         |
      | Canada         |
      | Cayman Islands |
    When user clicks on 'View all' link to view all jurisdictions
    Then following jurisdictions are displayed on the document right hand panel
      | Argentina            |
      | Belgium              |
      | Brazil               |
      | Canada               |
      | Cayman Islands       |
      | Egypt                |
      | England              |
      | Germany              |
      | Ghana                |
      | India                |
      | Indonesia            |
      | Ireland              |
      | Israel               |
      | Japan                |
      | Kazakhstan           |
      | Luxembourg           |
      | Mexico               |
      | Nigeria              |
      | Russian Federation   |
      | South Africa         |
      | South Korea          |
      | Sweden               |
      | Switzerland          |
      | The Netherlands      |
      | United Arab Emirates |
      | United Kingdom       |
      | United States        |

  Scenario: Verify the Jurisdiction and Jurisdictions label on the right hand metadata
    Given PL+ user is logged in
    When user navigates directly to document with guid "Ieb49d7981cb511e38578f7ccc38dcbee"
    Then the user can read the label listing the countries as "Jurisdiction"
    When user navigates directly to document with guid "I0135cba0b04d11e498db8b09b4f043e0"
    Then the user can read the label listing the countries as "Jurisdictions"
