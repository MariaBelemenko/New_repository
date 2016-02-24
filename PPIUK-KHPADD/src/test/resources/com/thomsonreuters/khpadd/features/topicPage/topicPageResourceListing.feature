Feature: [730196][764868][764877] Verify the topic page facet links, topic page facet count and the resource linking to a particular resource type

  Background:
    Given PL+ user is logged in
    And the user clicks on close button on the cookie consent message

  @e2e @prod
  Scenario:[730553][769006] Verify if 100 resources are displayed on the topic page per page
    When the user navigates to practice area "Finance" filtered by "Security and quasi security" topic page
    Then the user is presented with a topic page with title "Security and Quasi Security"
    And the number of resources displayed on the first page is 100
    When the user clicks on the resource link "Administrative receivership" under Practice Notes resource type
    Then document title is displayed as "Administrative receivership"
    And resource type is displayed as "Practice notes" on right hand panel

  Scenario:[764877 Verifying facet group counts on the topic page [bug#776171]
    When the user navigates to practice area "Finance" filtered by "Security and quasi security" topic page
    Then the user is presented with a topic page with title "Security and Quasi Security"
    And the facet ordering along with corresponding resource count is as follows
      | facetName                      | facetCount |
      | View all                       | 388        |
      | Practice Notes                 | 104        |
      | Standard Documents and Clauses | 56         |
      | Checklists                     | 12         |
      | Trackers                       | 1          |
      | Articles                       | 106        |
      | Country Q&A                    | 39         |
      | Glossary                       | 70         |

  Scenario:[764868] Verifying facet ordering [bug#776750]
    When the user navigates to practice area "Corporate" filtered by "Directors" topic page
    Then the user is presented with a topic page with title "Directors"
    And the facet ordering along with corresponding resource count is as follows
      | facetName                      | facetCount |
      | View all                       | 302        |
      | Practice Notes                 | 45         |
      | Standard Documents and Clauses | 46         |
      | Checklists                     | 6          |
      | Toolkits                       | 1          |
      | Trackers                       | 1          |
      | Articles                       | 166        |
      | Country Q&A                    | 34         |
      | Glossary                       | 4          |

  @e2e @prod
  Scenario: [770720][730571] Verify display of Optional blocks where widgets have not / have been created
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    And following optional blocks are not displayed on the right hand side
      | International Resources |
      | Key forms and guidance  |
    When PL+ user navigates to home page
    When the user navigates to practice area "Commercial" filtered by "Advertising and marketing" topic page
    And following optional blocks are displayed on the right hand side
      | Legal Updates           |
      | International Resources |
      | Key forms and guidance  |

  @e2e @prod
  Scenario: [751239] Verify adding Topic Pages to favourites folder
    When the user navigates to practice area "Corporate" filtered by "Asset acquisitions" topic page
    Then the user is presented with a topic page with title "Asset Acquisitions"
    And the user adds page to favourites group 'Favourite Topics'
    When the user clicks on 'Favourites' link on the header
    And the user checks that 'Topic: Asset Acquisitions (Corporate)' link presents in favourites group 'Favourite Topics' on Favourites page
    When the user clicks 'Topic: Asset Acquisitions (Corporate)' link on Favourites page
    Then the user is presented with a topic page with title "Asset Acquisitions"
    When the user clicks on 'Favourites' link on the header
    And the user deletes the favourites group 'Favourite Topics'
    Then the favourites group 'Favourite Topics' is absent on Favourites page

  @e2e @prod
  Scenario: [764883] verify the documents within a particular resource type are alphabetically sorted
    When the user navigates to practice area "Property" filtered by "Development" topic page
    And clicks on the facet group "Practice Notes"
    Then the documents listed under resource group "Practice note: overview" should be alphabetically ordered as below
      | Assignment and novation of construction documents                                    |
      | Building leases and restrictions on alienation                                       |
      | Building Regulations: an overview                                                    |
      | Collateral warranties and third party rights on construction projects: a quick guide |
      | Do I have a "construction contract"?                                                 |
      | JCT forms of building contract: toolkit                                              |
      | PWA 1996: a quick guide to its notice requirements and dispute resolution procedure  |
      | PWA 1996: a quick guide to what it is and what works it covers                       |
      | PWA 1996: a toolkit to the Party Wall etc. Act 1996                                  |
