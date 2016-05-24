Feature: [888959] Search Results - Less More or Most

Background: Log on
  Given a user has logged onto the Practical Law site
  And has navigated to the WLUK compartment

      Scenario: Verify setting for less detail - Cases
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Cases content type facet
          Then the user can verify the presence of a case name for result "1"
          And the user can verify the presence of the court details for result "1"
          And the user can verify the presence of the judgment date for result "1"
          And the user can verify the presence of a where reported section for result "1"
          And the user can verify the presence of document links for result "1"
          And the user can verify the presence of a status icon for result "1"

      Scenario: Verify setting for more detail - Cases
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Cases content type facet
          And has selected the option to show "More" detail
          Then the user can verify that the "More" detail option is selected
          Then the user can verify the presence of a case name for result "1"
          And the user can verify the presence of subject data for result "1"
          And the user can verify the presence of keyword data for result "1"
          And the user can verify the presence of the court details for result "1"
          And the user can verify the presence of the judgment date for result "1"
          And the user can verify the presence of a where reported section for result "1"
          And the user can verify the presence of document links for result "1"
          And the user can verify the presence of a status icon for result "1"
          And the user can verify the presence of summary information for result "1"

      Scenario: Verify setting for most detail - Cases
            Given a logged in user has run a search within the WLUK compartment
            And has selected the Cases content type facet
            And has selected the option to show "Most" detail
            Then the user can verify that the "Most" detail option is selected
            Then the user can verify the presence of a case name for result "1"
            And the user can verify the presence of subject data for result "1"
            And the user can verify the presence of keyword data for result "1"
            And the user can verify the presence of the court details for result "1"
            And the user can verify the presence of the judgment date for result "1"
            And the user can verify the presence of a where reported section for result "1"
            And the user can verify the presence of document links for result "1"
            And the user can verify the presence of a status icon for result "1"
            And the user can verify the presence of summary information for result "1"
            And the user can verify the presence of terms in context data for result "1"

      Scenario: Verify setting for less detail - Legislation
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Legislation content type facet
          And has selected the option to show "Less" detail
          Then the user can verify that the "Less" detail option is selected
          And the user can verify the presence of the Act/SI title for result "1"
          And the user can verify the presence of the provision detail for result "1"
          And the user can verify the presence of document links and list for result "1"
          And the user can verify the presence of a status icon for result "1"


      Scenario: Verify setting for more detail - Legislation
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Legislation content type facet
          And has selected the option to show "More" detail
          Then the user can verify that the "More" detail option is selected
          And the user can verify the presence of the Act/SI title for result "1"
          And the user can verify the presence of the provision detail for result "1"
          And the user can verify the presence of document links and list for result "1"
          And the user can verify the presence of a status icon for result "1"
          And the user can verify the presence of the version and date for result "1"

      Scenario: Verify setting for most detail - Legislation
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Legislation content type facet
          And has selected the option to show "Most" detail
          Then the user can verify that the "Most" detail option is selected
          And the user can verify the presence of the Act/SI title for result "1"
          And the user can verify the presence of the provision detail for result "1"
          And the user can verify the presence of document links and list for result "1"
          And the user can verify the presence of a status icon for result "1"
          And the user can verify the presence of the version and date for result "1"
          And the user can verify the presence of terms in context for result "1"

    Scenario: Verify setting for less detail - Journals
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Journals content type facet
          And has selected the option to show "Less" detail
          Then the user can verify that the "Less" detail option is selected
          Then the user can verify for result "1" the presence of the journal abstract title
          And the user can verify the presence of TBC

      Scenario: Verify setting for more detail - Journals
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Journals content type facet
          And has selected the option to show "More" detail
          Then the user can verify that the "More" detail option is selected
          Then the user can verify the presence of the journal title for result "1"
          And the user can verify the presence of the journal citation for result "1"
          And the user can verify the presence of a document link list for result "1"
          And the user can verify the presenc of the article abstract for result "1" [?]

      Scenario: Verify setting for most detail - Journals
          Given a logged in user has run a search within the WLUK compartment
          And has selected the Journals content type facet
          And has selected the option to show "Most" detail
          Then the user can verify that the "Most" detail option is selected
          Then the user can verify the presence of the journal title for result "1"
          And the user can verify the presence of the journal citation for result "1"
          And the user can verify the presence of a document link list for result "1"
          And the user can verify the presence of the article abstract for result "1" [?]
          And the user can verify the presence of terms in context for result "1"


      Scenario: Verify default setting reflects previous user session setting (is this correct ?)
          Given a logged in user has run a search within the WLUK compartment
          And has selected the option to show "More" detail
          Then the user can verify that the "More" detail option is selected
          And the user logs out
          When the user logs in by way of a new session
          And has run a search within the WLUK compartment
          Then the user can verify that the "More" detail option is displayed


     #Additional tests required for Insight, EU and LRDI