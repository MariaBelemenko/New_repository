@wip @e2e @robot
Feature: Form Submission into Ask Mediator
  As a PL+ subscriber or Non-Subscriber
  I want to submit my question to the Ask Mediator
  So that editors are able to view and answer my question on the Ask system

  #This automation script done but can not be run on jenkins as the test needs Windows user id and password to access sharepoint site
  #It can be run from local machine by setting Windows user nanme and password with winusername and winpassword property
  #mvn clean test -PDEMO -Dcucumber.options="src\test\resources\com\thomsonreuters\tests\features\ask\askSharePoint.feature" -Dwinusername="TEN\UCxxxxxxx" -Dwinpassword="xxxxx"
  Background:
    Given PL+ user is logged in with following details
      | userName | AskTestuser |

  # 833203 [REGRESSION] PLC Document ID field is empty on Share Point
  @bug @CloseAskWindow
  Scenario Outline: Successful ASK form submission by PL+ user into ASK mediator from a document
    When user navigates directly to document with guid "<documentID>"
    And the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | <firstName>                          |
      | Last Name         | <lastName>                           |
      | Organisation Type | <organisationType>                   |
      | Position          | <position>                           |
      | Jurisdiction      | <jurisdiction>                       |
      | Answering Service | <answeringService>                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then the question is correctly displayed on the ASK SharePoint site
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
      | PLC Document ID   | <document>         |
  Examples:
    | firstName | lastName | organisationType | position      | jurisdiction | answeringService | documentID                        | document                                                                                   |
    | Iryna     | Smoli    | Public Sector    | Legal Advisor | UK           | Arbitration      | If8523e9b93f811e598dc8b09b4f043e0 | Is there any legal obligation to refer assets to the Crown that have become bona vacantia? |

  @bug @CloseAskWindow
  Scenario Outline: Successful ASK form submission by PL+ user into ASK mediator for Public Sector
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | <firstName>                          |
      | Last Name         | <lastName>                           |
      | Organisation Type | <organisationType>                   |
      | Position          | <position>                           |
      | Jurisdiction      | <jurisdiction>                       |
      | Answering Service | <answeringService>                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then the question is correctly displayed on the ASK SharePoint site
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
  Examples:
    | firstName | lastName | organisationType | position            | jurisdiction | answeringService |
    | Iryna     | Smoli    | Public Sector    | Legal Advisor       | UK           | Arbitration      |
    | Iryna     | Smoli    | Public Sector    | Solicitor           | UK           | Arbitration      |
    | Iryna     | Smoli    | Public Sector    | Senior Solicitor    | UK           | EU               |
    | Iryna     | Smoli    | Public Sector    | District Solicitor  | UK           | EU               |
    | Iryna     | Smoli    | Public Sector    | Principal Solicitor | UK           | Pensions         |
    | Iryna     | Smoli    | Public Sector    | Legal Executive     | UK           | Pensions         |
    | Iryna     | Smoli    | Public Sector    | Practice Manager    | UK           | Commercial       |
    | Iryna     | Smoli    | Public Sector    | Department Head     | UK           | Commercial       |
    | Iryna     | Smoli    | Public Sector    | Head of Legal       | UK           | Property         |

  @bug @CloseAskWindow
  Scenario Outline: Successful ASK form submission by PL+ user into ASK mediator for Company
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | <firstName>                          |
      | Last Name         | <lastName>                           |
      | Organisation Type | <organisationType>                   |
      | Position          | <position>                           |
      | Jurisdiction      | <jurisdiction>                       |
      | Answering Service | <answeringService>                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then the question is correctly displayed on the ASK SharePoint site
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
  Examples:
    | firstName | lastName | organisationType | position                         | jurisdiction | answeringService |
    | Iryna     | Smoli    | Company          | Trainee                          | UK           | Arbitration      |
    | Iryna     | Smoli    | Company          | Paralegal                        | UK           | Arbitration      |
    | Iryna     | Smoli    | Company          | Compliance                       | UK           | EU               |
    | Iryna     | Smoli    | Company          | Compliance professional          | UK           | EU               |
    | Iryna     | Smoli    | Company          | In-house lawyer                  | UK           | Pensions         |
    | Iryna     | Smoli    | Company          | HR                               | UK           | Pensions         |
    | Iryna     | Smoli    | Company          | Department Head                  | UK           | Commercial       |
    | Iryna     | Smoli    | Company          | Deputy/Assistant General Counsel | UK           | Commercial       |
    | Iryna     | Smoli    | Company          | General counsel                  | UK           | Employment       |
    | Iryna     | Smoli    | Company          | Assistant Company Secretary      | UK           | Property         |
    | Iryna     | Smoli    | Company          | Company Secretary                | UK           | Property         |

  @bug @CloseAskWindow
  Scenario Outline: Successful ASK form submission by PL+ user into ASK mediator for Law Firm
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | <firstName>                          |
      | Last Name         | <lastName>                           |
      | Organisation Type | <organisationType>                   |
      | Position          | <position>                           |
      | Jurisdiction      | <jurisdiction>                       |
      | Answering Service | <answeringService>                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then the question is correctly displayed on the ASK SharePoint site
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
  Examples:
    | firstName | lastName | organisationType | position                    | jurisdiction | answeringService |
    | Iryna     | Smoli    | Law Firm         | Trainee                     | UK           | Arbitration      |
    | Iryna     | Smoli    | Law Firm         | Paralegal                   | UK           | Arbitration      |
    | Iryna     | Smoli    | Law Firm         | Junior Associate            | UK           | Corporate        |
    | Iryna     | Smoli    | Law Firm         | Senior Associate            | UK           | Corporate        |
    | Iryna     | Smoli    | Law Firm         | Librarian                   | UK           | EU               |
    | Iryna     | Smoli    | Law Firm         | Consultant                  | UK           | EU               |
    | Iryna     | Smoli    | Law Firm         | Partner                     | UK           | Pensions         |
    | Iryna     | Smoli    | Law Firm         | Senior partner              | UK           | Pensions         |
    | Iryna     | Smoli    | Law Firm         | Managing partner            | UK           | Commercial       |
    | Iryna     | Smoli    | Law Firm         | Professional support lawyer | UK           | Commercial       |
    | Iryna     | Smoli    | Law Firm         | Of Counsel                  | UK           | Property         |
    | Iryna     | Smoli    | Law Firm         | Practice area head          | UK           | Property         |
    | Iryna     | Smoli    | Law Firm         | Business development        | UK           | Employment       |
    | Iryna     | Smoli    | Law Firm         | Knowledge management        | UK           | Employment       |

  @bug @CloseAskWindow
  Scenario Outline: Successful ASK form submission by PL+ user into ASK mediator for Other
    When the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    And user completes the following ASK form fields
      | Question          | Test Question from Automation Script |
      | First Name        | <firstName>                          |
      | Last Name         | <lastName>                           |
      | Organisation Type | <organisationType>                   |
      | Position          | <position>                           |
      | Jurisdiction      | <jurisdiction>                       |
      | Answering Service | <answeringService>                   |
    And user submits the ASK form
    And A thank you page should appear with option to close the window
    And user closes the ASK window
    Then the question is correctly displayed on the ASK SharePoint site
      | First Name        | <firstName>        |
      | Last Name         | <lastName>         |
      | Organisation Type | <organisationType> |
      | Position          | <position>         |
      | Jurisdiction      | <jurisdiction>     |
      | Answering Service | <answeringService> |
  Examples:
    | firstName | lastName | organisationType | position                   | jurisdiction | answeringService |
    | Iryna     | Smoli    | Other            | Academic                   | UK           | Arbitration      |
    | Iryna     | Smoli    | Other            | Student                    | UK           | Property         |
    | Iryna     | Smoli    | Other            | Barrister                  | UK           | Commercial       |
    | Iryna     | Smoli    | Other            | Other (with Free Text Box) | UK           | EU               |

  @bug @manual
  Scenario: Successful ASK form submission by non-subscriber into ASK mediator
    Given PL+ user is not logged in
    When I open the ASK form to ask a question from anywhere on website
    And I complete the following ASK form fields
      | agreeToDisclaimerTerms | TRUE          |
      | firstName              | Iryna         |
      | lastName               | Smolina       |
      | organisationType       | Public Sector |
      | position               | Solicitor     |
      | jurisdiction           | UK            |
      | answeringService       | Property      |
    And submit the ASK form
    Then ASK form is successfully submitted
    And the question is displayed on the ASK SharePoint site
      | firstName        | Iryna                            |
      | lastName         | Smolina                          |
      | Email            | iryna.smolina@thomsonreuters.com |
      | organisationType | Public Sector                    |
      | position         | Solicitor                        |
      | answeringService | Property                         |
