Feature: [711146, 711149, 711150] As a Know How user,
  I want to view glossary tabbed alphabetical list,
  so that I can select glossary terms

  Background:
    Given PL+ user is logged in
    And user navigates to a glossary page

  Scenario: Verify Tabbed Alphabets functionality
    And the user is able to see the tabbed alphabetical list
    When the user clicks on the alphabet "F" in the tabbed alphabetical list
    Then the glossary list rolls up and the first term in the respective list is selected (except x, Y and Z)
    And the corresponding definition of the selected term should be displayed on the right hand side
    And the user should be able to view the scroll up and scroll down button on the list
    And clicking on the scroll up button the user should be able to roll up the list of terms
    And clicking on the scroll down button the user should be able to traverse down the list of terms
    And the user selects another letter "H"
    Then letter "H" should be selected on the alphabet tab
    And the corresponding terms for "H" are displayed

  Scenario: Verify rolling up of the list to adjust the selected glossary term position
    When the user selects a term e.g. "A v A application" on the tabbed alphabetical list
    Then letter "A" should be selected on the alphabet tab
    And the term should adjust itself to roll up the list as the first item
    And the corresponding definition of the selected term should be displayed on the right hand side

  @manual
  Scenario: Verify the glossary page does not display chinese glossary terms in the list
    When user navigates to a glossary page
    And searches for a term in chinese language
    Then the user should not be able to find any chinese glossary terms listed in this list

  Scenario: Navigation to glossary terms on glossary definition page
    When the user clicks on glossary term "Headlease"
    Then the user should be able to view the definition of the term "Headlease" on the page
    #the line below has not been implemented so unable to identify element - bug 724783
    #And the left pane should roll up displaying the selected term as the first term
    #And letter "H" should be selected on the alphabet tab

  Scenario: Verification of the navigation from glossary definition page to actual know how resource
    When the user clicks on glossary term "A v A application"
    And clicks on the know how resource link "Legal Aid, Sentencing and Punishment of Offenders Act 2012" in the definition page
    Then the user is navigated to the actual know how resource page

  Scenario: Verification of the glossary modal box from the resource page
    Given user navigates to a Practice Note resource
    When user clicks on glossary term "withholding tax" in the resource page
    Then the glossary modal pop up box opens with the title "withholding tax"
    And the definition of the selected term should be displayed
