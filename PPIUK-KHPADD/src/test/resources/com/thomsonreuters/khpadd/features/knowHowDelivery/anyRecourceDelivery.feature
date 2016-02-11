Feature: Verify KnowHow delivery functionality for any resource (except std document with drafting notes)

  Background:
    Given PL+ user is logged in

  Scenario:(bug 833268) Edit and Verify Email Delivery Options and send email for any resource (except std document with drafting notes) with annotations and with table of contents
    When user navigates directly to document with guid "I8417ae7f1cb111e38578f7ccc38dcbee"
    When user added new annotation
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject           | Practical Law - Best or reasonable endeavours? |
      | Email Note        | optional notes                                 |
      | Table of Contents | Selected                                       |
      | Annotations       | Not Selected                                   |
    And the user edits the basic email options as follows
      | To                | deliveryTests@mailinator.com  |
      | Subject           | Practical Law - Resource      |
      | Email Note        | Resource for your Information |
      | Format            | PDF                           |
      | Table of Contents | Selected                      |
      | Annotations       | Selected                      |
    And the user clicks on Email advanced tab
    And the user should be able to see Email advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |
    When the user edits the advanced email options as follows
      | Cover Page | Selected |
    Then the cover page comment textbox is displayed
    And an email is sent successfully by clicking on the Email button

  #There is a known issue with this, please leave
  @bug
  Scenario: Verify email functionality resource with no Table of contents and no annotations
    When user navigates directly to document with guid "Ibda335689cc011e498db8b09b4f043e0"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Table of Contents | Selected |
    Then the following options will not be displayed
      | Annotations |

  Scenario: Verify email functionality for sending resource Only link
    When user navigates directly to document with guid "I8417ae7f1cb111e38578f7ccc38dcbee"
    And clicks on email delivery option for the document
    And the user selects "Resource Link Only" as email format
    Then the "Advanced" tab is not displayed
    And the following options get disabled
      | Table of Contents |
      | Annotations       |
    And an email is sent successfully by clicking on the Email button

  Scenario: Verify Print Form fields and default values for any resource (except std document with drafting notes) with annotations and with table of contents
    When user navigates directly to document with guid "I01e8643390af11e498db8b09b4f043e0"
    And user added new annotation
    And clicks on Print delivery option for the document
    Then the user should be able to see Print basic tab options as follows
      | Table of Contents | Selected     |
      | Annotations       | Not Selected |
    And the user clicks on Print advanced tab
    And the user should be able to see Print advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |

  Scenario: Edit Print Delivery Options and print any resource (except std document with drafting notes) with annotations and with table of contents
    When user navigates directly to document with guid "I01e8643390af11e498db8b09b4f043e0"
    And user added new annotation
    And clicks on Print delivery option for the document
    And the user edits the basic print options as follows
      | Table of Contents | Selected |
      | Annotations       | Selected |
    And the user clicks on Email advanced tab
    When the user edits the advanced print options as follows
      | Cover Page | Selected |
    Then the cover page comment textbox is displayed

  Scenario: Verify Print Delivery Options and print any resource (except std document with drafting notes) no Table of contents and no annotations
    When user navigates directly to document with guid "I002dcac8a7ce11e498db8b09b4f043e0"
    And clicks on Print delivery option for the document
    Then the user should be able to see Print basic tab options as follows
      | Table of Contents | Selected |
    Then the following options will not be displayed
      | Annotations |

  Scenario: Verify Download Form fields and default values for any resource (except std document with drafting notes) with annotations and with table of contents
    When user navigates directly to document with guid "I8417ae7f1cb111e38578f7ccc38dcbee"
    And user added new annotation
    And clicks on Download delivery option for the document
    Then the user should be able to see Download basic tab options as follows
      | Table of Contents | Selected     |
      | Annotations       | Not Selected |
    And the user clicks on Print advanced tab
    And the user should be able to see Download advanced tab options as follows
      | Expanded Margin for Notes | Not Selected |
      | Cover Page                | Not Selected |
      | Links                     | Blue         |
      | Font Size                 | Normal       |

  Scenario: Edit Download Delivery Options and download any resource (except std document with drafting notes) with annotations and with table of contents
    When user navigates directly to document with guid "I8417ae7f1cb111e38578f7ccc38dcbee"
    And user added new annotation
    And clicks on Download delivery option for the document
    And the user edits the basic download options as follows
      | Table of Contents | Selected       |
      | Annotations       | Selected       |
      | Format            | Microsoft Word |
    And the user clicks on Download advanced tab
    When the user edits the advanced download options as follows
      | Cover Page | Selected |
      | Links      | Black    |
      | Font Size  | Large    |
    Then the cover page comment textbox is displayed

  Scenario: Verify Download Delivery Options and download any resource (except std document with drafting notes) no Table of contents and no annotations
    When user navigates directly to document with guid "Ibda335689cc011e498db8b09b4f043e0"
    And clicks on Download delivery option for the document
    Then the user edits the basic download options as follows
      | Table of Contents | Selected             |
      | Format            | Word Processor (RTF) |
    Then the following options will not be displayed
      | Annotations |
