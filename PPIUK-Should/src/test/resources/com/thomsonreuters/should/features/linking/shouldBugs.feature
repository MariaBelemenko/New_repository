Feature: Scenarios with the SHOULD bugs for Linking project

  # COULD ISSUE: 852028:[REGRESSION] One link from related content is missed for the document "Judicial review procedure: a practical guide"
  # For plcRef 9-376-4010
  @bug
  Scenario Outline: For the sample docs verify the related content
    Given for "<PLC document>" I get the related content from Fatwire XML
    When for "<PLC document>" I get the NORM relations
    Then the related Content number should be equal
  Examples:
    | Practice Note | 9-376-4010 |

  # SHOULD ISSUE: 825928 RDDBUG: "Content referring..." section  shouldn't be displayed on document
  @manual @bug
  Scenario Outline: For the sample asset pages verify the related content
    Given for "<PLC document>" I get the related content from Fatwire XML
    When for "<DocFamilyGUID>" I get the asset NORM relations
    Then the related Content number should be equal
  Examples:
    | PLC document TYPE               | PLC document | DocFamilyGUID                     |
    | Case page                       | D-000-0937   | I5FD3F180880E11E0A5CFF51A80F15F60 |
    | Legislation Primary Source page | 4-505-6037   | IF2C7B27007CA11E5B038B5D277F7EA62 |
#The above scenario is part of asset pages project as well form the digital side. It is mpossibel to autoamte the content stuff
#So better to run it manually.

  # SHOULD ISSUE: 855204:[REGRESSION] There are no links to primary source documents in the "Bye-laws" document in PL+ UK
  @bug @manual
  Scenario Outline: For the sample doc verify the linking to other resource or specific section of other resource
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    And for "<PLC document>" I get all the links to other resource or specific section of other resource
    And for "<PLC document>" I get all the Primary Source links
    When for "<PLC document>" captures all the links to other resource or specific section of other resource
    Then for "<PLC document>" the number of links should be the equal
  Examples:
    | PLC document TYPE        | PLC document |
    | Practice Note - Overview | 1-519-0278   |
