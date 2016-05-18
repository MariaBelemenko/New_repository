@wip
Feature: [888967] As a PL+ user I want to see Journal doc Abstract so that I can quickly review key information about article

  Background: 
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

  #TODO
  @now
  Scenario Outline: [888967] user is able to see journal abstract publication index document
    When the user opens document with guid <guid>
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the title is displayed in the document
    #And the autor is dispalyed in the document
    #And the Provided by Westlaw UK icon is displayed
    #And the "Reviewed by" subsection is displayed with value
    #And the "Publisher" subsection is displayed with value
    #And the "ISBN" subsection is displayed with value
    #nd the "Price" subsection is displayed with value
    #And the "Format" subsection is displayed with value
    #And the "No. of pages" subsection is displayed with value

    Examples: 
      | guid                              |
      | IAED4F9A0924511E59E5ED34C382BD9CE |

  #TODO
  Scenario Outline: [888967] user is able to see journal article abstract document
    When the user opens document with guid <guid>
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the title is displayed in the document
    And the autor is dispalyed on the document
    And the Provided by Westlaw UK icon is displayed
    Then the "<subsection>" subsection is displayed with value

    Examples: 
      | guid                              | subcestion          |
      | ID7CD09D2E08311DEBB6BFDBCBBDE1522 | Abstract            |
      | IC2A6A5C0E28311E1AF4BB40F39FD270C | Organizations cited |


#TODO
  Scenario Outline: [888967] user is able to see the useful websited section on journal page
    When the user opens document with guid <guid>
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the "<subsection>" subsection is displayed with value
    When the user clicks on "<internallLink>" in "<subsection>" subsection
    When the user clicks on "View Document" link
    Then the document opens correctly
    And document title is displayed as "<linkedDoc>"

    Examples: 
      | guid                              | subsection             | internalLink                                                  | linkedDoc                                         |
      | I044586B07B4611E4A15DE99780331015 | Key cases cited:       | Aswat v United Kingdom (17299/12) (2014) 58 E.H.R.R. 1 (ECHR) | Aswat v United Kingdom (17299/12)                 |
      | I28D78E607B4611E4A15DE99780331015 | Key cases cited:       | BBC, Re [2014] UKSC 25; [2015] A.C. 588 (SC)                  | BBC, Re                                           |
      | I044B2C007B4611E4A15DE99780331015 | Key legislation cited: | Matrimonial and Family Proceedings Act 1984 (c.42)            | Matrimonial and Family Proceedings Act 1984 c. 42 |
