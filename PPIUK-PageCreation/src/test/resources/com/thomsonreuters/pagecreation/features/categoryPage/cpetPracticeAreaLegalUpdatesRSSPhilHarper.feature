@wip
Feature: Check that each Legal Update RSS section on each Practice Area page has:
* Appropriate Heading
* The RSS icon link resolves as expected
* 5 pieces of Legal Update content
* Each RSS Legal Update has a corresponding Date that contains minimum no. of characters
* The View All link resolves as expected

  Background:
    Given PL+ user is logged in

  Scenario Outline: Verify the Legal Update RSS functionality for each Practice Area page
    Given navigates to the Practice Area "<practiceArea>"
    Then confirms the Legal Update Header is displayed
    Then confirms the RSS icon is displayed
    Then clicks the RSS icon
    And the user verifies the resulting 'Subscribe to Practical Law updates via RSS' page
    And the user clicks on the browser back button
    Then All RSS/ Legal Updates are displayed for "<practiceAreaLegalUpdateHeadingTitle>"
    And verifies Each Legal Update below the heading ".*" has a Date
    Then confirms the View All link at the foot of the RSS feed ".*" is displayed
    And clicks the View All link at the foot of the RSS feed ".*"
    And the resulting Practice Area page contains the associated Page Label "<practiceArea>"
    And the user clicks on the browser back button
    Examples:
      |practiceArea|practiceAreaLegalUpdateURL|practiceAreaLegalUpdatePageLabel|practiceAreaLegalUpdateHeadingTitle|
      |Agriculture & Rural Land|4-606-9406|'Legal Updates ~ Agriculture & Rural Land'|                             |
      |Arbitration|6-382-1328|'Legal Updates ~ Arbitration (All Jurisdictions)'||
      |Business Crime & Investigations|7-589-6165|'Legal Updates ~ Business Crime & Investigations'||
      |Commercial|1-379-8575|'Legal Updates ~ Commercial'|                                          |
      |Competition|7-103-2186|'Legal Updates ~ Competition EU'|EU Legal update|
      |Competition|5-103-1748|'Legal Updates ~ Competition UK'|UK Legal update|
      |Construction|4-383-5821|'Legal Updates ~ Construction'|                 |
      |Corporate|3-103-1749|'Legal Updates ~ Corporate'|                       |
      |Data Protection|1-614-3506|'Legal Updates ~ Data Protection'|           |
      |Dispute Resolution|1-203-9929|'Legal Updates ~ Dispute Resolution'|     |
      |Employment|0-200-2200|'Legal Updates ~ Employment'|                     |
      |Environment|5-203-9927|'Legal Updates ~ Environment'|      |
      |EU Law|4-501-5626|'Legal Updates ~ EU'|                    |
      |Family|5-522-0792|'Legal Updates ~ Family'|                |
      |Finance|3-201-3706|'Legal Updates ~ Finance'|              |
      |Financial Services|8-200-2201|'Legal Updates ~ Financial Services'||
      |IP & IT|5-103-1753|'Legal Updates ~ IP & IT'||
      |Local Government|9-614-3625|'Legal Updates ~ Local Government'||
      |Media & Telecoms|1-509-3753|'Legal Updates ~ Media & Telecoms'||
      |Pensions|9-204-8963|'Legal Updates ~ Pensions'|                |
      |Planning|4-606-9425|'Legal Updates ~ Planning'|                |
      |Private Client|2-383-9212|'Legal Updates ~ Private Client'|    |
      |Property|7-103-1771|'Legal Updates ~ Property'|                |
      |Property Litigation|8-606-9466|'Legal Updates ~ Property Litigation'||
      |Public Law|9-527-9785|'Legal Updates ~ Public Law'|                  |
      |Restructuring & Insolvency|1-381-9653|'Legal Updates ~ Restructuring & Insolvency'||
      |Share Schemes & Incentives|1-204-8962|'Legal Updates ~ Share Schemes & Incentives'||
      |Tax|5-378-8744|'Legal Updates ~ Tax'||