Feature: [888967] As a PL+ user I want to see Journal doc Abstract so that I can quickly review key information about article

  Background: 
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

  Scenario Outline: [888967] user is able to see journal abstract publication index document
    When the user opens document with <guid> guid
    Then the document opens correctly
    Then the title is diaplayed in the document
    And the autor is dispalyed in the document
    And the Provided by Westlaw UK icon is displayed
    And the "Reviewed by" subsection is displayed
    And the "Publisher" subsection is displayed
    And the "ISBN" subsection is displayed
    And the "Price" subsection is displayed
    And the "Format" subsection is displayed
    And the "No. of pages" subsection is displayed

    Examples: 
      | guid                              |
      | I34E2F2309C0711E4ABBBADAAA4F7D653 |
      | I36564230FDB811E4ABD6CBDDF2736E09 |
      | I89CC49B0FA9711E49CDBA95B00781B0C |

  Scenario Outline: [888967] user is able to see journal article abstract document
    When the user opens document with <guid> guid
    Then the document opens correctly
    Then the title is diaplayed on the document
    And the autor is dispalyed on the document
    And the Provided by Westlaw UK icon is displayed
    Then the "Abstract" subsection is displayed
    And the "Userful websites" subsection is displayed
    And the "Key cases" subsection is displayed
    And the "Key legislation cited" subsection is displayed
    And the "Organizations cited" subsection is displayed
    When the user selects "<internalLink>"
    Then the document opens correctly
    And document title is displayed as "<linkedDoc>"
    When the user opens document with <guid> guid
    When the user selects "<externalLink>"
    Then the user is taken to "<webSite>" resource

    Examples: 
      | guid                              | internalLink  | linkedDoc  | webSite  |
      | I34E2F2309C0711E4ABBBADAAA4F7D653 | internal link | linked doc | web site |
