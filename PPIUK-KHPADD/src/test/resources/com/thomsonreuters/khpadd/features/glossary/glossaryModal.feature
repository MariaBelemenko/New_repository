@wip
Feature: [711155] As a Know How user,
  I want to scroll and select terms within the glossary modal,
  so that I can view the glossary term in the Glossary document.

  Scenario: Closing Modal box and navigation between the glossary modal and glossary terms
    Given PL+ user is logged in
    And user navigates to a Practice Note resource
    And user clicks on glossary term "advance corporation tax" in the resource page
    When the glossary modal pop up box opens with the title "advance corporation tax"
    And the user selects the "X" icon at the top right of the modal window
    Then the modal closes and returns the user to the document view
    And user clicks on glossary term "advance corporation tax" in the resource page
    When user clicks on glossary term "HM Revenue & Customs" inside this modal box
    And letter "H" should be selected on the alphabet tab
    Then the title "HM Revenue & Customs (HMRC)" is displayed in the definition

  @manual
  Scenario: Verification of scrolling within Glossary Modal Box
    Given PL+ user is logged in
    When the user selects the scroll bar to the right of the Glossary Modal Box
    Then the user is able to scroll up and down the box