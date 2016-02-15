@bug
Feature:[751653] Ask Form Drop down list
  As a: PL+ user
  I want: to have drop down list Position/Answering Service correctly populated
  So that: I can quickly submit question with correct details

  Background:
    Given PL+ user is logged in with following details
      | userName | AskTestuser |

  # 808814 SHOULD : REGRESSION:Ask Form: :UK Answering service has wrong value:UK answering service in Ask Form should have value 'Cross-border'
  @CloseAskWindow
  Scenario: Verify when Organisation Type  and Jurisdiction drop down lists are selected, corresponding Position/Answering Service  dropdown list have correct values
    When the user is in page 'Media & Telecoms' with page Title 'Media & Telecoms'
    And the user clicks on 'Ask a question' link to ask a question
    And ASK form is displayed in new window
    And the user accepts ASK disclaimer terms
    Then user verifies that when Organisation Type is selected corresponding Position dropdownlist have valid values
      | Organisation Type | Position                                                                                                                                                                                                                             |
      | Public Sector     | Select position,Legal Advisor,Solicitor,Senior Solicitor,District Solicitor,Principal Solicitor,Legal Executive,Practice Manager,Department Head,Head of Legal                                                                       |
      | Company           | Select position,Trainee,Paralegal,Compliance,Compliance professional,In-house lawyer,HR,Department Head,Deputy/Assistant General Counsel,General counsel,Assistant Company Secretary,Company Secretary                               |
      | Law Firm          | Select position,Trainee,Paralegal,Junior Associate,Senior Associate,Librarian,Consultant,Partner,Senior partner,Managing partner,Professional support lawyer,Of Counsel,Practice area head,Business development,Knowledge management |
      | Other             | Select position,Academic,Student,Barrister,Other (with Free Text Box)                                                                                                                                                                |
    And user verifies that when Jurisdiction is selected corresponding Answering Service dropdownlist have valid values
      | Jurisdiction  | Answering Service                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | UK            | Select an answering service,Agriculture,Arbitration,Business Crime & Investigations,Construction,Competition,Commercial,Corporate,Cross-border,Data Protection,Dispute Resolution,Employment,Environment,EU,Family,Finance,Financial Services,International Arbitration,IP&IT,Local Government,Media & Telecoms,Pensions,Planning,Private Client,Property,Property Litigation,Public Law,Restructuring & Insolvency,Share Schemes & Incentives,Tax |
      | US            | Select an answering service,Antitrust,Bankruptcy,Capital Markets & Securities,Commercial,Corporate & M&A,Employee Benefits & Executive Compensation,Finance,Litigation: Federal,Intellectual Property & Technology,International Arbitration,Labour & Employment,Real Estate,Tax,Other                                                                                                                                                             |
      | International | Select an answering service,Multi-jurisdictional guides,International Arbitration,EU,EU Competition,China,Other                                                                                                                                                                                                                                                                                                                                    |
