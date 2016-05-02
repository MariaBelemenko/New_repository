Feature: Verify Should bugs for KHPADD (Bug# 786498) - Foldering icon not getting enabled when a resource at the bottom of the list is being selected on Topic page
  (Bug# 833268 - Regression - Subject field in Email dialog box is missing the text "Practical Law")
  (Bug# 847775 - Regression - Application error when trying to access a resource of type Case Study)
  (Bug# 861858 - Glossary: Related content is incorrectly appearing)

  Background:
    Given PL+ user is logged in
    
#@wip need be removed after release (9 may)    
@wip
  Scenario Outline: (BUG# 861858)Verify  the related content in pop-up window that appears for Glossary term
    And user navigates directly to document with guid "<doc>"
    And clicks on document link "<link>"
    Then user verifies related content in popup window  
      |Interim applications under the CPR: an overview |
      |Stakeholder claims and applications: Flowchart|
  Examples:
    |doc								|link|
    |I28015ee5699c11e498db8b09b4f043e0	|master|	  

  @bug
  Scenario:(BUG# 786498)Verify the delivery icons functionality on the topic page based on other resources selection
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    And the user selects the following Topic page resources
      | Change of control clauses |
      | Data protection clause    |
    Then the following icons are enabled
      | Save to Folder |
    When the user unselects the following Topic page resources
      | Change of control clauses |
      | Data protection clause    |
    Then the following icons are disabled
      | Save to Folder |

  @bug
  Scenario:(bug# 833268) [781128] Verify delivery of single or 2 standard documents from the Topic Page
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

  @bug
  Scenario Outline:(bug# 847775) Check correct metadata is displayed for "<document Description>"
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    Then document title is displayed as "<title>"
    And "<author>" is displayed underneath the title
    And resource status "<resource status>" is displayed on the document right hand panel
    And following jurisdictions are displayed on the document right hand panel
      | <jurisdictions> |
    And 'View Resource History' link is <resource history> on the right hand panel
    And 'Related Content' link is <related content> on the right hand panel
    And resource type is displayed as "<documentType>" on right hand panel
    And plc reference is displayed as "<plc ref>"
  Examples:
    | guid                              | title                                                                         | author                                   | resource status          | jurisdictions    | resource history | related content | documentType | plc ref    |
    | I3351aa2ee8da11e398db8b09b4f043e0 | Case study: Andrew Garard - Making the move from in-house to private practice | Author: William Long, PLC Law Department | Published on 24-Jul-2007 | No jurisdictions | Not displayed    | displayed       | Case Study   | 0-373-7988 |

  #848618 - Impossible to link to relevant Topic page from 'Also found in' section by OW user
  @bug
  Scenario: (bug#848618)[846363] Also Found in section available for OW users
    Given PL+ user is not logged in
    When user navigates directly to document with guid "I59a19233e04611e398db8b09b4f043e0"
    Then the user sees Also found in section
    And Also Found In section includes link to the relevant Topic page