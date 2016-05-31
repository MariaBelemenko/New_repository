Feature: [895133] As a PL+ user I want to see Journal publication index document 

   Background:
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |


  Scenario Outline: [895133] user is able to see journal publication index document
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the title is displayed in the document
    And the "Reference" subsection is displayed with value
    And the "No-punctuation referense" subsection is displayed with value
    And the "ISBN/ISSN" subsection is displayed with value
    And the "Database indexed in" subsection is displayed with value
    And the "Publisher" subsection is displayed with value
    And the "Publishers' house" subsection is displayed with value
    And the "Publishers' telephone no" subsection is displayed with value
    And the "Frequency" subsection is displayed with value
    And the "Subscription cost:" subsection is displayed with value
    
    Examples: 
      | guid                              |
      | IDD2459A070C811DD92AFD59E6F869F29 |