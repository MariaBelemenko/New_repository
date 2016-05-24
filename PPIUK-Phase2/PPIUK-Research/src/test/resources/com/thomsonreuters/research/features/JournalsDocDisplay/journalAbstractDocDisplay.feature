Feature: [888967] As a PL+ user I want to see Journal doc Abstract so that I can quickly review key information about article

  Background:
    Given PL+ user is logged in

  Scenario Outline: [888967] user is able to see journal abstract publication index document
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the title is displayed in the document
    And the autor is displayed in the document
    And the Provided by Westlaw UK icon is displayed
    And the "Reviewed by" subsection is displayed with value
    And the "Publisher" subsection is displayed with value
    And the "ISBN/ISSN" subsection is displayed with value
    And the "Price" subsection is displayed with value
    And the "Format" subsection is displayed with value
    And the "No. of pages" subsection is displayed with value

    Examples: 
      | guid                              |
      | IAED4F9A0924511E59E5ED34C382BD9CE |
      | I43996942DB5711E08B4DC2FE2E0638D3 |
      | I62592430BBFC11E5812DEC020C645CDF |


  Scenario Outline: [888967] user is able to see journal article abstract document
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the title is displayed in the document
    And the autor is displayed in the document
    And the Provided by Westlaw UK icon is displayed
    Then the "<subsection1>" subsection is displayed with value
    Then the "<subsection2>" subsection is displayed with value
    Then the "<subsection3>" subsection is displayed with value

    Examples: 
      | guid                              | subsection1      | subsection2            | subsection3          |
      | I1BFB0960A4EF11DF8258C23352F0181D | Abstract         | Key legislation cited: | Key cases cited:     |
      | I1BFD5351A4EF11DF8258C23352F0181D | Abstract         | Key legislation cited: | Key cases cited:     |
      | I1BFDA170A4EF11DF8258C23352F0181D | Abstract         | Key legislation cited: | Key cases cited:     |
      | ID6835400371511E5BBE28AEF7AC96856 | Key cases cited: | Key legislation cited: | Organisations cited: |
      | I4E4169A0B5A111E5B5F2981C65394A82 | Abstract         | Key cases cited:       | Organisations cited: |


  Scenario Outline: [888967] user is able to see link in key cases cited subsection in journal page
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    When the user clicks on link "<linkText>" in subsection "<subsection>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And document title is displayed as "<linkedDoc>"

    Examples: 
      | guid                              | subsection            | linkText                       | linkedDoc               |
      | I044586B07B4611E4A15DE99780331015 | Key cases cited       | Vinter v United Kingdom        | Vinter v United Kingdom |
      | I54E8F8C0E71311DA915EF37CAC72F838 | Key cases cited       | Bruton v London                | Bruton v London         |
      | I54C9D801E71311DA915EF37CAC72F838 | Key legislation cited | Wildlife and Countryside Act   | Arrangement of Act      |
      | I548E2E91E71311DA915EF37CAC72F838 | Key legislation cited | School Standards and Framework | Arrangement of Act      |
      
