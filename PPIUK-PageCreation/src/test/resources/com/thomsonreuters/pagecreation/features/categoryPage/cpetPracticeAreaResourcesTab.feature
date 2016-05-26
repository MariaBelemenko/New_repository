@wip

Feature: Check that the Resources Tab on each Practice Area page has:
* Expected list of Resources

#Phil Harper for CPET

  Background:
    Given PL+ user is logged in
    When the user is on the home page

  @PhilResourcesTabDebug1
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    And navigates to the Practice Area "Agriculture & Rural Land"
    And user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Agriculture & Rural Land                 |
      | Practice notes                                |
      | Standard documents and clauses                |
      | Checklists                                    |
      | Forms                                         |
      | Agriculture and rural land standard enquiries |
      | Toolkits                                      |
      | Glossary                                      |
      | Legal updates                                 |
      | Quarterly updates                             |
      | EU daily alerts                               |
      | EU legal updates and weekly e-mail            |
      | Email archive                                 |
      | Agricultural Law Global Guide                 |
      | Resources for those new to agricultural law   |
      | About this practice area                      |
      | Meet the team                                 |
      | New content                                   |
      | Provisional publishing schedule               |
      | Consultation board                            |

  @PhilResourcesTabDebug2
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When navigates to the Practice Area "Arbitration"
    And user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                                |
      | Standard documents and drafting notes                        |
      | Standard clauses and drafting notes                          |
      | Case studies                                                 |
      | Checklists                                                   |
      | Toolkits and trackers                                        |
      | Legal updates                                                |
      | Hot topics                                                   |
      | Case report list: investment treaty arbitration              |
      | Case report list: England & Wales                            |
      | Training materials, what's wrong with my arbitration clause? |
      | Training materials for those new to Arbitration law          |
      | Arbitration: the essential tools                             |
      | Useful links                                                 |
      | Glossary                                                     |
      | Arbitration Global Guide                                     |
      | Arbitration events calendar                                  |
      | About this practice area                                     |
      | Meet the team                                                |
      | New content                                                  |
      | Provisional publishing schedule                              |
      | Consultation board                                           |
      | Contributors                                                 |
      | Key dates for arbitration professionals                      |

  @PhilResourcesTabDebug3
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Business Crime & Investigations"
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                                              |
      | Standard documents and drafting notes                                       |
      | Checklists                                                                  |
      | Forms                                                                       |
      | Glossary                                                                    |
      | Legal updates                                                               |
      | Email archive                                                               |
      | Business crime & investigations blog                                        |
      | Allen & Overy contentious regulatory case and decision reports              |
      | Alison McHaffie's financial services investigations and enforcement columns |
      | Berwin Leighton Paisner's corporate crime and investigations column         |
      | Archbold Criminal Pleading Evidence and Practice                            |
    # Jim is making a change to CPET html, there is a double space in the "Archbold" html label that needs changing
      | Archbold Criminal Pleading  Evidence and Practice                                                                            |
      | Westlaw books                                                               |
      | Resources for those new to business crime                                   |
      | Provisional publishing schedule                                             |
      | Meet the team                                                               |
      | Consultation board                                                          |

  @PhilResourcesTabDebug4
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Commercial"
    Then the user verifies the "Resources" links are displayed
      | Ask: Commercial                            |
      | Practice notes                             |
      | Standard documents and drafting notes      |
      | Standard clauses and drafting notes        |
      | Checklists                                 |
      | Useful legislation, guidance and websites  |
      | Glossary                                   |
      | Legal updates                              |
      | Key dates for commercial law professionals |
      | Email archive                              |
      | Legislation tracker                        |
      | PLC Magazine                               |
      | Doing business in... Global Guide          |
      | Outsourcing Global Guide                   |
      | Resources for those new to commercial law  |
      | About this practice area                   |
      | Meet the team                              |
      | New content                                |
      | Provisional publishing schedule            |
      | Consultation board                         |

  @PhilResourcesTabDebug5
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Competition"
    Then the user verifies the "Resources" links are displayed
      | EU ~ Practice notes      |
      | EU ~ Case tracker tables |
      | Checklists               |
      | Flowcharts               |
      | Standard documents       |
      | Email archive            |
      | UK ~ Practice notes      |
      | Case tracker tables      |
      | Checklists               |
      | Flowcharts               |
      | Standard documents       |
      | Email archive            |

  @PhilResourcesTabDebug6
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Competition"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes      |
      | Case tracker tables |
      | Checklists          |
      | Flowcharts          |
      | Standard documents  |
      | Email archive       |
      | Practice notes      |
      | Case tracker tables |
      | Checklists          |
      | Flowcharts          |
      | Standard documents  |
      | Email archive       |

  @PhilResourcesTabDebug7
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Construction"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Construction                           |
      | Practice notes                              |
      | Standard documents and drafting notes       |
      | Standard clauses and drafting notes         |
      | Checklists                                  |
      | Procurement diagrams                        |
      | Glossary                                    |
      | Legal updates                               |
      | Email archive                               |
      | Legislation tracker                         |
      | Construction and Projects Global Guide      |
      | JCT contracts toolkit                       |
      | Resources for those new to construction law |
      | About this practice area                    |
      | Meet the team                               |
      | New content                                 |
      | Provisional publishing schedule             |
      | Consultation board                          |
      | Contributors                                |

  @PhilResourcesTabDebugX
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Corporate"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Corporate                                          |
      | Practice notes                                          |
      | Standard documents and drafting notes                   |
      | Standard clauses and drafting notes                     |
      | Checklists                                              |
      | Companies House forms                                   |
      | Glossary                                                |
      | Company secretary                                       |
      | Legal updates                                           |
      | Key dates for corporate lawyers: 2016                   |
      | Key dates for corporate lawyers: 2015                   |
      | Email archive                                           |
      | Legislation tracker                                     |
      | Case tracker                                            |
      | What's Market                                           |
      | GC100                                                   |
      | PLC Magazine                                            |
      | Private Equity and Venture Capital Global Guide         |
      | Public Mergers and Acquisitions Global Guide            |
      | Corporate Governance and Directors' Duties Global Guide |
      | Resources for those new to corporate law                |
      | Meet the team                                           |
      | New content                                             |
      | Provisional publishing schedule                         |
      | Consultation board                                      |

  @PhilResourcesTabDebug9
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Data Protection"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Data Protection                           |
      | Practice notes                                 |
      | Standard documents and drafting notes          |
      | Standard clauses and drafting notes            |
      | Checklists                                     |
      | Toolkits                                       |
      | Glossary                                       |
      | Legal updates                                  |
      | Email archive                                  |
      | Legislation tracker                            |
      | EU data protection reform: legislation tracker |
      | Hot topics                                     |
      | Data Protection Global Guide                   |
      | Resources for those new to data protection law |
      | About the practice area                        |
      | Meet the team                                  |
      | Consultation board                             |
      | New content                                    |
      | Provisional publishing schedule                |

  @PhilResourcesTabDebug10
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Dispute Resolution"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Dispute Resolution                                |
      | Practice notes                                         |
      | Standard documents and drafting notes                  |
      | Checklists                                             |
      | Case studies                                           |
      | Quick guides                                           |
      | Precedent statements of case                           |
      | Toolkits                                               |
      | Glossary                                               |
      | Legal updates                                          |
      | Events calendar                                        |
      | Email archive                                          |
      | Hot topics                                             |
      | Trackers                                               |
      | Jackson/civil litigation reforms                       |
      | Dispute Resolution Global Guide                        |
      | Restructuring and Insolvency Global Guide              |
      | A practical view from the Bar                          |
      | Resources for those new to dispute resolution (Part 1) |
      | Resources for those new to dispute resolution (Part 2) |
      | Civil procedure rules                                  |
      | Court fees                                             |
      | Court forms                                            |
      | Court guides                                           |
      | Guide to key terms used in the CPR                     |
      | CPR tracker                                            |
      | Civil Procedure Rule Committee meetings                |
      | Case report list                                       |
      | Other resources and external links                     |
      | Litigation tools                                       |
      | About this practice area​                              |
      | Meet the team                                          |
      | Consultation board                                     |
      | New content                                            |
      | Provisional publishing schedule                        |

  @PhilResourcesTabDebug11
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Employment"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Employment                               |
      | Practice notes                                |
      | Standard documents and drafting notes         |
      | Checklists                                    |
      | Current rates and limits                      |
      | Redundancy ready reckoner                     |
      | Toolkits                                      |
      | Glossary                                      |
      | Legal updates                                 |
      | Email archive                                 |
      | What to expect and employment law reform      |
      | Legislation tracker                           |
      | Case tracker                                  |
      | Employee Share Plans Global Guide             |
      | Employment and Employee Benefits Global Guide |
      | Resources for those new to employment law     |
      | About this practice area                      |
      | Meet the team                                 |
      | New content                                   |
      | Provisional publishing schedule               |
      | Consultation board                            |

  @PhilResourcesTabDebug12
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Environment"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                               |
      | Standard documents and drafting notes        |
      | Standard clauses and drafting notes          |
      | Checklists                                   |
      | Toolkits                                     |
      | CRC Survival Kit                             |
      | Glossary                                     |
      | Legal updates                                |
      | Email archive                                |
      | Legislation tracker                          |
      | Scottish devolution tracker                  |
      | Feed-in tariffs (FITs) tracker               |
      | What to expect in 2016                       |
      | PLC Magazine                                 |
      | Environment Global Guide                     |
      | Energy and Natural Resources Global Guide    |
      | Resources for those new to environmental law |
      | About this practice area                     |
      | Meet the team                                |
      | New content                                  |
      | Provisional publishing schedule              |
      | Consultation board                           |

  @PhilResourcesTabDebug13
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "EU Law"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Daily alerts                   |
      | Legal updates and weekly email |
      | Legislation trackers           |
      | Practice notes                 |
      | Articles                       |
      | EU Glossary                    |
      | Global guides                  |
      | How to use Practical Law EU    |
      | Why use Practical Law EU       |
      | Training                       |
      | Meet the team                  |

  @PhilResourcesTabDebug14
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Family"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                        |
      | Standard documents and drafting notes |
      | Standard clauses and drafting notes   |
      | Checklists                            |
      | Case tracker                          |
      | Court fees                            |
      | Court forms                           |
      | Toolkits                              |
      | Glossary                              |
      | Legal updates                         |
      | Email archive                         |
      | Family Law Global Guide               |
      | Resources for those new to family law |
      | About this practice area              |
      | Meet the team                         |
      | Consultation board                    |
      | Contributors                          |
      | Provisional publishing schedule       |

  @PhilResourcesTabDebugX
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Finance"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Finance                                       |
      | Practice notes                                     |
      | Standard documents and clauses with drafting notes |
      | Checklists                                         |
      | Deal structures                                    |
      | Glossary                                           |
      | Legal updates                                      |
      | Key dates for finance professionals                |
      | Email archive                                      |
      | Case tracker                                       |
      | What's Market                                      |
      | Public M & A                                       |
      | Convertible bonds                                  |
      | Global guides                                      |
      | PLC Magazine                                       |
      | Resources for those new to finance law             |
      | About this practice area                           |
      | Meet the team                                      |
      | New content                                        |
      | Provisional publishing schedule                    |
      | Consultation board                                 |
      | Contributors                                       |
      | Useful websites                                    |

  @PhilResourcesTabDebug16
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Financial Services"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                                              |
      | Checklists                                                                  |
      | Hot topics in financial services                                            |
      | Legal updates                                                               |
      | Key dates for financial services practitioners                              |
      | Email archive                                                               |
      | Financial services trackers                                                 |
      | FCA publication tracker 2016                                                |
      | Case tracker: 2016 financial services cases                                 |
      | Allen & Overy's contentious regulatory case and decision reports            |
      | Consumer credit and consumer contract case and decision reports             |
      | Article archive                                                             |
      | Alison McHaffie's financial services investigations and enforcement columns |
      | Ben Kingsley's banking and investment services column                       |
      | Berwin Leighton Paisner's corporate crime and investigations column         |
      | Gough Square Chambers' consumer credit column                               |
      | Jacob Ghanty's payment services and e-money column                          |
      | Lucy Frew's FinTech column: December 2015                                   |
      | Monica Gogna's (Ropes & Gray) asset management column                       |
      | Pollyanna Deane's insurance columns                                         |
      | Resources for those new to financial services                               |
      | About this practice area                                                    |
      | Meet the team                                                               |
      | New content                                                                 |
      | Provisional publishing schedule                                             |
      | Consultation board                                                          |

  @PhilResourcesTabDebug17
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "IP & IT"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: IP & IT                             |
      | Practice notes                           |
      | Standard documents and drafting notes    |
      | Standard clauses and drafting notes      |
      | Checklists                               |
      | Glossary                                 |
      | Legal updates                            |
      | Email archive                            |
      | Hot topics                               |
      | Legislation tracker                      |
      | IP in Business Transactions Global Guide |
      | Life Sciences Global Guide               |
      | Outsourcing Global Guide                 |
      | Resources for those new to IP and IT law |
      | About this practice area                 |
      | Meet the team                            |
      | New content                              |
      | Provisional publishing schedule          |
      | Consultation board                       |

  @PhilResourcesTabDebug18
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Local Government"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                          |
      | Standard documents, standard clauses and drafting notes |
      | Checklists                                              |
      | Toolkits and case studies                               |
      | Glossary                                                |
      | Legal updates                                           |
      | Blog                                                    |
      | In brief                                                |
      | Email archive                                           |
      | Legislation trackers                                    |
      | Case trackers                                           |
      | Resources for those new to local government             |
      | PLC Magazine                                            |
      | Public Procurement Global Guide                         |
      | About this practice area                                |
      | Meet the team                                           |
      | New content                                             |
      | Provisional publishing schedule                         |
      | Consultation board                                      |
      | Contributors                                            |

  @PhilResourcesTabDebug19
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Media & Telecoms"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Media & Telecoms                                   |
      | Practice notes                                          |
      | Standard documents and drafting notes                   |
      | Standard clauses and drafting notes                     |
      | Checklists                                              |
      | Glossary                                                |
      | Legal updates                                           |
      | Email archive                                           |
      | Legislation tracker                                     |
      | Hot topics                                              |
      | Communications: Regulation and Outsourcing Global Guide |
      | Resources for those new to media and telecoms law       |
      | About the practice area                                 |
      | Meet the team                                           |
      | New content                                             |
      | Provisional publishing schedule                         |
      | Consultation board                                      |

  @PhilResourcesTabDebug20
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Pensions"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask the team: archive                        |
      | Practice notes                               |
      | Standard documents and drafting notes        |
      | Checklists                                   |
      | Current allowances, rates and limits         |
      | Key topics citator                           |
      | Toolkits                                     |
      | Glossary                                     |
      | Legal updates                                |
      | At a glance                                  |
      | Email archive                                |
      | Legislation tracker                          |
      | Case tracker                                 |
      | Pensions Ombudsman tracker                   |
      | PPF Ombudsman tracker                        |
      | Pensions quarterly cases reports             |
      | Hot topics                                   |
      | PwC's monthly actuarial insights             |
      | Allen & Overy's pensions in practice reports |
      | PTL's Trustee Focus                          |
      | PLC Magazine                                 |
      | Pensions Global Guide                        |
      | Resources for those new to pensions law      |
      | New content                                  |
      | Meet the team                                |
      | Consultation board                           |
      | Provisional publishing schedule              |
      | Pensions Regulator                           |
      | Pension Protection Fund (PPF)                |
      | Financial Assistance Scheme (FAS)            |
      | Ombudsmen and Tribunals                      |
      | DWP                                          |
      | HMRC                                         |
      | European Union                               |
      | Actuarial bodies                             |

  @PhilResourcesTabDebug21
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Planning"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                          |
      | Standard documents and drafting notes   |
      | Checklists                              |
      | Toolkits                                |
      | Glossary                                |
      | Legal updates                           |
      | Email archive                           |
      | Resources for those new to planning law |
      | About this practice area                |
      | Meet the team                           |
      | New content                             |
      | Provisional publishing schedule         |
      | Consultation board                      |

  @PhilResourcesTabDebug22
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Private Client"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Private Client                                   |
      | Practice notes                                        |
      | Standard documents and drafting notes                 |
      | Standard clauses and drafting notes                   |
      | Checklists                                            |
      | Glossary                                              |
      | Tax data for individuals and trustees                 |
      | Interest rates for private client practitioners       |
      | Resources for charities                               |
      | Legal updates                                         |
      | Email archive                                         |
      | Legislation tracker                                   |
      | Budget tracker                                        |
      | Case tracker                                          |
      | Private Client Global Guide                           |
      | Finding key resources in Practical Law Private Client |
      | Resources for those new to private client practice    |
      | About this practice area                              |
      | Meet the team                                         |
      | New content                                           |
      | Provisional publishing schedule                       |
      | Consultation board                                    |

  @PhilResourcesTabDebug23
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Property"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Property                           |
      | Practice notes                          |
      | Standard documents and drafting notes   |
      | Standard clauses and drafting notes     |
      | Checklists                              |
      | Forms                                   |
      | Residential property materials          |
      | Toolkits                                |
      | Glossary                                |
      | Legal updates                           |
      | Property essentials                     |
      | Email archive                           |
      | Legislation tracker                     |
      | Corporate Real Estate Global Guide      |
      | Resources for those new to property law |
      | About this practice area                |
      | Meet the team                           |
      | New content                             |
      | Provisional publishing schedule         |
      | Consultation board                      |

  @PhilResourcesTabDebug24
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Property Litigation"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                 |
      | Standard documents and drafting notes          |
      | Checklists                                     |
      | Toolkits                                       |
      | Glossary                                       |
      | Legal updates                                  |
      | Email archive                                  |
      | Resources for those new to property litigation |
      | About this practice area                       |
      | Meet the team                                  |
      | New content                                    |
      | Provisional publishing schedule                |
      | Consultation board                             |

  @PhilResourcesTabDebug25
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Public Law"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Practice notes                                          |
      | Standard documents, standard clauses and drafting notes |
      | Checklists                                              |
      | Glossary                                                |
      | Legal updates                                           |
      | Blog                                                    |
      | Email archive                                           |
      | Case trackers                                           |
      | Resources for those new to public law                   |
      | PLC Magazine                                            |
      | Public Procurement Global Guide                         |
      | New content                                             |
      | Meet the team                                           |
      | Provisional publishing schedule                         |
      | Contributors                                            |
      | Consultation board                                      |

  @PhilResourcesTabDebugX
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Restructuring & Insolvency"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Restructuring & Insolvency                              |
      | Practice notes                                               |
      | Standard documents, drafting notes and checklists            |
      | Insolvency forms                                             |
      | Guide to Statements of Insolvency Practice (SIPs)            |
      | Glossary                                                     |
      | Legal updates                                                |
      | At a glance guides                                           |
      | Email archive                                                |
      | Legislation tracker                                          |
      | Insolvency Rules 2016                                        |
      | Case tracker                                                 |
      | What to expect: changes to insolvency law in 2015 and beyond |
      | What's Market                                                |
      | Listed company restructurings                                |
      | Administrations                                              |
      | PLC Magazine                                                 |
      | Restructuring and Insolvency Global Guide                    |
      | Resources for those new to R&I                               |
      | New content                                                  |
      | Meet the team                                                |
      | Provisional publishing schedule                              |
      | Consultation board                                           |

  @PhilResourcesTabDebug27
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Share Schemes & Incentives"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Share Schemes & Incentives                                          |
      | Practice notes                                                           |
      | Standard documents and drafting notes                                    |
      | Checklists                                                               |
      | Current tax year: selected tax, NICs and share schemes data              |
      | Glossary                                                                 |
      | Useful websites                                                          |
      | Legal updates                                                            |
      | Email archive                                                            |
      | Employee share schemes and Finance Bill 2016: summary of changes         |
      | Share schemes & incentives: summary of current and upcoming developments |
      | Share schemes & incentives case tracker                                  |
      | PLC Magazine                                                             |
      | Corporate Governance and Directors' Duties Global Guide                  |
      | Employee Share Plans Global Guide                                        |
      | Private Equity and Venture Capital Global Guide                          |
      | Resources for those new to share schemes practice                        |
      | About this practice area                                                 |
      | Meet the team                                                            |
      | New content                                                              |
      | Provisional publishing schedule                                          |
      | Consultation board                                                       |

  @PhilResourcesTabDebug28
  Scenario: Verify the Resources Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Tax"
    Then user clicks on Resources Tab
    Then the user verifies the "Resources" links are displayed
      | Ask: Tax                                        |
      | Practice notes                                  |
      | Standard documents and drafting notes           |
      | Checklists                                      |
      | Negotiating guides                              |
      | Tax covenants and tax warranties                |
      | Tax rates and limits                            |
      | Glossary                                        |
      | Useful websites                                 |
      | Legal updates                                   |
      | Email archive                                   |
      | Key dates for corporate tax practitioners: 2016 |
      | Legislation trackers                            |
      | Case tracker                                    |
      | Budgets, Autumn Statements and Finance Bills    |
      | PLC Magazine                                    |
      | Tax on Transactions Global Guide                |
      | Resources for those new to tax                  |
      | About this practice area                        |
      | Meet the team                                   |
      | New content                                     |
      | Provisional publishing schedule                 |
      | Contributors                                    |
      | Consultation board                              |
