Feature: Ask Topic Links per Practice Area in ask Landing Page
  As a PL+ user
  I want to browse Ask topics within a Practice Area Ask Page
  So that I can view Ask queries for that particular topic

  Background:
    Given PL+ user is logged in with following details
      | userName | AskTestuser |

  Scenario: Click a Ask Topic page and verify Ask Queries page-date sorted by ascending order, date format
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    And the user clicks link 'Insurance' on 'the Ask:Construction' page
    And the user verifies that all ask queries on the Ask topic Page have date in format 'DD MMMM YYYY'
    And the user verifies that all ask queries on the topic Page  date sorted by descending order
    And the user verifies that all ask queries on the topic Page have at least 1 reply/replies'

  # DEMO only: 854196:[REGRESSION] Ask documents inaccessible
  # DEMO only: 858332:Practical Law: "We were unable to complete your request" error when downloading a report
  @bug
  Scenario: Download ask Query From Topic page
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    And the user clicks link 'Building contracts and contractors' on 'the Ask:Construction' page
    And the user selects ask question No 1 on the Ask Topic page
    When the user clicks 'download' widget on the Ask Category/Topic page
    Then the user verifies that 'Download' Window is displayed
    When the user clicks 'Download' on 'download' overlay
    Then the user verifies that 'Preparing For Download' is displayed on the overlay
    Then the user verifies that 'Ready For Download' is displayed on the overlay
    And the user clicks download on ready to download overlay
    Then user clicks Ok button in dialog box

  # DEMO only: 854196:[REGRESSION] Ask documents inaccessible
  # DEMO only: 858332:Practical Law: "We were unable to complete your request" error when downloading a report
  @bug
  Scenario: Email ask Query From Topic page
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    And the user clicks link 'Building contracts and contractors' on 'the Ask:Construction' page
    And the user selects ask question No 1 on the Ask Topic page
    When the user clicks 'email' widget on the Ask Category/Topic page
    Then the user verifies that 'Email' Window is displayed
    When the user clicks 'Email' on 'email' overlay
    Then the user verifies that 'Preparing For Email' is displayed on the overlay
    And the user verifies that 'Ready For Email' is displayed on the overlay

  # DEMO only: 854196:[REGRESSION] Ask documents inaccessible
  # DEMO only: 858332:Practical Law: "We were unable to complete your request" error when downloading a report
  @bug
  Scenario: Print ask Query From Topic page
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    And the user clicks link 'Building contracts and contractors' on 'the Ask:Construction' page
    And the user selects ask question No 1 on the Ask Topic page
    When the user clicks 'print' widget on the Ask Category/Topic page
    Then the user verifies that 'Print' Window is displayed
    When the user clicks 'Print' on 'print' overlay
    Then the user verifies that 'Preparing For Print' is displayed on the overlay
    And user clicks ok button in dialog box

  Scenario: Search ask queries  From Topic page
    Given the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    And the user clicks link 'Building contracts and contractors' on 'the Ask:Construction' page
    When the user runs a free text search for the query "GMP"
    #    Then the user verifies that only ask query 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' is displayed
    And the user clicks link 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' on 'the ask search results' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?"
    And resource type is displayed as "Ask" on right hand panel

  # DEMO only: 854196:[REGRESSION] Ask documents inaccessible
  @bug
  Scenario: Search ask queries From Practice Area page
    Given the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    When the user runs a free text search for the query "GMP"
    #    Then the user verifies that only ask query 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' is displayed
    And the user clicks link 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' on 'the ask search results' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?"
    And resource type is displayed as "Ask" on right hand panel

  Scenario: Search ask queries  From Ask Landing page (Bug# 795822)
    Given the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    When the user runs a free text search for the query "GMP"
    #    Then the user verifies that only ask query 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' is displayed
    And the user clicks link 'Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?' on 'the ask search results' page
    Then ask disclaimer is displayed on the document
    And document title is displayed as "Do you have standard wording for creating a guaranteed maximum price (GMP) in a building contract?"
    And resource type is displayed as "Ask" on right hand panel
