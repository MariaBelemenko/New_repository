@e2e
Feature: E2E tests for Delivery

  Scenario Outline: Print the <Document Type Name> document type with <Print Option Name> print option
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on Print delivery option for the document
    Then the user download printable document with option '<Print Option Name>' and verifies that it contains '<Exists Phrases>' and not contains '<Non-exists Phrases>'
  Examples:
    | GUID                              | Print Option Name           | Exists Phrases                                  | Non-exists Phrases                     |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | This agreement is dated                         | Drafting                               |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | This agreement is dated,Drafting                |                                        |
    | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | Drafting                                        | This agreement is dated                |
    | I33f1535be8cd11e398db8b09b4f043e0 | Document                    | Insert new party in the parties clause          | Drafting                               |
    | I33f1535be8cd11e398db8b09b4f043e0 | Document and Drafting Notes | Insert new party in the parties clause,Drafting |                                        |
    | I33f1535be8cd11e398db8b09b4f043e0 | Only Drafting Notes         | Drafting                                        | Insert new party in the parties clause |
    | I68a322bf013611e498db8b09b4f043e0 | Document                    | Matt Molloy has added                           |                                        |

  Scenario Outline: Cancel print the document
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on Print delivery option for the document
    And user closes the delivery box by clicking on the cancel button
    And the download window should be absent
  Examples:
    | GUID                              |
    | I8417aeac1cb111e38578f7ccc38dcbee |

  Scenario Outline: Download a specific document type with <Download Option Name> delivery option (without Table of Contents)
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on Download delivery option for the document
    Then the delivery options dialog is present and What To Deliver option presence is '<Drafting notes>'
    And the user sets Table of Contents option to 'unselected' state
    And the user downloads document in format '<Format>' with option '<Download Option Name>' and verifies that it contains '<Exists Phrases>' and not contains '<Non-exists Phrases>'
    And the hyperlink "<TOC Link>" in downloaded PDF document does not exists
  Examples:
    | GUID                              | Download Option Name        | Exists Phrases                                 | Non-exists Phrases      | Drafting notes | Format | TOC Link                 |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | This agreement is dated                        | Drafting                | yes            | Pdf    | Inadequacy of damages    |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | This agreement is dated,Drafting               |                         | yes            | Pdf    | Inadequacy of damages    |
    | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | Drafting                                       | This agreement is dated | yes            | Pdf    | Inadequacy of damages    |
    | I266a85d33c4611e598dc8b09b4f043e0 | Document                    | Reference to any Event                         | This document contains  | yes            | Pdf    | Straddle period          |
    | I266a85d33c4611e598dc8b09b4f043e0 | Only Drafting Notes         | This document contains                         | Reference to any Event  | yes            | Pdf    | Straddle period          |
    | I03f4d785eee311e28578f7ccc38dcbee | Document                    | The US enacted antitrust laws                  |                         | no             | Pdf    | Other Antitrust Statutes |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | This agreement is dated                        | Drafting                | yes            | Rtf    |                          |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | This agreement is dated,Drafting               |                         | yes            | Rtf    |                          |
    | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | Drafting                                       | This agreement is dated | yes            | Rtf    |                          |
    | I266a85d33c4611e598dc8b09b4f043e0 | Document                    | Reference to any Event                         | This document contains  | yes            | Rtf    |                          |
    | I266a85d33c4611e598dc8b09b4f043e0 | Document and Drafting Notes | Reference to any Event,This document contains  |                         | yes            | Rtf    |                          |
    | I03f4d785eee311e28578f7ccc38dcbee | Document                    | The US enacted antitrust laws                  |                         | no             | Rtf    |                          |
    | I266a85d33c4611e598dc8b09b4f043e0 | Only Drafting Notes         | This document contains                         | Reference to any Event  | yes            | Rtf    |                          |
    | I8be84316c1c511e498db8b09b4f043e0 | Document                    | ESMA will update the tables on a regular basis |                         | no             | Rtf    |                          |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | This agreement is dated                        | Drafting                | yes            | Doc    |                          |
    | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | This agreement is dated,Drafting               |                         | yes            | Doc    |                          |
    | I266a85d33c4611e598dc8b09b4f043e0 | Only Drafting Notes         | This document contains                         | Reference to any Event  | yes            | Doc    |                          |
    | I2e24e270870a11e598dc8b09b4f043e0 | Document                    | EU and UK balance of competences on tax        |                         | no             | Doc    |                          |

  @wip
  Scenario Outline: Emailing the <Document Type Name> with <What to Deliver> and <Format> email option
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <Subject> |
    When the user edits the basic email options as follows
      | To                | tr-regression1@yandex.com |
      | Email Note        | <Document Type Name>      |
      | Format            | <Format>                  |
      | <What to Deliver> | Select                    |
    And Email button is clicked
    Then the user verifies that 'Preparing For Email' is displayed on the overlay
    And the user verifies that 'Ready For Email' is displayed on the overlay
    And user receives an email at "tr-regression1@yandex.com" with document in <Format> format and with subject "<Subject>"
  Examples:
    | Document Type Name | GUID                              | What to Deliver             | Format               | Subject                                                                                    |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | Microsoft Word       | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | Word Processor (RTF) | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document                    | PDF                  | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | Microsoft Word       | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | Word Processor (RTF) | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Only Drafting Notes         | PDF                  | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | Microsoft Word       | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | Word Processor (RTF) | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Document and Drafting Notes | PDF                  | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document                    | Microsoft Word       | Practical Law - Buyer obligations guarantee and indemnity clause: asset purchase agreement |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document                    | Word Processor (RTF) | Practical Law - Buyer obligations guarantee and indemnity clause: asset purchase agreement |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document                    | PDF                  | Practical Law - Buyer obligations guarantee and indemnity clause: asset purchase agreement |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Only Drafting Notes         | Microsoft Word       | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Only Drafting Notes         | Word Processor (RTF) | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Only Drafting Notes         | PDF                  | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document and Drafting Notes | Microsoft Word       | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document and Drafting Notes | Word Processor (RTF) | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Document and Drafting Notes | PDF                  | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |

  @wip
  Scenario Outline: Emailing the <Document Type Name> with <What to Deliver> and <Format> email option
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <Subject> |
    When the user edits the basic email options as follows
      | To         | tr-regression1@yandex.com |
      | Email Note | <Document Type Name>      |
      | Format     | Resource Link Only        |
    And Email button is clicked
    Then the user verifies that 'Preparing For Email' is displayed on the overlay
    And the user verifies that 'Ready For Email' is displayed on the overlay
    Then user receives an email at "<mailbox>" without attachments and with link to the UK document "<GUID>" and with subject "<Subject>"
    When user copies the link in valid format from email into the browser
    Then user should be presented with proper document "<Subject>"
  Examples:
    | Document Type Name | GUID                              | Subject                                                                                    |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard documents | I8417aeac1cb111e38578f7ccc38dcbee | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Practical Law - Buyer obligations guarantee and indemnity clause: asset purchase agreement |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |
    | Standard clauses   | I33f1535be8cd11e398db8b09b4f043e0 | Practical Law - Confidentiality agreement: corporate seller: acquisitions                  |

  @wip
  Scenario Outline: Emailing the <Document Type Name> with <Format> email option
    Given PL+ user is logged in
    When user navigates directly to document with guid "<GUID>"
    And clicks on email delivery option for the document
    Then the user should be able to see Email basic tab options as follows
      | Subject | <Subject> |
    When the user edits the basic email options as follows
      | To         | tr-regression1@yandex.com |
      | Email Note | <Document Type Name>      |
      | Format     | <Format>                  |
    And Email button is clicked
    Then the user verifies that 'Preparing For Email' is displayed on the overlay
    And the user verifies that 'Ready For Email' is displayed on the overlay
    Then user receives an email at "<mailbox>" without attachments and with link to the UK document "<GUID>" and with subject "<Subject>"
    When user copies the link in valid format from email into the browser
    Then user should be presented with proper document "<Subject>"
  Examples:
    | Document Type Name | GUID                              | Format               | Subject                                                                               |
    | Articles           | I68a322bf013611e498db8b09b4f043e0 | Microsoft Word       | Practical Law - Blog post: Adjudicators determining party-party costs in adjudication |
    | Articles           | I68a322bf013611e498db8b09b4f043e0 | Word Processor (RTF) | Practical Law - Blog post: Adjudicators determining party-party costs in adjudication |
    | Articles           | I68a322bf013611e498db8b09b4f043e0 | PDF                  | Practical Law - Blog post: Adjudicators determining party-party costs in adjudication |
    | Articles           | I68a322bf013611e498db8b09b4f043e0 | Resource Link Only   | Practical Law - Blog post: Adjudicators determining party-party costs in adjudication |
    | Practice note      | I03f4d785eee311e28578f7ccc38dcbee | Microsoft Word       | Practical Law - US Antitrust Laws: Overview                                           |
    | Practice note      | I03f4d785eee311e28578f7ccc38dcbee | Word Processor (RTF) | Practical Law - US Antitrust Laws: Overview                                           |
    | Practice note      | I03f4d785eee311e28578f7ccc38dcbee | PDF                  | Practical Law - US Antitrust Laws: Overview                                           |
    | Practice note      | I03f4d785eee311e28578f7ccc38dcbee | Resource Link Only   | Practical Law - US Antitrust Laws: Overview                                           |
    | Legal update       | I8be84316c1c511e498db8b09b4f043e0 | Microsoft Word       | Practical Law - ESMA publishes overviews of all guidelines and technical standards    |
    | Legal update       | I8be84316c1c511e498db8b09b4f043e0 | Word Processor (RTF) | Practical Law - ESMA publishes overviews of all guidelines and technical standards    |
    | Legal update       | I8be84316c1c511e498db8b09b4f043e0 | PDF                  | Practical Law - ESMA publishes overviews of all guidelines and technical standards    |
    | Legal update       | I8be84316c1c511e498db8b09b4f043e0 | Resource Link Only   | Practical Law - ESMA publishes overviews of all guidelines and technical standards    |
    | Checklist          | I33f13063e8cd11e398db8b09b4f043e0 | Microsoft Word       | Practical Law - Wire Transfer Regulation: checklist                                   |
    | Checklist          | I33f13063e8cd11e398db8b09b4f043e0 | Word Processor (RTF) | Practical Law - Wire Transfer Regulation: checklist                                   |
    | Checklist          | I33f13063e8cd11e398db8b09b4f043e0 | PDF                  | Practical Law - Wire Transfer Regulation: checklist                                   |
    | Checklist          | I33f13063e8cd11e398db8b09b4f043e0 | Resource Link Only   | Practical Law - Wire Transfer Regulation: checklist                                   |
