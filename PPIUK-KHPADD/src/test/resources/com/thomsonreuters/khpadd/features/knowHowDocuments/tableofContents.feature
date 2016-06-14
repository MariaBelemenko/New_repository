Feature: [730574] [730575] - Removal of Show/Hide icons, numbering and splitters from the table of contents for any know how resource
[873954]TOC numbering for Standard docs
@manual
 Scenario: Verify that the Show/Hide icons on the table of content is not present for any of the resources
   Given PL+ user is logged in
    When the user navigates to any know How resource (Eg: https://plcuk.next.demo.westlaw.com/Document/I0206eb261cb611e38578f7ccc38dcbee/View/FullText.html)
    And views the table of contents for that resource
    Then the Show/Hide icons are no more visible
@manual
 Scenario: Verify removal of numbering and splitters from the table of contents of a resource page
   Given PL+ user is logged in
   When the user navigates to any know How resource (Eg: https://plcuk.next.demo.westlaw.com/Document/I0206eb261cb611e38578f7ccc38dcbee/View/FullText.html)
   And views the table of contents for that resource
   Then the numbering and the splitters are no more visible

#remove after QED deploy 15 June
@wip
Scenario: [873954]Verify numbering in the table of contents for Standard docs
   Given PL+ user is logged in
   When user navigates directly to document with guid "Ib93e1df5023011e698dc8b09b4f043e0"
   Then the numbering is present in ToC