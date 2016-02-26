Feature:[702214] ukWhatsMarketListOfFacets.feature
Ability to filter UK What's Market search results by the facets available and particular to the What's Market service.

  Scenario: verify presence of all whats market facets
    Given PL+ user is logged in
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "law"
    And the user pauses for "2" seconds
    Then the user verifies the presence of the whats market facet groups
      | Administrators: firm category                    |
      | Administrators: firm name                        |
      | Administrators: location                         |
      | Administrators: region                           |
      | Arrangements to facilitate exit                  |
      | Articles of association available                |
      | Cash box structure                               |
      | Cash option on conversion                        |
      | Company's country of incorporation               |
      | Compliance with statutory pre-emption provisions |
      | Consideration type                               |
      | Customer offer                                   |
      | Deadlock provisions                              |
      | Debt financing                                   |
      | Employee offer                                   |
      | Firm or possible offer                           |
      | FTSE Index                                       |
      | Fundraising                                      |
      | Guarantee                                        |
      | High Growth Segment                              |
      | Industry Sector                                  |
      | Issuer early redemption option                   |
      | Issuer's country of incorporation                |
      | Listing segment                                  |
      | Market on which shares traded                    |
      | Market on which target shares traded             |
      | Nature of restructuring                          |
      | Offer made to                                    |
      | Potential or actual competing bidder             |
      | Public to private                                |
      | Recommended or hostile                           |
      | Related appointments                             |
      | Related party transaction                        |
      | Retail offer                                     |
      | Rule 144A offering                               |
      | Securities offered                               |
      | Shareholder reserved matters                     |
      | Standby underwriting arrangements                |
      | Structure of deal                                |
      | Structure of demerger                            |
      | Structure of issue                               |
      | Termination Provisions                           |
      | Transfer provisions                              |
      | Type of transaction                              |
      | Type of return                                   |
      | Type of reorganisation                           |
      | Type of securities                               |
      | Underwritten                                     |
      | Unusual deal protection                          |
      | US tender offer                                  |
