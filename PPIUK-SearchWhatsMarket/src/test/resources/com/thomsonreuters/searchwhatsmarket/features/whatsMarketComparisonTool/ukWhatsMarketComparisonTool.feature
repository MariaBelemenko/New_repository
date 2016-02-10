Feature: ukWhatsMarketComparisonTool.feature
  [815685][815692][815714][815248][815245][815246][815247][815705][811160][811159]

  Background: Log on to test site
    Given PL+ user is logged in with following details
      | userName | Search2_AutoUser |
    And the user selects the link entitled Whats Market UK Home

  Scenario: Generate whats market comparison report
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Deal"
    And the user selects the profile option to display "Industry sector"
    And the user selects the profile option to display "Company number"
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Company number"
    And the user verifies the presence of a column entitled "Industry sector"

  Scenario: Generate whats market comparison report from WM topic page
    And has selected the link to the deal type "Administrations"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Deal"
    And the user selects the profile option to display "Company number"
    And the user selects the profile option to display "Industry sector"
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Company number"
    And the user verifies the presence of a column entitled "Industry sector"

  Scenario: Verify user unable to compare two differing deal types
    When the user runs a free text search for the query "law"
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the checkbox associated with whats market result "4"
    And the user selects the compare button
    And the user verifies the presence of the error message You can only compare deals of the same type
    And the user selects OK

  Scenario: Create a new profile for whats market comparison report
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the option to Select All
    And the user selects the save option
    # Bug 850563 can prevent the title showing.
    And the user verifies the presence of a pop up entitled 'Save Report Profile'
    And the user enters text into the profile name field "test"
    And the user selects the save option on the pop up
    And the user selects the report profile dropdown
    And the user verifies that the report profile dropdown does include the profile entitled "test"
    And the user selects the report profile entitled "test"
    And the user selects the delete option
    And the user verifies the presence of a pop up entitled Delete Report Profile
    And the user selects the report profile entitled "test" on Delete Report Profile popup
    And the user selects the delete button on Delete Report Profile popup
    And the user verifies that the report profile dropdown does not include the profile entitled "test"

  Scenario: [815685] Show and hide the profile and report options for whats market comparison report
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user ensures that the left hand column select is displayed
    And the user verifies the Comparison Terms selector is displayed
    And the user selects the menu icon
    And the user verifies the Comparison Terms selector is not displayed
    And the user selects the menu icon
    And the user verifies the Comparison Terms selector is displayed

  Scenario: [815692] Verify user can add a comparison term to the comparison report
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Company number"
    And the user verifies the presence of a column entitled "Company number"
    And the user selects the profile option to display "Company number"
    And the user verifies the absence of a column entitled "Company number"

  Scenario: [815248] verify column sorting functionality
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user clicks on the column entitled "Deal"
    Then the user verifies the deals are sorted alphabetically by "Deal"
    When the user clicks on the column entitled "Date administrators appointed"
    Then the user verifies the deals are sorted by 'Date administrators appointed'

  Scenario: [815245] verify user can change the order of the items in the report using the controls in the the organise columns tool
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Industry sector"
    And the user clicks the 'Organize Columns' button on deal comparison report
    And the user clicks on column "Administrators: firm name" on Organize Columns popup
    And the user clicks the "Move To Top" button on Organize Columns popup
    And the user verifies column "Administrators: firm name" is in position "1" on Organize Columns popup
    And the user clicks the "Move Down" button on Organize Columns popup
    And the user verifies column "Administrators: firm name" is in position "2" on Organize Columns popup
    And the user clicks the "Move Up" button on Organize Columns popup
    And the user verifies column "Administrators: firm name" is in position "1" on Organize Columns popup
    And the user clicks the "Move To Bottom" button on Organize Columns popup
    And the user verifies column "Administrators: firm name" is in position "3" on Organize Columns popup

  Scenario: [815245] verify user can save changes made to the order of the items in the report using the organise columns tool
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Industry sector"
    And the user clicks the 'Organize Columns' button on deal comparison report
    And the user clicks on column "Administrators: firm name" on Organize Columns popup
    And the user clicks the "Move To Top" button on Organize Columns popup
    And the user clicks the 'Save' button on Organize Columns popup
    And the user verifies the Organize Columns popup is closed
    Then the user verifies heading "Administrators: firm name" is in column "2" on the Deal Comparison Report

  Scenario: [815245] verify user can cancel changes made to the order of the items in the report using the organise columns tool
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Industry sector"
    And the user clicks the 'Organize Columns' button on deal comparison report
    And the user clicks on column "Administrators: firm name" on Organize Columns popup
    And the user clicks the "Move To Top" button on Organize Columns popup
    And the user clicks the 'Cancel' button on Organize Columns popup
    And the user verifies the Organize Columns popup is closed
    Then the user verifies heading "Administrators: firm name" is in column "4" on the Deal Comparison Report

  Scenario: [815245] verify user can close the organise columns tool having made some changes to the order and those changes are not saved
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Industry sector"
    And the user clicks the 'Organize Columns' button on deal comparison report
    And the user clicks on column "Administrators: firm name" on Organize Columns popup
    And the user clicks the "Move To Top" button on Organize Columns popup
    And the user clicks the 'Close' button on Organize Columns popup
    And the user verifies the Organize Columns popup is closed
    Then the user verifies heading "Administrators: firm name" is in column "4" on the Deal Comparison Report

  Scenario: [815246] verify user can move from left to right and back using arrows in the report so as to view all the columns
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the option to Select All
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Company name"
    And the user verifies the absence of a column entitled "Administrators: firm name"
    And the user clicks the next arrow on deal comparison report
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Administrators: firm name"
    And the user verifies the absence of a column entitled "Company name"
    And the user clicks the previous arrow on deal comparison report
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Company name"
    And the user verifies the absence of a column entitled "Administrators: firm name"

  Scenario: [815705] verify that user is able to select columns and add them to report using the select all checkbox
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the option to Select All
    And the user verifies the presence of a column entitled "Deal"
    And the user verifies the presence of a column entitled "Company name"
    And the user verifies the presence of a column entitled "Company number"
    And the user verifies the presence of a column entitled "Industry sector"
    And the user verifies the presence of a column entitled "Nature of business"
    And the user verifies the presence of a column entitled "Date administrators appointed"
    And the user verifies all Comparison Terms checkboxes are checked for Administration deal type

  Scenario: [815705] verify that user is able to deselect columns and remove them from report using the select all checkbox
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the option to Select All
    And the user verifies all Comparison Terms checkboxes are checked for Administration deal type
    And the user verifies the presence of a column entitled "Company number"
    And the user selects the option to Select All
    And the user verifies all Comparison Terms checkboxes are unchecked
    And the user verifies the absence of a column entitled "Company number"

  Scenario: [815705] verify that user is able to deselect columns and remove them from report using clear selected link
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the option to Select All
    And the user verifies all Comparison Terms checkboxes are checked for Administration deal type
    And the user verifies the presence of a column entitled "Company number"
    And the user clicks the 'clear selected' button
    And the user verifies all Comparison Terms checkboxes are unchecked
    And the user verifies the absence of a column entitled "Company number"


  Scenario: [811160] verify comparison options for sample deal types
    And has selected the link to the deal type "Public M & A"
    And the user pauses for "3" seconds
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user verifies the presence of the following comparison options
      | Deal                                                                                              |
      | Bidder                                                                                            |
      | Bidder's country of incorporation                                                                 |
      | Nature of bidder                                                                                  |
      | Target                                                                                            |
      | Market on which target's shares traded                                                            |
      | Deal summary                                                                                      |
      | Firm or possible offer                                                                            |
      | Who made the announcement                                                                         |
      | Structure of deal                                                                                 |
      | Type of scheme                                                                                    |
      | US tender offer                                                                                   |
      | Industry sector                                                                                   |
      | Public to private                                                                                 |
      | Bid vehicle                                                                                       |
      | Announcement date                                                                                 |
      | Strategic review announcement that commences an offer period                                      |
      | Possible offer announcement identifying one or more potential bidder(s)                           |
      | Target announcement setting out extended put up or shut up deadline                               |
      | Completion date                                                                                   |
      | Recommended or hostile                                                                            |
      | Deal value                                                                                        |
      | Consideration amount                                                                              |
      | Consideration type                                                                                |
      | Mix and match facility                                                                            |
      | Prospectus or equivalent document                                                                 |
      | Offer extended to ADRs                                                                            |
      | Loan note alternative                                                                             |
      | Full or partial loan note alternative                                                             |
      | Loan note guarantee                                                                               |
      | Is loan note a non-QCB for individual shareholders                                                |
      | Minimum take-up of loan notes                                                                     |
      | Duration of loan notes                                                                            |
      | Interest rate on loan notes                                                                       |
      | Transfer restrictions on loan notes                                                               |
      | Right reserved to switch structure                                                                |
      | Did bidder switch structure                                                                       |
      | Any disruptions to scheme timetable                                                               |
      | Permitted/excluded offer-related arrangements under Rule 21.2 of the Takeover Code                |
      | Break fee                                                                                         |
      | Break fee: competing bidder(s)                                                                    |
      | Break fee: formal sale process                                                                    |
      | Break fee: shareholder                                                                            |
      | Mutual break fee                                                                                  |
      | Reverse break fee                                                                                 |
      | Restriction on target's right to agree a break fee with another party                             |
      | Percentage of share capital represented by irrevocable undertakings                               |
      | Percentage represented by irrevocable undertakings from directors                                 |
      | Hard or soft directors' irrevocable undertakings                                                  |
      | Details of hard or soft directors' irrevocable undertakings                                       |
      | Matching or topping right in directors' irrevocable undertakings                                  |
      | Details of matching or topping right in directors' irrevocable undertakings                       |
      | Non-solicitation undertaking in directors' irrevocable undertakings                               |
      | Details of non-solicitation undertaking in directors' irrevocable undertakings                    |
      | Notification undertaking in directors' irrevocable undertakings                                   |
      | Details of notification undertaking in directors' irrevocable undertakings                        |
      | Recommendation in directors' irrevocable undertakings                                             |
      | Details of recommendation in directors' irrevocable undertakings                                  |
      | Percentage represented by irrevocable undertakings from non-director shareholders                 |
      | Hard or soft non-director shareholders' irrevocable undertakings                                  |
      | Details of hard or soft non-director shareholders' irrevocable undertakings                       |
      | Matching or topping right in non-director shareholders' irrevocable undertakings                  |
      | Details of matching or topping right in non-director shareholders' irrevocable undertakings       |
      | Non-solicitation undertaking in non-director shareholders' irrevocable undertakings               |
      | Details of non-solicitation undertaking in non-director shareholders' irrevocable undertakings    |
      | Notification undertaking in non-director shareholders' irrevocable undertakings                   |
      | Details of notification undertaking in non-director shareholders' irrevocable undertakings        |
      | Non-binding letter of intent                                                                      |
      | Market purchase of shares/pre-announcement shareholding                                           |
      | Target non-solicitation undertakings                                                              |
      | Matching or bettering right                                                                       |
      | Pre-conditions                                                                                    |
      | Any conditions highlighted in the offer announcement                                              |
      | Offeree protection conditions                                                                     |
      | Profit forecast: reports                                                                          |
      | Profit forecast: directors' confirmations                                                         |
      | Asset valuation                                                                                   |
      | Potential or actual competing bidder                                                              |
      | Potential or actual competing bidder: details                                                     |
      | Potential offers: when was the firm offer announced                                               |
      | Did bidder increase its offer                                                                     |
      | Formal sale process                                                                               |
      | Details of formal sale process                                                                    |
      | Details given of plans for workforce/location of target's business                                |
      | Details given of plans regarding contributions to target's pension schemes                        |
      | Negotiations with pension scheme trustees/future funding agreements                               |
      | Target employee opinion in offer document in accordance with Rule 30.2(b) of the Takeover Code    |
      | Target employee representatives' opinion                                                          |
      | Details of target employee representatives' opinion in offer document/target board circular       |
      | Announcement by target that employee representatives' opinion has been published on a website     |
      | Target pension scheme trustees' opinion                                                           |
      | Details of target pension scheme trustees' opinion in offer document/target board circular        |
      | Announcement by target that pension scheme trustees' opinion has been published on a website      |
      | Was the target's board opinion given by the whole board                                           |
      | Bidder shareholder approval required (e.g. in accordance with the Listing Rules or the AIM Rules) |
      | Special deals/management incentivisation arrangements requiring shareholder approval              |
      | Details of special deals/management incentivisation arrangements requiring shareholder approval   |
      | Debt financing                                                                                    |
      | Bid financing arrangements                                                                        |
      | Details of bid financing arrangements                                                             |
      | Equity issue to finance deal                                                                      |
      | On sale arrangements                                                                              |
      | Quantified financial benefits statement                                                           |
      | Merger benefits/synergies statements                                                              |
      | Other points to note                                                                              |
      | Financial adviser to bidder                                                                       |
      | Legal adviser to bidder                                                                           |
      | Financial adviser to target                                                                       |
      | Legal adviser to target                                                                           |
      | Bidder's fees for financial advice                                                                |
      | Target's fees for financial advice                                                                |
      | Bidder's fees for legal advice                                                                    |
      | Target's fees for legal advice                                                                    |
      | Bidder's fees for financing arrangements                                                          |
      | Target's costs for employee representatives' opinion                                              |
      | Bidder's fees: other                                                                              |
      | Target's fees: other                                                                              |
      | Fees as a percentage of deal value                                                                |
      | Ratings accorded by rating agencies and any changes made to those ratings                         |
      | Public documents                                                                                  |

  Scenario: [811159] verify user on comparison report page can return to previous search results
    When the user runs a free text search for the query "law"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user verifies the presence of the whats market facet "Administrations"
    And the user selects the whats market facet "Administrations"
    And the user selects the option to apply filters
    And the user selects the checkbox associated with whats market result "1"
    And the user selects the checkbox associated with whats market result "2"
    And the user selects the checkbox associated with whats market result "3"
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    #And the user ensures that the comparison terms header is visible
    And the user verifies the presence of a 'Back To Search Results' button
    And the user clicks the 'Back To Search Results' button
    And the user verifies that the whats market facet "Administrations" is selected
    And the user verifies the checkbox associated with whats market result "1" is checked
    And the user verifies the checkbox associated with whats market result "2" is checked
    And the user verifies the checkbox associated with whats market result "3" is checked

  @e2e
  Scenario: filter practice area results and then use the "select all" option on practice area results before generating comparison report
    And has selected the link to the deal type "Public M & A"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the whats market facet "Aerospace and defence"
    And the user selects the whats market facet "Alternative energy"
    And the user selects the option to apply filters
    And the user selects the select all option on the results page
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user selects the profile option to display "Bidder"
    And the user selects the profile option to display "Nature of bidder"
    And the user selects the profile option to display "Target"
    And the user selects the profile option to display "Industry sector"
    And the user verifies the presence of a column entitled "Bidder"
    And the user verifies the presence of a column entitled "Nature of bidder"
    And the user verifies the presence of a column entitled "Target"
    And the user verifies the presence of a column entitled "Industry sector"
    And the user selects the save option
    And the user verifies the presence of a pop up entitled 'Save Report Profile'
    And the user enters text into the profile name field "test"
    And the user selects the save option on the pop up
    And the user selects the report profile dropdown
    And the user verifies that the report profile dropdown does include the profile entitled "test"
    And the user selects the home node icon
    And the user selects the link entitled Whats Market UK Home
    And has selected the link to the deal type "Public M & A"
    And the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is
    And the user selects the whats market facet "Aerospace and defence"
    And the user selects the whats market facet "Alternative energy"
    And the user selects the option to apply filters
    And the user selects the select all option on the results page
    And the user selects the compare button
    And the user verifies the presence of the heading Deal Comparison Report
    And the user ensures that the left hand column select is displayed
    And the user verifies that the report profile dropdown does include the profile entitled "test"
    And the user selects the report profile entitled "test"
    And the user verifies the presence of the heading Deal Comparison Report
    And the user verifies that the comparison option "Bidder" is still selected
    And the user verifies that the comparison option "Nature of bidder" is still selected
    And the user verifies that the comparison option "Target" is still selected
    And the user verifies that the comparison option "Industry sector" is still selected
    And the user selects the delete option
    And the user verifies the presence of a pop up entitled Delete Report Profile
    And the user selects the report profile entitled "test" on Delete Report Profile popup
    And the user selects the delete button on Delete Report Profile popup
    And the user verifies that the report profile dropdown does not include the profile entitled "test"
