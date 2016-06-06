Feature: tabSwitching.feature

  Background:
    Given PL+ user is logged in

    Scenario: [885223] Verify that following a search practical law tab and westlaw uk tab are displayed and can be selected
      When the user runs a free text search for the query "contract"
      And the user can verify the presence of the Practical Law tab
      And the user can verify the presence of a Westlaw UK tab
      And the user can verify that the Practical Law tab is displayed by default
      When the user clicks on the Westlaw UK tab
      Then the Westlaw UK tab is displayed

    Scenario: [885223] Verify that following a search from the Global page the Westlaw UK tab is not rendered on search results
      When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
      Then the Category Page opens correctly
      When the user runs a free text search for the query "contract"
      Then the user can verify the presence of a Practical Law tab
      And the Westlaw UK tab is not displayed

    Scenario: [885223] Verify that following a search from the Whats Market page the Westlaw UK tab is not rendered on search results
      And the user selects the link entitled Whats Market UK Home
      When the user runs a free text search for the query "contract"
       Then the user can verify the presence of a Practical Law tab
       And the Westlaw UK tab is not displayed

    Scenario: [885223] Verify that following a search from the Ask page the Westlaw UK tab is not rendered on search results
       When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
       When the user runs a free text search for the query "contract"
       Then the user can verify the presence of a Practical Law tab
       And the Westlaw UK tab is not displayed

    Scenario: [885223] Verify that following a search from an individual country page the Westlaw UK tab is not rendered on search results
      Given the user clicks through the "International" links that are displayed on the Home Page
        | Argentina                               |
       When the user runs a free text search for the query "contract"
       Then the user can verify the presence of a Practical Law tab
       And the Westlaw UK tab is not displayed

