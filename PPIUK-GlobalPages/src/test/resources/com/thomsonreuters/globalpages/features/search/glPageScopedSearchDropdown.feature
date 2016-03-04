Feature: As a PL+ User, I am able to search for an individual country instead , rather than all content

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify the scop search drop down
    Then the user can verify that the scoped search dropdown states "All Global Content"
    Then the scoped search drop down contains the following countries
      | United Kingdom           |
      | United States of America |
      | Canada                   |
      | China                    |
      | Australia                |
      | Argentina                |
      | Australia                |
      | Austria                  |
      | Bahrain                  |
      | Belgium                  |
      | Bermuda                  |
      | Brazil                   |
      | British Virgin Islands   |
      | Bulgaria                 |
      | Canada                   |
      | Cayman Islands           |
      | Channel Islands-Guernsey |
      | Channel Islands-Jersey   |
      | Chile                    |
      | China                    |
      | Colombia                 |
      | Croatia                  |
      | Cyprus                   |
      | Czech Republic           |
      | Denmark                  |
      | Egypt                    |
      | Estonia                  |
      | Finland                  |
      | France                   |
      | Germany                  |
      | Gibraltar                |
      | Greece                   |
      | Hong Kong - PRC          |
      | Hungary                  |
      | Iceland                  |
      | India                    |
      | Indonesia                |
      | Ireland                  |
      | Isle of Man              |
      | Israel                   |
      | Italy                    |
      | Japan                    |
      | Kazakhstan               |
      | Liechtenstein            |
      | Lithuania                |
      | Luxembourg               |
      | Malaysia                 |
      | Malta                    |
      | Mexico                   |
      | New Zealand              |
      | Nigeria                  |
      | Norway                   |
      | Oman                     |
      | Peru                     |
      | Poland                   |
      | Portugal                 |
      | Qatar                    |
      | Romania                  |
      | Russian Federation       |
      | Saudi Arabia             |
      | Scotland                 |
      | Serbia                   |
      | Singapore                |
      | Slovenia                 |
      | South Africa             |
      | South Korea              |
      | Spain                    |
      | Sweden                   |
      | Switzerland              |
      | Taiwan                   |
      | Thailand                 |
      | The Netherlands          |
      | Turkey                   |
      | Ukraine                  |
      | United Arab Emirates     |
      | United Kingdom           |
      | United States of America |
      | Venezuela                |
      | Vietnam                  |
    And the countries are sorted in alphabetical order
    When user selects the dropdown option "<country>"
    Then the scoped search dropdown states "<country>"
    When the user runs a free text search for the query "tax"
    And the user can select the option to show more detail
    Then the returned results contain the search "tax"
    Then the results is refined to only include that "<country>" jurisdiction
    Then the scoped search drop down contains the initial list of countries
    And the user can open the first know how search result "1"
    Then the document opens correctly

  Examples:
    | country        |
    | United Kingdom |
