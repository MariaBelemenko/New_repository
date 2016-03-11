Feature: [752692] Include Practical Law Branding

  Scenario: [752692] As a PPI user I want to see Practical Law Branding on the Log in screen so I know that is part of the product that I am trying to access.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    Then user should see company logo on Login page
    And user should see three images near Login box
    And image "1" should lead to "http://www.legal-solutions.co.uk/"
    And image "2" should lead to "http://legalresearch.westlaw.co.uk/practicallawlinking/"
    And image "3" should lead to "http://www.serengetilaw.com/international/uk/Pages/default.aspx"

  @manual @wip
  Scenario Outline: [752689] As a PPI User I want to be able to have a dedicated page to login
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    Then the user will be redirected to a login page
    And clicks on document link "<link>"
    Then user should be presented with proper document "<documentTitle>"
  Examples:
    | link                       | documentTitle                                                              |
    | Privacy Policy and Cookies | Thomson Reuters (Professional) UK Ltd - Privacy and Data Protection Policy |
    | Legal Information          | Practical Law: Legal information                                           |
