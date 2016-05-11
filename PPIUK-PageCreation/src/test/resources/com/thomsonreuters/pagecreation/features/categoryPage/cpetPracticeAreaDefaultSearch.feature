@wip
Feature: Check that the Search default matches the Practice Area when accessed from the Practice Areas tab

  Background:
    Given PL+ user is logged in

  @PhilTestDefaultSearch1
  Scenario Outline: Verify the search default matches the Practice Area in question
    Given navigates to the Practice Area "<practiceArea>"
    Then the user verifies the search default matches the practice area "<practiceAreaSearchDefault>"
    And the user clicks on the browser back button
  Examples:
  |practiceArea|practiceAreaSearchDefault|
  |Agriculture & Rural Land| Agriculture & Rural Land|
  |Arbitration|Arbitration (All Jurisdictions)       |
  |Business Crime & Investigations|Business Crime & Investigations|
  |Commercial|Commercial|
  |Competition|Competition|
  |Construction|Construction|
  |Corporate|Corporate|
  |Data Protection|Data Protection|
  |Dispute Resolution|Dispute Resolution|
  |Employment|Employment|
  |Environment|Environment|
  |EU Law|EU              |
  |Family|Family|
  |Finance|Finance|
  |Financial Services|Financial Services|
  |IP & IT|IP & IT|
  |Local Government|Local Government|
  |Media & Telecoms|Media & Telecoms|
  |Pensions|Pensions|
  |Planning|Planning|
  |Private Client|Private Client|
  |Property|Property|
  |Property Litigation|Property Litigation|
  |Public Law|Public Law|
  |Restructuring & Insolvency|Restructuring & Insolvency|
  |Share Schemes & Incentives|Share Schemes & Incentives|
  |Tax|Tax|

  @PhilTestDefaultSearch2
  Scenario Outline: Verify the search default matches the Practice Area in question
    Given  the user clicks button 'Browse Menu' on the Home Page
      And the user accesses each Practice Area via Browse Menu > "<practiceArea>"
    Then the user verifies the search default matches the practice area "<practiceAreaSearchDefault>"
      And the user clicks on the browser back button
    Examples:
      |practiceArea|practiceAreaSearchDefault|
      |Agriculture & Rural Land| Agriculture & Rural Land|
      |Arbitration|Arbitration (All Jurisdictions)       |
      |Business Crime & Investigations|Business Crime & Investigations|
      |Commercial|Commercial|
      |Competition|Competition|
      |Construction|Construction|
      |Corporate|Corporate|
      |Data Protection|Data Protection|
      |Dispute Resolution|Dispute Resolution|
      |Employment|Employment|
      |Environment|Environment|
      |EU Law|EU              |
      |Family|Family|
      |Finance|Finance|
      |Financial Services|Financial Services|
      |IP & IT|IP & IT|
      |Local Government|Local Government|
      |Media & Telecoms|Media & Telecoms|
      |Pensions|Pensions|
      |Planning|Planning|
      |Private Client|Private Client|
      |Property|Property|
      |Property Litigation|Property Litigation|
      |Public Law|Public Law|
      |Restructuring & Insolvency|Restructuring & Insolvency|
      |Share Schemes & Incentives|Share Schemes & Incentives|
      |Tax|Tax|


