Feature: Ask-23 Data migration

  Scenario: Verify that the QUESTION table has the sample PLCref records

    Given a user connects to the Ask Database
    When queries for the PLCreference Then a record should appear
    |PLCreference|
    |a-013-5123  |
    |a-016-9338  |
    |a-001-5769  |
    |1-517-9054  |

  Scenario: Verify that the TEXT filed is not null for in the SUBMISSION_DATA table

    Given a user connects to the Ask Database
    When queries for the PLCreference Then the TEXT field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |
      |1-517-9054  |


  Scenario: Verify that the EMAIL filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the Email Then the Email field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |

  Scenario: Verify that the FIRSTNAME filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the FirstName Then the FirstName field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |
      |a-001-5769  |

  Scenario: Verify that the LASTNAME filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the LastName Then the LastName field should not be null
      |PLCreference|
      |a-013-5123  |
      |a-016-9338  |

  Scenario: Verify that the POSITION filed is equal in the SUBMISSION_DATA table and the SUBSCRIBER table

    Given a user connects to the Ask Database
    When queries for the Position Then the Position field should not be null
      |PLCreference|Value|
      |a-013-5123  |Solicitor|
      |a-016-9338  |Solicitor|

  Scenario: Verify the QUESTION_CATEGORY filed in the QUESTION table

    Given a user connects to the Ask Database
    When queries for the QuestionCategory Then the QuestionCategory field should match the Value
      |PLCreference|Value|
      |a-013-5123  |Substantive Query|
      |a-016-9338  |Substantive Query|
      |a-001-5769  ||
      |1-517-9054  ||

  Scenario: Verify the QUESTION_SOURCE filed in the QUESTION table

    Given a user connects to the Ask Database
    When queries for the QuestionSource Then the QuestionSource field should match the Value
      |PLCreference|Value|
      |a-013-5123  |Website|
      |a-016-9338  |Website|
      |a-001-5769  |DataImport|
      |1-517-9054  |DataImport|

  Scenario: Verify the ASSIGNED_TO filed in the QUESTION table and the corrsponding record in EDITOR table

    Given a user connects to the Ask Database
    When queries for the EditorUsername Then the EditorUsername field should match the Value
      |PLCreference|Value|
      |a-013-5123  ||
      |a-016-9338  |Katie Hewson|
      |a-001-5769  ||

  Scenario: Verify the ASK_NAME and FORM_NAME fileds in the PRACTICE_AREA table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the AskName and FormName Then the fields should match the Value
      |PLCreference|Value|
      |a-013-5123  |Property|
      |a-016-9338  |Public Sector|
      |a-001-5769  |Feedback|
      |1-517-9054  |Feedback|


  Scenario: Verify the ORGANISATION_NAME in the SUBSCRIBER table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the OrganisationName Then the OrganisationName should match the Value
      |PLCreference|Value|
      |a-013-5123  |Mole Valley District Council|
      |a-016-9338  |Staffordshire County Council|
      |1-517-9054  ||

  Scenario: Verify the ORGANISATION_TYPE in the SUBSCRIBER and SUBMISSION_DATA table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the OrganisationType Then the OrganisationType should match the Value
      |PLCreference|Value|
      |a-013-5123  |Public Sector|
      |a-016-9338  |Public Sector|
      |1-517-9054  ||

  Scenario: Verify the FINAL_DATE_OF_RESPONSE in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FinalDateofResponse Then the FinalDateofResponse should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-07 00:00:00|
      |a-016-9338  |2015-05-15 00:00:00|
      |1-517-9054  ||

  Scenario: Verify the CONTENT_SEARCH in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the Contentsearch Then the Contentsearch should match the Value
      |PLCreference|Value|
      |a-013-5123  |Directed to materials|
      |a-016-9338  |Directed to materials|
      |1-517-9054  |Directed to materials|
    # all the records have Directed to materials value . Sent mail to paddy for clarification.

  Scenario: Verify the STATUS filed in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the Status Then the Status field should match the Value
      |PLCreference|Value|
      |a-013-5123  |Closed|
      |a-016-9338  |Closed|
      |a-001-5769  |Closed|
      |1-517-9054  |Closed|

  Scenario: Verify the LAST_MODIFIED_ON in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the LastModifiedOn Then the LastModifiedOn should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-07 00:00:00|
      |a-016-9338  |2015-05-15 00:00:00|

  Scenario: Verify the DATE_CREATED_ON_ASK in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the DateCreatedOn Then the DateCreatedOn should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-06 00:00:00|
      |a-016-9338  |2015-05-14 00:00:00|

  Scenario: Verify the TITLE in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the Title Then the Title should match the Value
      |PLCreference|Value|
      |a-013-5123  |If an overriding lease is to be renewed, is the renewal lease also an "overriding lease"? And do you think we can propose changes to the form of the renewal lease?|
      |a-016-9338  |Party unwilling to be second respondent in First-tier Tribunal (Information Rights)|
      |a-001-5769  |a-001-5769|
      |1-517-9054  |1-517-9054|

  Scenario: Verify the SUBSCRIBER_REF in the SUBSCRIBER table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the SubscriberRef Then the SubscriberRef should match the Value
      |PLCreference|Value|
      |a-013-5123  |11784138|
      |a-016-9338  |11843626|
      |a-001-5769  |11345392|
      |1-517-9054  ||

  Scenario: Verify the PROMOTED_FROM in the QUESTION table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the PromotedFrom Then the PromotedFrom should match the Value
      |PLCreference|Value|
      |a-012-3327 |a-012-1636|
      |a-011-7707  |a-011-7650|

  Scenario: Verify the REASON_FOR_NOT_PUBLISHING in the PUBLICATION_DATA table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the ReasonforPublishing Then the ReasonforPublishing should match the Value
      |PLCreference|Value|
      |a-004-7723  |Human search question|
      |a-004-7771  |Answer is apparent from existing content|
      |a-001-5769  ||

  Scenario: Verify the TEXT in the NOTE table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the Text Then the Text should match the Value
      |PLCreference|Value|
      |a-013-5123  |I have done, I think, the answer to part 1 but as I am not entirely sure about 2 and the set up of the leases, would you be able to complete the 2nd part? Thanks - Lucy|
      |a-016-9338  ||
      |a-005-5678  |This actually appears more of a transactional question if someone else is able&#160; to pick it up? Thanks.:That looks absolutely right to me. Caroline:As the interim rent reimbursement is due to be paid|

  #  @bug- Ask-129
  Scenario: Verify the DATE_ADDED in the NOTE table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the DateAdded Then the DateAdded should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-06 00:00:00|
      |a-005-5678  |2013-10-04 00:00:00;2013-10-07 00:00:00;2013-10-07 00:00:00|

  Scenario: Verify the TEXT in the FOLLOWUP table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FollowupText Then the FollowupText should match the Value
      |PLCreference|Value|
      |a-013-5123  |Section 17 of the Landlord and Tenant (Covenants) Act 1995;This is very helpful|
      |a-005-5678  |of the LTA 1954, the interim rent is payable from the earliest date that could have been specified in the tenant's request|
      |1-517-9054  |Nothing in this communication shall be taken to constitute legal advice;Thanks for confirming|

  Scenario: Verify the DIRECTION in the FOLLOWUP table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the Direction Then the Direction should match the Value
      |PLCreference|Value|
      |a-013-5123  |Outbound;Inbound|
      |a-005-5678  |Outbound|
      |1-517-9054  |Outbound;Inbound|

  Scenario: Verify the STATUS in the FOLLOWUP table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FollowupStatus Then the FollowupStatus should match the Value
      |PLCreference|Value|
      |a-013-5123  |Emailed;Draft|
      |a-005-5678  |Emailed|
      |1-517-9054  |Draft;Draft|

  #  @bug - have too add timestamp- ASK 129
  Scenario: Verify the DATE_RECEIVED in the FOLLOWUP table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FollowupDateReeived Then the FollowupDateReeived should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-07 12:35:00|
      |1-517-9054  |2015-06-28 10:14:00|

  #  @bug - have too add timestamp ASK 129
  Scenario: Verify the DATE_SENT in the FOLLOWUP table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FollowupDateSent Then the FollowupDateSent should match the Value
      |PLCreference|Value|
      |a-013-5123  |2015-01-07 12:35:00|
      |a-016-9338  |2015-06-28 10:14:00|

# add one last rule later
  Scenario: Additional queries on Data rules

    Given a user connects to the Ask Database
    When queries the data rules from different tables they should be as expected

  #@bug- Ask -127
  Scenario: Verify the SOURCE_URL in the SUBMISSION_DATA table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the SOURCE_URL Then the SOURCE_URL should match the Value
      |PLCreference|Value|
      |a-004-9185   |   http://ipandit.practicallaw.com/3-532-4069  |
      |a-005-5678  |   M Lopian  |
      |a-006-6964  | topic4-103-1225    |
##select count(*) from SUBMISSION_DATA S1 where S1.SOURCE_PLCREF is not null and S1.SOURCE_URL is not null; - 0,
  ##there are no records in DB where we some value for SOURCE URL and SOURCE_PLCREF

    #@bug- Ask -128 select S1.FEATURED_QUERY from PUBLICATION_DATA S1 where S1.QUESTION_ID = (select Q1.ID from QUESTION Q1 where Q1.PLC_REF='a-013-5123');
  Scenario: Verify the FEATURED_QUERY in the PUBLICATION_DATA table for the given PLCrefs

    Given a user connects to the Ask Database
    When queries for the FEATURED_QUERY Then the FEATURED_QUERY should match the Value

