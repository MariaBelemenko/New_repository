@manual
Feature: verify the nature of the delivered documents

  Scenario: verify delivery of a document by email/print/download
    Given PL+ user is logged in
    When user navigates directly to document with guid "I33f105ace8cd11e398db8b09b4f043e0"
    And adds a annotation to this document by selecting some text and adding a note
    And emails/prints/downloads this document with Table of contents and annotations checkbox ON
    Then the document should be appropriately emailed/downloaded/printed
    And the user verifies the delivered document for the following
      | Table of Contents has to be delivered                                                                           |
      | Format of the document delivered should be as selected in the delivery dialog boxes                             |
      | Annotations have to be delivered with proper timestamp                                                          |
      | Cover page comment has to be delivered with proper UK timestamp if it was selected in the delivery dialog boxes |
      | Metadata of the document like the jurisdictions and resource type should be appropriate                         |

  Scenario: verify delivery of list of documents (topic Page) by email/print/download
    Given PL+ user is logged in
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    And user selects the following resources for delivery
      | Employment contract for a senior employee |
      | Garden leave clause                       |
      | Bonus toolkit                             |
    And emails these documents with following options
      | What to deliver - Documents                      |
      | Table of Contents - ON                           |
      | Annotations - ON                                 |
      | Format - any                                     |
      | As - A Single Merged File / Multiple Files (zip) |
    And edits the advanced tab options as follows
      | Cover Page - Selected                 |
      | Cover Page comment - Testing manually |
      | Font Size - Normal                    |
      | Links - Blue                          |
      | Underline - checked On                |
    Then the delivered document should be verified for the following
      | Documents are delivered as a single merged file / multiple zip files                       |
      | Table of Contents has to be delivered                                                      |
      | Format of the document delivered should be as selected in the delivery dialog boxes        |
      | Annotations have to be delivered with proper timestamp                                     |
      | Cover page comment has to be delivered with proper UK timestamp                            |
      | Metadata of the document like the jurisdictions and resource type should be appropriate    |
      | No Related content and resource history link should be displayed on the delivered document |

  Scenario: Verify the footer of the delivered document
    When the user delivers any document or list of documents
    Then the delivered document should have the footer as follows
      | © 2015 Thomson Reuters. All rights reserved. |

  Scenario: Verify the footer of the delivered documents in Excel format
    When the user delivers any list of documents in Excel format
    Then the delivered document should have the footer as follows
      | © 2015 Thomson Reuters. All rights reserved. |

  @bug
  Scenario:[Bug# 791288] Verify the footer of the delivered document with cover page option checked on
    When the user delivers any document or list of documents with cover page option ON
    Then the cover page of the delivered document should have the footer as follows
      | © 2015 Thomson Reuters. All rights reserved. |