Feature: Verify KnowHow delivery functionality for Standard documents with drafting notes

  Background:
    Given PL+ user is logged in

  Scenario: Verify and Edit Email Delivery Options and send email for Standard documents with drafting notes having Annotations and Table of Contents
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And user added new annotation
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject                     | Amendment and restatement agreement |
      | Email Note                  | optional notes                      |
      | Document                    | Selected                            |
      | Only Drafting Notes         | Not Selected                        |
      | Document and Drafting Notes | Not Selected                        |
      | Table of Contents           | Selected                            |
    And the user edits the basic email options as follows
      | To                | deliveryTests@mailinator.com          |
      | Subject           | Practical Law - Std document Resource |
      | Email Note        | Resource for your Information         |
      | Format            | Microsoft Word                        |
      | Document          | Selected                              |
      | Table of Contents | Selected                              |
    And the user clicks on Email advanced tab
    Then the user should be able to see Email advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |
    When the user edits the advanced email options as follows
      | Cover Page | Selected |
    Then the cover page comment textbox is displayed
    And an email is sent successfully by clicking on the Email button

  Scenario: Verify email functionality for sending resource Only link
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And clicks on email delivery option for the document
    And the user selects "Resource Link Only" as email format
    Then the "Advanced" tab is not displayed
    And the following options get disabled
      | Document                    |
      | Only Drafting Notes         |
      | Document and Drafting Notes |
      | Table of Contents           |
    And an email is sent successfully by clicking on the Email button

  Scenario: Verify Email functionality for Standard documents with drafting notes not having Annotations and Table of Contents
    When user navigates directly to document with guid "I072d6d86e84211e398db8b09b4f043e0"
    And clicks on email delivery option for the document
    Then the following options will not be displayed
      | Annotations |

  Scenario: Verify Print Form fields and default values for Standard documents with drafting notes having Annotations and Table of Contents
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And user added new annotation
    And clicks on Print delivery option for the document
    Then the user should be able to see Print basic tab options as follows
      | Document                    | Selected     |
      | Only Drafting Notes         | Not Selected |
      | Document and Drafting Notes | Not Selected |
      | Table of Contents           | Selected     |
    When the user clicks on Print advanced tab
    Then the user should be able to see Print advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |

  Scenario: Edit Print Delivery Options and print Standard documents with drafting notes having Annotations and Table of Contents
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And user added new annotation
    And clicks on Print delivery option for the document
    And the user edits the basic print options as follows
      | Document and Drafting Notes | Selected |
      | Table of Contents           | Selected |
    And the user clicks on Print advanced tab
    When the user edits the advanced print options as follows
      | Cover Page | Selected |
    Then the cover page comment textbox is displayed

  Scenario: Verify Print functionality for Standard documents with drafting notes not having Annotations and Table of Contents
    When user navigates directly to document with guid "I072d6d86e84211e398db8b09b4f043e0"
    And clicks on Print delivery option for the document
    Then the following options will not be displayed
      | Annotations |

  Scenario: Verify Download Form fields and default values for Standard documents with drafting notes having Annotations and Table of Contents
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And user added new annotation
    And clicks on Download delivery option for the document
    Then the user should be able to see Download basic tab options as follows
      | Document                    | Selected       |
      | Only Drafting Notes         | Not Selected   |
      | Document and Drafting Notes | Not Selected   |
      | Table of Contents           | Selected       |
      | Format                      | Microsoft Word |
    When the user clicks on Download advanced tab
    Then the user should be able to see Download advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |

  Scenario: Edit Download Delivery Options and download Standard documents with drafting notes having Annotations and Table of Contents
    When user navigates directly to document with guid "Ifc80a710e02811e398db8b09b4f043e0"
    And user added new annotation
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Document          | Selected             |
      | Table of Contents | Selected             |
      | Format            | Word Processor (RTF) |
    And the user clicks on Download advanced tab
    When the user edits the advanced download options as follows
      | Expanded Margin for Notes | Selected |
      | Cover Page                | Selected |
    Then the cover page comment textbox is displayed

  Scenario: Verify Download functionality for Standard documents with drafting notes not having Annotations and Table of Contents
    When user navigates directly to document with guid "I072d6d86e84211e398db8b09b4f043e0"
    And clicks on Download delivery option for the document
    Then the following options will not be displayed
      | Annotations |
