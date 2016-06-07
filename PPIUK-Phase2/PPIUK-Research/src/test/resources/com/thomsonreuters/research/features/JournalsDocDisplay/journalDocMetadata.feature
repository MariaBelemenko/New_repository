Feature: [888971] As a user I want to see Journals document metadata so that I can easily operate with this information and use it for further research

  Background: 
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

# TODO need requerements clarification
@wip
  Scenario Outline: [888971] metadata of journal abstract document contains publication link
    When the user opens document with guid "<guid>"
    Then the document block is displayed
    And the metadata is displayed on the right hand side of the central column
    And the metadata contains document type "<documentType>"
    And the metadata contains field "<field1>" with value
    And the metadata contains field "<field2>" with value
    When the user clicks on publication link in metadata
    Then the user is taken to the document with type "<type>"
    And the metadata in not displayed in the document

    Examples: 
      | guid                              | field1  | field2                 | documentType       | type     |
      | I7179AEC09ED911E5A0BCA562A48F6129 | Subject | Keywords               | Journal Article    | pubindex |
      | I3C380621BCB211E088B6DD372BC68113 | Subject | Other related subjects | Publication Review | pubindex |


  Scenario Outline: [888971] metadata of journal abstract document contains link to full text
    When the user opens document with guid "<guid>"
    Then the document block is displayed
    And the metadata is displayed on the right hand side of the central column
    When the user clicks on citation link in metadata
    Then the user is taken to the document with type "<type>"

    Examples: 
      | guid                              | type    |
      | I3C380621BCB211E088B6DD372BC68113 | journal |


  Scenario Outline: [888971] journal full text document contains metadata
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the metadata is displayed on the right hand side of the central column
    And the metadata contains document type "<documentType>"
    And the metadata contains citation
    And the metadata contains field "<field1>" with value
    And the metadata contains field "<field2>" with value
    And the metadata contains field "<field3>" with value

    Examples: 
      | guid                              | documentType                   | field1  | field2                 | field3   |
      | I4DD732107BA011E49E919D7445422692 | Journal Article - Case Comment | Subject | Other related subjects | Keywords |
      | IADFEFE807B4F11E499B9D6E1F6E110C8 | Journal Article - Editorial    | Subject | Other related subjects | Keywords |

  #TODO when the content task for publication links in journal fulltext document will be ready
  @wip
  Scenario Outline: [888971] journal full text document contains link to publication indexed in metadata
    When the user opens document with guid "<guid>"
    And the user clicks on link "View Document"
    Then the document block is displayed
    And the metadata is displayed on the right hand side of the central column
    When the user clicks on publication link in metadata
    Then the user is taken to the document with type "<type>"

    Examples: 
      | guid                              | type                        |
      | I4DD732107BA011E49E919D7445422692 | pubindex                    |
      | IADFEFE807B4F11E499B9D6E1F6E110C8 | Journal Article - Editorial |
