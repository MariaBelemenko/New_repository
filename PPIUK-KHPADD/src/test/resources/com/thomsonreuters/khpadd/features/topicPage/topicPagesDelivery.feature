Feature: Verify KnowHow delivery(Email/Print/Download) functionality for list of Items (Topic Page)

  Scenario: Verify the delivery icons functionality on the topic page based on editor's pick selection
    Given PL+ user is logged in
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    When the user selects the following Editor's Picks resources
      | Employment contract for a senior employee                   |
      | Acting for an employee entering into an employment contract |
    Then the following icons are enabled
      | Email          |
      | Print          |
      | Download       |
      | Save to Folder |
    When the user unselects the following Editor's Picks resources
      | Employment contract for a senior employee                   |
      | Acting for an employee entering into an employment contract |
    Then the following icons are disabled
      | Email          |
      | Print          |
      | Download       |
      | Save to Folder |

  Scenario: Verify the delivery icons functionality on the topic page based on other resources selection
    Given PL+ user is logged in
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    And the user selects the following Topic page resources
      | Change of control clauses |
      | Data protection clause    |
    Then the following icons are enabled
      | Email    |
      | Print    |
      | Download |
    When the user unselects the following Topic page resources
      | Change of control clauses |
      | Data protection clause    |
    Then the following icons are disabled
      | Email    |
      | Print    |
      | Download |

  Scenario: Verify Email functionality for List of Items delivery on topic Page using the List of items option
    Given PL+ user is logged in
    When the user navigates to practice area "Property" filtered by "Development" topic page
    Then the user is presented with a topic page with title "Development"
    When the user selects the following Editor's Picks resources
      | Land promotion agreement |
    And the user selects the following Topic page resources
      | Building Regulations: an overview |
      | Building Regulations: enforcement |
    When user scroll down the resource by offset 20
    When the user selects "Email" delivery option on Topics Page
    And the user edits the basic email options as follows
      | List of Items | Selected |
    Then the user should be able to see Email basic tab options as follows
      | Subject       | Practical Law - List of 3 results for Development |
      | Email Note    | optional notes                                    |
      | List of Items | Selected                                          |
      | Documents     | Not Selected                                      |
    And the user edits the basic email options as follows
      | To            | deliveryTests@mailinator.com      |
      | Subject       | Practical Law - List of 3 results |
      | Email Note    | List of resources                 |
      | List of Items | Selected                          |
      | Format Value  | PDF                               |
    And the user clicks on Email advanced tab
    Then the 'Expanded Margin for Notes' is not displayed on the advanced tab
    And the user should be able to see Email advanced tab options as follows
      | Cover Page | Not Selected |
      | Links      | Blue         |
      | Font Size  | Normal       |
    When the user edits the advanced email options as follows
      | Cover Page | Selected |
      | Links      | Blue     |
      | Underline  | Selected |
      | Font Size  | Normal   |
    And the cover page comment textbox is displayed
    And an email with the list of resources is sent successfully by clicking on the Email button

  Scenario: Verify Resource Link only option is available when only one document is selected on topic page
    Given PL+ user is logged in
    When the user navigates to practice area "Property" filtered by "Land registration" topic page
    Then the user is presented with a topic page with title "Land Registration"
    When the user selects the following Editor's Picks resources
      | The registration gap and the case of Brown and Root |
    When the user selects "Email" delivery option on Topics Page
    And the user edits the basic email options as follows
      | To         | deliveryTests@mailinator.com    |
      | Subject    | Practical Law - Single document |
      | Email Note | Single Document                 |
      | Format     | Resource Link Only              |
    And an email is sent successfully by clicking on the Email button

  @bug
  Scenario: (bug 854990)[781128] Verify delivery of single or 2 standard documents from the Topic Page (bug 833268)
    Given PL+ user is logged in
    When the user navigates to practice area "Corporate" filtered by "Asset acquisitions" topic page
    And clicks on the facet group "Standard Documents and Clauses"
    When the user selects the following Topic page resources
      | Asset purchase agreement short form |
    When the user selects "Email" delivery option on Topics Page
    Then the user should be able to see Email basic tab options as follows
      | Subject                     | Practical Law - Asset purchase agreement short form |
      | Email Note                  | optional notes                                      |
      | Document                    | Selected                                            |
      | Only Drafting Notes         | Not Selected                                        |
      | Document and Drafting Notes | Not Selected                                        |
      | Table of Contents           | Selected                                            |
    Then user closes the delivery box by clicking on the cancel button
    When the user selects the following Topic page resources
      | Assignment of rights in software            |
      | Board briefing note (skeleton): acquisition |
    And the user selects "Email" delivery option on Topics Page
    Then the user should be able to see Email basic tab options as follows
      | Email Note | optional notes |
    And the user edits the basic email options as follows
      | To                | deliveryTests@mailinator.com       |
      | Subject           | Practical Law - Multiple documents |
      | Email Note        | Multiple Documents                 |
      | Documents         | Selected                           |
      | Table of Contents | Selected                           |
      | Annotations       | Selected                           |
    And an email with the list of resources is sent successfully by clicking on the Email button

  Scenario:(bug 833268) Verify Email functionality for List of Items delivery on topic Page using the Documents option(zipped format)
    Given PL+ user is logged in
    When the user navigates to practice area "Property" filtered by "Development" topic page
    Then the user is presented with a topic page with title "Development"
    When the user selects the following Editor's Picks resources
      | Land promotion agreement |
    And the user selects the following Topic page resources
      | Building Regulations: an overview |
    When user scroll down the resource by offset 20
    When the user selects "Email" delivery option on Topics Page
    And the user edits the basic email options as follows
      | Documents | Selected             |
      | Format    | Word Processor (RTF) |
      | As        | A Single Merged File |
    Then the user should be able to see Email basic tab options as follows
      | Subject           | Practical Law - 2 full text items for Development |
      | Email Note        | optional notes                                    |
      | List of Items     | Not Selected                                      |
      | Documents         | Selected                                          |
      | Table of Contents | Selected                                          |
      | Format            | Word Processor (RTF)                              |
      | As                | A Single Merged File                              |
    And the user edits the basic email options as follows
      | To         | deliveryTests@mailinator.com     |
      | Subject    | Practical Law - 2 full documents |
      | Email Note | Full resources                   |
      | As         | Multiple Files (zip)             |
    And the user clicks on Email advanced tab
    When the user edits the advanced email options as follows
      | Links     | Black    |
      | Underline | Selected |
      | Font Size | Large    |
    And the user should be able to see Email advanced tab options as follows
      | Cover Page                | Not Selected |
      | Links                     | Black        |
      | Expanded Margin for Notes | Not Selected |
      | Font Size                 | Large        |
      | Underline                 | Selected     |
    When the user edits the advanced email options as follows
      | Cover Page                | Selected     |
      | Expanded Margin for Notes | Selected     |
      | Links                     | Blue         |
      | Underline                 | Not Selected |
      | Font Size                 | Normal       |
    And the cover page comment textbox is displayed
    And an email with the list of resources is sent successfully by clicking on the Email button

  Scenario: Verify Email functionality for List of Items delivery on topic Page using the Documents option(A single merged file format)
    Given PL+ user is logged in
    When the user navigates to practice area "Property" filtered by "Development" topic page
    Then the user is presented with a topic page with title "Development"
    When the user selects the following Editor's Picks resources
      | Land promotion agreement |
    And the user selects the following Topic page resources
      | Building Regulations: an overview |
    When user scroll down the resource by offset 20
    When the user selects "Email" delivery option on Topics Page
    And the user edits the basic email options as follows
      | Documents | Selected             |
      | Format    | PDF                  |
      | As        | A Single Merged File |
    And an email with the list of resources is sent successfully by clicking on the Email button
