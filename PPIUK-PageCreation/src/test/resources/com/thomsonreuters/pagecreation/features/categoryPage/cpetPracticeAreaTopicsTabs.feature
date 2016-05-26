@wip

Feature: Check that the Topics Tab on each Practice Area page has:
* Expected list of Topics
* For Each Topic:
* Resulting URL contains PL string
* Resulting Page Label matches

#Phil Harper for CPET

  Background:
    Given PL+ user is logged in

  @PhilTopicsTabDebug1
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Agriculture & Rural Land"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                             | practiceAreaTopicURL                         | practiceAreaTopicPageLabel                            |
      | Agricultural finance                              | /topic/1-607-6333?sv=4-606-9406              | Agricultural Finance                                  |
      | Buying and selling rural land                     | /topic/3-607-6346?sv=4-606-9406              | Buying and Selling Rural Land                         |
      | Easements, covenants and other third party rights | /topic/6-103-2083?sv=4-606-9406              | Easements, Covenants and Other Third Party Rights     |
      | Equestrian                                        | /topic/6-607-6378?sv=4-606-9406              | Equestrian                                            |
      | EU agriculture                                    | /topic/3-607-6365?sv=4-606-9406              | EU Agriculture                                        |
      | Farm partnerships and farming agreements          | /topic/9-607-6428?sv=4-606-9406              | Farm partnerships and farming agreements              |
      | Rural environmental issues                        | /topic/6-607-6726?sv=4-606-9406              | Rural Environmental Issues                            |
      | Rural planning issues                             | /topic/2-607-6747?sv=4-606-9406              | Rural Planning Issues                                 |
      | Sporting rights                                   | /topic/9-607-6466?sv=4-606-9406              | Sporting Rights: Agriculture & Rural Land             |
      | Tax planning for agriculture and landed estates   | /topic/7-607-6486?sv=4-606-9406              | Tax Planning for Agriculture and Landed Estates       |
      | Agricultural holdings                             | topic/4-607-6586?sv=4-606-9406               | Agricultural Holdings                                 |
      | Agricultural licences                             | /topic/6-607-6665?sv=4-606-9406              | Agricultural Licences                                 |
      | Farm business tenancies                           | /topic/8-607-6626?sv=4-606-9406              | Farm Business Tenancies                               |
      | Farm dwellings                                    | /topic/8-607-6645?sv=4-606-9406              | Farm Dwellings                                        |
      | Common Agricultural Policy (CAP)                  | /topic/4-607-6666?sv=4-606-9406              | Common Agricultural Policy (CAP)                      |
      | Direct payment schemes                            | /topic/4-607-6685?sv=4-606-9406              | Direct Payment Schemes: Agriculture & Rural Land      |
      | Environmental land management schemes             | /topic/2-607-6686?sv=4-606-9406              | Environmental land management schemes                 |
      | Forestry                                          | /topic/8-607-6706?sv=4-606-9406              | Forestry                                              |
      | Environment                                       | /Browse/Home/Practice/Environment            | Environment                                           |
      | Planning                                          | /Browse/Home/Practice/Planning               | Planning                                              |
      | Private Client                                    | /Browse/Home/Practice/PrivateClient          | Private Client                                        |
      | Property                                          | /Browse/Home/Practice/Property               | Property                                              |
      | Tax                                               | /Browse/Home/Practice/Tax                    | Tax                                                   |
      | Useful tax materials produced by other services   | /Document/Id98ec03d392d11e598dc8b09b4f043e0/ | Useful tax materials produced by other practice areas |

  @PhilTopicsTabDebug2
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Arbitration"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                         | practiceAreaTopicURL                          | practiceAreaTopicPageLabel                    |
      | Institutional and Ad-hoc Arbitration: General | /topic/0-522-2350?sv=6-382-1328               | Institutional and Ad hoc Arbitration: General |
      | AAA/ICDR                                      | /topic/7-521-5761?sv=6-382-1328               | AAA/ICDR                                      |
      | ICC                                           | /topic/5-521-5762?sv=6-382-1328               | ICC                                           |
      | LCIA                                          | /topic/3-521-5763?sv=6-382-1328               | LCIA                                          |
      | SCC                                           | /topic/1-521-5764?sv=6-382-1328               | SCC                                           |
      | UNCITRAL                                      | /topic/8-521-5765?sv=6-382-1328               | UNCITRAL                                      |
      | ICSID                                         | /topic/6-521-5766?sv=6-382-1328               | ICSID                                         |
      | CIETAC                                        | /topic/4-521-5767?sv=6-382-1328               | CIETAC                                        |
      | HKIAC                                         | /topic/2-521-5768?sv=6-382-1328               | HKIAC                                         |
      | SIAC                                          | /topic/0-521-5769?sv=6-382-1328               | SIAC                                          |
      | Arbitration agreements                        | /topic/5-203-6783?sv=6-382-1328               | Arbitration Agreements                        |
      | Conflicts of law issues                       | /topic/3-381-2957?sv=6-382-1328               | Conflicts of Law Issues: Arbitration          |
      | National arbitration legislation              | /topic/3-381-2962?sv=6-382-1328               | National arbitration legislation              |
      | Costs and funding                             | /topic/8-203-6786?sv=6-382-1328               | Costs and Funding: Arbitration                |
      | Interim measures                              | /topic/5-381-2961?sv=6-382-1328               | Interim Measures: Arbitration                 |
      | Jurisdictional issues                         | /topic/3-363-4955?sv=6-382-1328               | Jurisdictional Issues: Arbitration            |
      | Arbitrators and appointments                  | /topic/0-203-6790?sv=6-382-1328               | Arbitrators and Appointments                  |
      | Applications to court                         | /topic/3-203-6784?sv=6-382-1328               | Applications to Court                         |
      | Commencing arbitration                        | /topic/8-203-6791?sv=6-382-1328               | Commencing an Arbitration                     |
      | Procedure and evidence                        | /topic/1-381-2958?sv=6-382-1328               | Procedure and Evidence: Arbitration           |
      | Multi party arbitration                       | /topic/4-203-6788?sv=6-382-1328               | Multiparty Arbitration                        |
      | Remedies                                      | /topic/8-521-5770?sv=6-382-1328               | Remedies: Arbitration                         |
      | Arbitral awards and challenges                | /topic/0-203-6785?sv=6-382-1328               | Arbitral Awards and Challenges                |
      | Enforcement                                   | /topic/6-521-5771?sv=6-382-1328               | Enforcement: Arbitration                      |
      | Investment treaty arbitration                 | /topic/8-205-4997?sv=6-382-1328               | Investment Treaty Arbitration                 |
      | Arbitration (England & Wales)                 | /Browse/Home/Practice/ArbitrationEnglandWales | Arbitration (England & Wales)                 |

  @PhilTopicsTabDebug3
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Business Crime & Investigations"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                                 | practiceAreaTopicURL            | practiceAreaTopicPageLabel                              |
      | Investigation powers                                  | /topic/9-591-9509?sv=7-589-6165 | Investigation Powers                                    |
      | Arrest and bail                                       | /topic/7-607-9625?sv=7-589-6165 | Arrest and Bail                                         |
      | Search and seizure                                    | /topic/5-607-9626?sv=7-589-6165 | Search and Seizure                                      |
      | Interviews                                            | /topic/3-607-9627?sv=7-589-6165 | Interviews                                              |
      | Decision to charge or alternative disposal            | /topic/7-607-9630?sv=7-589-6165 | Decision to Charge or Alternative Disposal              |
      | Criminal procedure                                    | /topic/3-591-9526?sv=7-589-6165 | Criminal Procedure                                      |
      | Criminal evidence                                     | /topic/9-591-9528?sv=7-589-6165 | Criminal Evidence                                       |
      | Sentencing and orders on conviction                   | /topic/5-607-9631?sv=7-589-6165 | Sentencing and Orders on Conviction                     |
      | Confiscation and restraint                            | /topic/3-607-9632?sv=7-589-6165 | Confiscation and Restraint                              |
      | Criminal appeal                                       | /topic/7-591-9529?sv=7-589-6165 | Criminal Appeal                                         |
      | Extradition                                           | /topic/1-607-9633?sv=7-589-6165 | Extradition                                             |
      | Mutual legal assistance                               | /topic/9-607-9634?sv=7-589-6165 | Mutual Legal Assistance                                 |
      | Corporate criminal liability                          | /topic/3-591-9507?sv=7-589-6165 | Corporate Criminal Liability                            |
      | BIS investigation and prosecution powers              | /topic/4-591-9540?sv=7-589-6165 | BIS investigation and prosecution powers                |
      | Companies Act and Insolvency Act offences             | /topic/3-607-9651?sv=7-589-6165 | Companies Act and Insolvency Act Offences               |
      | CMA investigation and prosecution powers              | /topic/4-591-9535?sv=7-589-6165 | CMA investigation and prosecution powers                |
      | Cartel offences                                       | /topic/9-607-9648?sv=7-589-6165 | Cartel Offences                                         |
      | CPS investigation and prosecution powers              | /topic/9-591-9533?sv=7-589-6165 | CPS investigation and prosecution powers                |
      | Data protection offences                              | /topic/1-607-9647?sv=7-589-6165 | Data Protection Offences                                |
      | Money laundering offences                             | /topic/7-607-9654?sv=7-589-6165 | Money Laundering Offences                               |
      | Theft, fraud and forgery offences                     | /topic/3-607-9646?sv=7-589-6165 | Theft, Fraud and Forgery Offences                       |
      | EA investigation and prosecution powers               | /topic/0-591-9537?sv=7-589-6165 | Environment Agency Investigation and Prosecution Powers |
      | Environmental offences                                | /topic/5-607-9650?sv=7-589-6165 | Environmental Offences                                  |
      | FCA investigation and prosecution powers              | /topic/1-591-9532?sv=7-589-6165 | FCA Investigation and Prosecution Powers                |
      | Financial services offences                           | /topic/4-607-9655?sv=7-589-6165 | Financial Services Offences                             |
      | HSE investigation and prosecution powers              | /topic/2-591-9536?sv=7-589-6165 | HSE Investigation and Prosecution Powers                |
      | Corporate manslaughter and health and safety offences | /topic/7-607-9649?sv=7-589-6165 | Corporate Manslaughter and Health and Safety Offences   |
      | HMRC investigation and prosecution powers             | /topic/1-607-9652?sv=7-589-6165 | HMRC Investigation and Prosecution Powers               |
      | Tax evasion offences                                  | /topic/9-607-9653?sv=7-589-6165 | Tax Evasion Offences                                    |
      | LA investigation and prosecution powers               | /topic/2-591-9541?sv=7-589-6165 | Local Authority Investigation and Prosecution Powers    |
      | SFO investigation and prosecution powers              | /topic/5-591-9530?sv=7-589-6165 | SFO Investigation and Prosecution Powers                |
      | Bribery and sanctions offences                        | /topic/5-607-9645?sv=7-589-6165 | Bribery and Sanctions Offences                          |

  @PhilTopicsTabDebug4
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Commercial"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink            | practiceAreaTopicURL            | practiceAreaTopicPageLabel       |
      | Advertising and marketing        | /topic/0-103-1114?sv=1-379-8575 | Advertising and Marketing        |
      | Agency                           | /topic/7-103-1115?sv=1-379-8575 | Agency                           |
      | Bailment and leasing             | /topic/0-505-0382?sv=1-379-8575 | Bailment and Leasing             |
      | Betting and gaming               | /topic/4-103-1249?sv=1-379-8575 | Betting and Gaming               |
      | Confidentiality                  | /topic/7-103-1304?sv=1-379-8575 | Confidentiality                  |
      | Consumer                         | /topic/0-103-2038?sv=1-379-8575 | Consumer                         |
      | Distribution                     | /topic/6-103-1130?sv=1-379-8575 | Distribution                     |
      | E-commerce                       | /topic/2-103-1274?sv=1-379-8575 | E-commerce                       |
      | Franchising                      | /topic/4-103-1131?sv=1-379-8575 | Franchising                      |
      | General commercial               | /topic/7-379-8563?sv=1-379-8575 | General Commercial               |
      | General contract and boilerplate | /topic/9-103-1119?sv=1-379-8575 | General Contract and Boilerplate |
      | Outsourcing                      | /topic/0-202-2707?sv=1-379-8575 | Outsourcing                      |
      | Preliminary agreements           | /topic/9-103-1138?sv=1-379-8575 | Preliminary Agreements           |
      | Product liability and labelling  | /topic/3-103-1141?sv=1-379-8575 | Product Liability and Labelling  |
      | Public procurement               | /topic/7-103-1177?sv=1-379-8575 | Public Procurement               |
      | Supply of goods and services     | /topic/0-103-1128?sv=1-379-8575 | Supply of Goods and Services     |
      | Tort                             | /topic/1-540-5226?sv=1-379-8575 | Tort                             |
      | Trade finance                    | /topic/0-103-1109?sv=1-379-8575 | Trade Finance                    |

  @PhilTopicsTabDebug5
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Competition"
    Then user clicks on Topic Link for Competition, verify the url and verify the Page Label
      | practiceAreaTopiclink                     | practiceAreaTopicURL            | practiceAreaTopicPageLabel                       |
      | Authorities                               | /topic/8-103-1172?sv=2-524-1017 | Authorities                                      |
      | Cartels                                   | /topic/1-103-1161?sv=2-524-1017 | Cartels                                          |
      | Competition compliance and dawn raids     | /topic/2-103-2056?sv=2-524-1017 | Competition Compliance and Dawn Raids            |
      | Complaints and market investigations      | /topic/6-103-1173?sv=2-524-1017 | Complaints and Market Investigations             |
      | Courts                                    | /topic/1-103-1175?sv=2-524-1017 | Courts: Competition                              |
      | Cross-border: competition and antitrust   | /topic/5-103-1159?sv=2-524-1017 | Cross-border: Competition and Antitrust          |
      | Fines: competition                        | /topic/9-103-1176?sv=2-524-1017 | Fines: Competition                               |
      | General competition                       | /topic/8-103-1167?sv=2-524-1017 | General: Competition                             |
      | General procedure and enforcement         | /topic/0-103-1171?sv=2-524-1017 | General Procedure and Enforcement: Competition   |
      | Horizontal co-operation                   | /topic/3-103-1160?sv=2-524-1017 | Horizontal Co-operation                          |
      | Intellectual property                     | /topic/0-103-2057?sv=2-524-1017 | Intellectual Property: Competition               |
      | Joint ventures                            | /topic/7-103-1163?sv=2-524-1017 | Joint Ventures: Competition                      |
      | Market definition                         | /topic/5-103-1164?sv=2-524-1017 | Market Definition                                |
      | Market power and dominance                | /topic/2-103-1165?sv=2-524-1017 | Market Power and Dominance                       |
      | Merger control                            | /topic/0-103-1166?sv=2-524-1017 | Merger Control                                   |
      | Parallel trading                          | /topic/6-103-1168?sv=2-524-1017 | Parallel Trading                                 |
      | Policy and reform: competition            | /topic/4-103-1169?sv=2-524-1017 | Policy and Reform: Competition                   |
      | Pricing                                   | /topic/2-103-1170?sv=2-524-1017 | Pricing: Competition                             |
      | Public procurement                        | /topic/7-103-1177?sv=2-524-1017 | Public Procurement                               |
      | Research and development agreements       | /topic/9-103-1162?sv=2-524-1017 | Research and Development Agreements: Competition |
      | Restrictive agreements                    | /topic/5-103-1178?sv=2-524-1017 | Restrictive Agreements                           |
      | Special sectors and utilities: regulation | /topic/3-103-1179?sv=2-524-1017 | Special Sectors and Utilities: Regulation        |
      | State aid                                 | /topic/1-103-1180?sv=2-524-1017 | State Aid                                        |
      | Vertical agreements                       | /topic/9-103-1181?sv=2-524-1017 | Vertical Agreements                              |

  @PhilTopicsTabDebug6
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Construction"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                     | practiceAreaTopicURL            | practiceAreaTopicPageLabel                |
      | Building contracts and contractors        | /topic/1-381-2944?sv=4-383-5821 | Building Contracts and Contractors        |
      | Engineering contracts                     | /topic/6-381-2946?sv=4-383-5821 | Engineering Contracts                     |
      | General contract and boilerplate          | /topic/9-103-1119?sv=4-383-5821 | General Contract and Boilerplate          |
      | Insurance                                 | /topic/2-103-1132?sv=4-383-5821 | Insurance                                 |
      | International construction contracts      | /topic/4-381-2947?sv=4-383-5821 | International Construction Contracts      |
      | Professional appointments and liabilities | /topic/8-381-2950?sv=4-383-5821 | Professional Appointments and Liabilities |
      | Adjudication                              | /topic/3-204-9135?sv=4-383-5821 | Adjudication: ADR                         |
      | ADR                                       | /topic/0-381-2954?sv=4-383-5821 | Construction ADR                          |
      | Arbitration                               | /topic/7-381-2955?sv=4-383-5821 | Construction Arbitration                  |
      | Litigation                                | /topic/5-381-2956?sv=4-383-5821 | Construction Litigation                   |
      | Project finance                           | /topic/3-201-5282?sv=4-383-5821 | Project Finance                           |
      | Real estate finance and investment        | /topic/9-103-2086?sv=4-383-5821 | Real Estate Finance and Investment        |
      | Collateral warranties and third parties   | /topic/2-381-2953?sv=4-383-5821 | Collateral Warranties and Third Parties   |
      | Development documents                     | /topic/8-381-2945?sv=4-383-5821 | Development Documents                     |
      | Regeneration                              | /topic/6-381-2951?sv=4-383-5821 | Regeneration                              |
      | Sustainability and environment            | /topic/4-381-2952?sv=4-383-5821 | Sustainability and Environment            |
      | Procurement                               | /topic/0-381-2949?sv=4-383-5821 | Procurement                               |
      | Public procurement                        | /topic/7-103-1177?sv=4-383-5821 | Public Procurement                        |
      | Health and safety                         | /topic/3-200-1671?sv=4-383-5821 | Health and Safety                         |
      | Insolvency                                | /topic/1-103-1316?sv=4-383-5821 | Property: Restructuring and Insolvency    |
      | Statutory liabilities: land and buildings | /topic/8-103-1327?sv=4-383-5821 | Statutory Liabilities: Land and Buildings |
      | Taxation                                  | /topic/8-103-1394?sv=4-383-5821 | Taxation: Land and Buildings              |

  @PhilTopicsTabDebug7
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Corporate"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                                  | practiceAreaTopicURL                               | practiceAreaTopicPageLabel                             |
      | Company administration and meetings                    | /topic/4-103-1145?sv=3-103-1749                    | Company Administration and Meetings                    |
      | Company formation and constitution                     | /topic/2-103-1146?sv=3-103-1749                    | Company Formation and Constitution                     |
      | Corporate governance                                   | /topic/8-103-1148?sv=3-103-1749                    | Corporate Governance                                   |
      | Directors                                              | /topic/7-200-0622?sv=3-103-1749                    | Directors                                              |
      | Financial reporting                                    | /topic/3-103-1240?sv=3-103-1749                    | Financial and Narrative Reporting                      |
      | Share capital: structure, allotment and transfers      | /topic/9-103-1157?sv=3-103-1749                    | Share Capital: Structure, Allotment and Transfers      |
      | Shareholder rights and remedies                        | /topic/6-103-1154?sv=3-103-1749                    | Shareholder Rights and Remedies                        |
      | AIM                                                    | /topic/1-103-1364?sv=3-103-1749                    | AIM                                                    |
      | Initial public offerings                               | /topic/3-103-1377?sv=3-103-1749                    | Initial Public Offerings                               |
      | Listing, Prospectus, Disclosure and Transparency Rules | /topic/8-103-2096?sv=3-103-1749                    | Listing, Prospectus, Disclosure and Transparency Rules |
      | Rights issues and other secondary issues               | /topic/0-103-2095?sv=3-103-1749                    | Rights Issues and Other Secondary Issues               |
      | Financial promotion                                    | /topic/2-103-1354?sv=3-103-1749                    | Financial Promotion and Marketing                      |
      | Market conduct                                         | /topic/5-103-1357?sv=3-103-1749                    | Market Conduct                                         |
      | US securities law: issues for non-US companies         | /topic/9-201-5199?sv=3-103-1749                    | US Securities Law: Issues for Non-US Companies         |
      | Asset acquisitions                                     | /topic/5-103-1079?sv=3-103-1749                    | Asset Acquisitions                                     |
      | Share acquisitions: private                            | /topic/1-103-1081?sv=3-103-1749                    | Share Acquisitions: Private                            |
      | Public mergers & acquisitions                          | /topic/7-103-1083?sv=3-103-1749                    | Public Mergers and Acquisitions                        |
      | Joint ventures                                         | /topic/8-103-1308?sv=3-103-1749                    | Joint Ventures                                         |
      | Private equity and venture capital                     | /topic/0-103-1350?sv=3-103-1749                    | Private Equity and Venture Capital                     |
      | Reorganisations, schemes and demergers                 | /topic/8-103-1153?sv=3-103-1749                    | Reorganisations, Schemes and Demergers                 |
      | Returns of value                                       | /topic/7-103-2054?sv=3-103-1749                    | Returns of value                                       |
      | Partnership and LLPs                                   | /topic/5-103-2045?sv=3-103-1749                    | Partnerships and LLPs                                  |
      | General contract and boilerplate                       | /topic/9-103-1119?sv=3-103-1749                    | General Contract and Boilerplate                       |
      | Bribery and sanctions offences                         | /topic/7-103-1182?sv=3-103-1749                    | Financial Crime                                        |
      | Resources for company secretaries                      | /Browse/Home/Collections/Forcompanysecretaries     | For company secretaries                                |
      | For in-house lawyers                                   | /Browse/Home/Collections/Forinhouselawyers         | For in-house lawyers                                   |
      | For advising smaller businesses                        | /Browse/Home/Collections/Advisingsmallerbusinesses | Advising smaller businesses                            |

  @PhilTopicsTabDebug8
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Data Protection"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink         | practiceAreaTopicURL                | practiceAreaTopicPageLabel              |
      | Compliance                    | /topic/1-616-6178?sv=1-614-3506     | Compliance: Data Protection             |
      | Cookies                       | /topic/5-616-6218?sv=1-614-3506     | Cookies                                 |
      | Data security                 | /topic/8-616-6189?sv=1-614-3506     | Data Security                           |
      | Data sharing                  | /topic/2-616-6187?sv=1-614-3506     | Data Sharing                            |
      | Direct marketing              | /topic/9-616-6179?sv=1-614-3506     | Direct Marketing: Data Protection       |
      | Employee data and monitoring  | /topic/5-200-0623?sv=1-614-3506     | Employee Data and Monitoring            |
      | EU data protection reform     | /topic/7-616-6199?sv=1-614-3506     | EU Data Protection Reform               |
      | Exporting personal data       | /topic/2-616-6192?sv=1-614-3506     | Exporting Personal Data                 |
      | General                       | /topic/1-616-6550?sv=1-614-3506     | Data Protection: General                |
      | Rights of data subjects       | /topic/6-616-6190?sv=1-614-3506     | Rights of Data Subjects                 |
      | Sanctions and remedies        | /topic/0-616-6193?sv=1-614-3506     | Sanctions and Remedies: Data Protection |
      | Surveillance                  | /topic/7-616-6222?sv=1-614-3506     | Surveillance: Data Protection           |
      | Technology                    | /topic/8-616-6207?sv=1-614-3506     | Technology: Data Protection             |
      | Transactions                  | /topic/5-616-6195?sv=1-614-3506     | Transactions: Data Protection           |
      | IP & IT                       | /Browse/Home/Practice/IPIT          | IP & IT                                 |
      | Media & Telecoms              | /Browse/Home/Practice/MediaTelecoms | Media & Telecoms                        |

  @PhilTopicsTabDebug9
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Dispute Resolution"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink            | practiceAreaTopicURL                          | practiceAreaTopicPageLabel                      |
      | Pre-action conduct               | /topic/9-203-6804?sv=1-203-9929               | Pre-action Conduct                              |
      | Funding                          | /topic/5-381-9613?sv=1-203-9929               | Funding Litigation                              |
      | Jurisdiction and cross-border    | /topic/3-103-1202?sv=1-203-9929               | Jurisdiction and Cross-border                   |
      | Limitation                       | /topic/1-103-1203?sv=1-203-9929               | Limitation                                      |
      | Security for costs               | /topic/4-203-6806?sv=1-203-9929               | Security for Costs                              |
      | Injunctive relief                | /topic/7-203-6800?sv=1-203-9929               | Injunctive Relief                               |
      | Starting a claim                 | /topic/3-381-9614?sv=1-203-9929               | Starting a Claim                                |
      | Service                          | /topic/2-203-6807?sv=1-203-9929               | Service                                         |
      | Responding to a claim            | /topic/7-381-7646?sv=1-203-9929               | Responding to a Claim                           |
      | Statements of case               | /topic/6-203-6810?sv=1-203-9929               | Statements of Case                              |
      | Interim applications             | /topic/5-203-6801?sv=1-203-9929               | Interim Applications                            |
      | Early determination              | /topic/5-203-6797?sv=1-203-9929               | Early Determination: Litigation                 |
      | Case management                  | /topic/2-203-6794?sv=1-203-9929               | Case Management                                 |
      | Disclosure                       | /topic/4-103-1193?sv=1-203-9929               | Disclosure: Litigation                          |
      | Evidence                         | /topic/5-103-1197?sv=1-203-9929               | Evidence: Litigation                            |
      | Experts                          | /topic/3-203-6798?sv=1-203-9929               | Experts                                         |
      | Settlement and Part 36           | /topic/0-203-6808?sv=1-203-9929               | Settlement and Part 36                          |
      | Trial                            | /topic/4-203-6811?sv=1-203-9929               | Trial                                           |
      | Costs                            | /topic/1-203-6799?sv=1-203-9929               | Costs: Litigation                               |
      | Appeals                          | /topic/4-203-6793?sv=1-203-9929               | Appeals                                         |
      | Enforcement                      | /topic/7-204-0010?sv=1-203-9929               | Enforcement: Litigation                         |
      | Insolvency litigation            | /topic/7-540-5426?sv=1-203-9929               | Court Proceedings: Restructuring and Insolvency |
      | Judicial review                  | /topic/5-384-0921?sv=1-203-9929               | Judicial Review                                 |
      | Adjudication                     | /topic/3-204-9135?sv=1-203-9929               | Adjudication: ADR                               |
      | Early neutral evaluation         | /topic/1-204-9141?sv=1-203-9929               | Early Neutral Evaluation: ADR                   |
      | Expert determination             | /topic/7-204-9138?sv=1-203-9929               | Expert Determination: ADR                       |
      | Mediation                        | /topic/1-204-9136?sv=1-203-9929               | Mediation: ADR                                  |
      | Dispute resolution clauses       | /topic/1-540-5207?sv=1-203-9929               | Dispute Resolution Clauses                      |
      | General contract and boilerplate | /topic/9-103-1119?sv=1-203-9929               | General Contract and Boilerplate                |
      | Remedies                         | /topic/8-103-1214?sv=1-203-9929               | Remedies                                        |
      | Substantive law                  | /topic/6-204-9134?sv=1-203-9929               | Substantive Law                                 |
      | Tort                             | /topic/1-540-5226?sv=1-203-9929               | Tort                                            |
      | Arbitration (England & Wales)    | /Browse/Home/Practice/ArbitrationEnglandWales | Arbitration (England & Wales)                   |
      | Property Litigation              | /Browse/Home/Practice/PropertyLitigation      | Property Litigation                             |
      | Lower value claims               | /Document/I33f1f455e8cd11e398db8b09b4f043e0   | Lower value claims materials                    |

  @PhilTopicsTabDebug10
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Employment"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                      | practiceAreaTopicURL            | practiceAreaTopicPageLabel                            |
      | ADR                                        | /topic/7-382-7457?sv=0-200-2200 | ADR: Employment                                       |
      | Atypical working                           | /topic/5-200-0618?sv=0-200-2200 | Atypical Working                                      |
      | Civil litigation                           | /topic/1-540-5245?sv=0-200-2200 | Civil Litigation: Employment                          |
      | Collective consultation                    | /topic/1-200-0620?sv=0-200-2200 | Collective Consultation                               |
      | Contracts of employment                    | /topic/9-103-1223?sv=0-200-2200 | Contracts of Employment                               |
      | Cross-border and immigration               | /topic/6-382-8829?sv=0-200-2200 | Cross-border and Immigration                          |
      | Directors                                  | /topic/7-200-0622?sv=0-200-2200 | Directors                                             |
      | Discipline and performance management      | /topic/9-540-5246?sv=0-200-2200 | Discipline and Performance Management                 |
      | Discrimination                             | /topic/4-382-8830?sv=0-200-2200 | Discrimination: Employment                            |
      | Employee data and monitoring               | /topic/5-200-0623?sv=0-200-2200 | Employee Data and Monitoring                          |
      | Employment status and self-employment      | /topic/2-382-8831?sv=0-200-2200 | Employment Status and Independent Contractors         |
      | Employment tribunals                       | /topic/1-382-7460?sv=0-200-2200 | Employment Tribunals                                  |
      | Employment Appeal Tribunal                 | /topic/3-382-7459?sv=0-200-2200 | Employment Appeal Tribunal                            |
      | Equal pay                                  | /topic/0-382-8832?sv=0-200-2200 | Equal Pay                                             |
      | Families and pregnancy                     | /topic/7-200-0617?sv=0-200-2200 | Families and Pregnancy                                |
      | Grievances                                 | /topic/3-540-5249?sv=0-200-2200 | Grievances                                            |
      | Human rights                               | /topic/6-103-1253?sv=0-200-2200 | Human Rights                                          |
      | Partnerships and LLPs                      | /topic/5-103-2045?sv=0-200-2200 | Partnerships and LLPs                                 |
      | Pay and benefits                           | /topic/0-200-0630?sv=0-200-2200 | Pay and Benefits                                      |
      | Policies and procedures                    | /topic/9-382-7461?sv=0-200-2200 | Policies and Procedures: Employment                   |
      | Recruitment                                | /topic/8-200-0626?sv=0-200-2200 | Recruitment                                           |
      | Redundancy and business reorganisation     | /topic/3-200-0619?sv=0-200-2200 | Redundancy and Business Reorganisation                |
      | Restraint of trade, confidentiality and IP | /topic/2-103-2061?sv=0-200-2200 | Restraint of Trade, Confidentiality and IP            |
      | Restructuring and insolvency               | /topic/7-103-1257?sv=0-200-2200 | Directors and Employees: Restructuring and Insolvency |
      | Sickness and incapacity                    | /topic/6-200-0627?sv=0-200-2200 | Sickness and Incapacity                               |
      | Taxation                                   | /topic/4-200-0628?sv=0-200-2200 | Taxation: Employment                                  |
      | Termination of employment                  | /topic/1-103-1222?sv=0-200-2200 | Termination of Employment                             |
      | Trade unions                               | /topic/8-103-2063?sv=0-200-2200 | Unions                                                |
      | Transfer of shares                         | /topic/7-103-1224?sv=0-200-2200 | Transfer of Shares: Employment                        |
      | Transfer of undertakings                   | /topic/4-103-1225?sv=0-200-2200 | Transfer of Undertakings                              |
      | Unfair dismissal                           | /topic/5-540-5248?sv=0-200-2200 | Unfair Dismissal                                      |
      | Whistleblowing                             | /topic/8-200-0631?sv=0-200-2200 | Whistleblowing                                        |
      | Working time and time off                  | /topic/2-103-1226?sv=0-200-2200 | Working Time and Time Off                             |

  @PhilTopicsTabDebug11
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Environment"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                          | practiceAreaTopicURL                        | practiceAreaTopicPageLabel                        |
      | Access to environmental information            | /topic/6-103-1229?sv=5-203-9927             | Access to Environmental Information               |
      | Air pollution                                  | /topic/9-540-5265?sv=5-203-9927             | Air Pollution                                     |
      | Chemicals and hazardous substances             | /topic/1-103-1236?sv=5-203-9927             | Chemicals and Hazardous Substances                |
      | Climate change                                 | /topic/6-103-2064?sv=5-203-9927             | Climate change                                    |
      | Contaminated land                              | /topic/8-103-1228?sv=5-203-9927             | Contaminated Land                                 |
      | CRC                                            | /topic/5-540-5267?sv=5-203-9927             | CRC                                               |
      | Energy: environmental issues                   | /topic/1-201-5565?sv=5-203-9927             | Energy: environmental issues                      |
      | Enforcement and litigation procedure           | /topic/9-103-1237?sv=5-203-9927             | Enforcement and Litigation Procedure: Environment |
      | Environmental consultants                      | /topic/9-201-5566?sv=5-203-9927             | Environmental Consultants                         |
      | Environmental impact assessments               | /topic/1-200-2228?sv=5-203-9927             | Environmental Impact Assessments                  |
      | Environmental Liability Directive              | /topic/7-201-5567?sv=5-203-9927             | Environmental Liability Directive                 |
      | Environmental management and reporting         | /topic/1-103-2066?sv=5-203-9927             | Environmental Management and Reporting            |
      | Environmental permitting                       | /topic/3-201-5569?sv=5-203-9927             | Environmental Permitting                          |
      | Environmental taxes                            | /topic/5-201-5568?sv=5-203-9927             | Environmental Taxes                               |
      | General environment                            | /topic/7-200-2230?sv=5-203-9927             | General Environment                               |
      | GMOs                                           | /topic/7-540-5285?sv=5-203-9927             | GMOs                                              |
      | Habitats, wildlife and biodiversity            | /topic/5-200-2226?sv=5-203-9927             | Habitats, Wildlife and Biodiversity               |
      | Health and safety: environmental issues        | /topic/3-200-1671?sv=5-203-9927             | Health and Safety                                 |
      | Insurance                                      | /topic/2-103-1132?sv=5-203-9927             | Insurance                                         |
      | Nanomaterials                                  | /topic/1-540-5306?sv=5-203-9927             | Nanomaterials                                     |
      | Nuclear and radioactive substances             | /topic/1-201-5570?sv=5-203-9927             | Nuclear and Radioactive Substances                |
      | Nuisance and noise control                     | /topic/8-103-1233?sv=5-203-9927             | Nuisance and Noise Control                        |
      | Planning: environmental issues                 | /topic/9-103-1322?sv=5-203-9927             | Planning                                          |
      | Warranties, indemnities and transaction issues | /topic/9-103-2067?sv=5-203-9927             | Warranties, Indemnities and Transaction Issues    |
      | Waste                                          | /topic/7-103-1238?sv=5-203-9927             | Waste                                             |
      | Water, marine and flooding                     | /topic/4-201-5564?sv=5-203-9927             | Water, marine and flooding                        |
      | WEEE and RoHS                                  | /topic/2-239-1982?sv=5-203-9927             | WEEE and RoHS                                     |
      | Agriculture & Rural Land                       | /Browse/Home/Practice/AgricultureRuralLand? | Agriculture & Rural Land                          |
      | Planning                                       | /Browse/Home/Practice/Planning              | Planning                                          |

  @PhilTopicsTabDebug12
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "EU Law"
    Then user clicks on Topic Link for EU Law, verify the url and verify the Page Label
      | practiceAreaTopiclink                    | practiceAreaTopicURL              | practiceAreaTopicPageLabel                   |
      | Agriculture                              | /topic/5-529-7569?sv=4-501-5626   | Agriculture: EU                              |
      | Automotive                               | /topic/6-529-7696?sv=4-501-5626   | Automotive: EU                               |
      | Aviation and airports                    | /topic/4-527-7166?sv=4-501-5626   | Aviation and Airports: EU                    |
      | Chemicals and other hazardous substances | /topic/9-529-7572?sv=4-501-5626   | Chemicals and Other Hazardous Substances: EU |
      | Consumer affairs                         | /topic/3-529-7706?sv=4-501-5626   | Consumer Affairs: EU                         |
      | Corporate                                | /topic/4-527-6906?sv=4-501-5626   | Corporate: EU                                |
      | Defence                                  | /topic/4-527-7185?sv=4-501-5626   | Defence: EU                                  |
      | Economic and financial affairs           | /topic/8-527-6985?sv=4-501-5626   | Economic and Financial Affairs: EU           |
      | Employment and social affairs            | /topic/8-527-7065?sv=4-501-5626   | Employment and Social Affairs: EU            |
      | Energy and renewables                    | /topic/5-529-7574?sv=4-501-5626   | Energy and Renewables: EU                    |
      | Enlargement                              | /topic/2-518-2517?sv=4-501-5626   | Enlargement: EU                              |
      | Enterprise and industry                  | /topic/1-504-2382?sv=4-501-5626   | Enterprise and Industry: EU                  |
      | Environment and climate change           | /topic/8-527-7225?sv=4-501-5626   | Environment and Climate Change: EU           |
      | External relations                       | /topic/0-518-2518?sv=4-501-5626   | External Relations: EU                       |
      | Food and food safety                     | /topic/2-527-7266?sv=4-501-5626   | Food and Food Safety: EU                     |
      | Healthcare and life sciences             | /topic/0-529-7576?sv=4-501-5626   | Healthcare and Life Sciences: EU             |
      | Infrastructure funds                     | /topic/6-527-7325?sv=4-501-5626   | Infrastructure Funds: EU                     |
      | Institutional affairs                    | /topic/0-504-2354?sv=4-501-5626   | Institutional Affairs: EU                    |
      | Intellectual property                    | /topic/2-527-7105?sv=4-501-5626   | Intellectual Property: EU                    |
      | Internal market                          | /topic/6-518-2515?sv=4-501-5626   | Internal Market: EU                          |
      | International trade and customs          | /topic/8-529-7577?sv=4-501-5626   | International Trade and Customs: EU          |
      | Justice and home affairs                 | /topic/0-504-4895?sv=4-501-5626   | Justice and Home Affairs: EU                 |
      | Maritime affairs and fisheries           | /topic/4-527-7345?sv=4-501-5626   | Maritime Affairs and Fisheries: EU           |
      | Maritime transport and inland waterways  | /topic/0-527-7366?sv=4-501-5626   | Maritime Transport and Inland Waterways: EU  |
      | Post and logistics                       | /topic/8-527-7386?sv=4-501-5626   | Post and Logistics: EU                       |
      | Product safety                           | /topic/3-529-9545?sv=4-501-5626   | Product safety: EU                           |
      | Public procurement                       | /topic/4-529-7579?sv=4-501-5626   | Public Procurement: EU                       |
      | Rail                                     | /topic/4-527-7406?sv=4-501-5626   | Rail: EU                                     |
      | Regulatory and legislative procedures    | /topic/2-504-4917?sv=4-501-5626   | Regulatory and Legislative Procedures: EU    |
      | Road                                     | /topic/2-527-7426?sv=4-501-5626   | Road: EU                                     |
      | Taxation                                 | /topic/0-527-7125?sv=4-501-5626   | Taxation: EU                                 |
      | Telecommunications, media and technology | /topic/3-527-7505?sv=4-501-5626   | Telecommunications, Media and Technology: EU |
      | Tobacco                                  | /topic/9-527-7526?sv=4-501-5626   | Tobacco: EU                                  |
      | Water                                    | /topic/0-529-7581?sv=4-501-5626   | Water: EU                                    |
      | Competition                              | /Browse/Home/Practice/Competition | Competition                                  |

  @PhilTopicsTabDebug13
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Family"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                         | practiceAreaTopicURL            | practiceAreaTopicPageLabel                                       |
      | Nuptial agreements and relationship planning  | /topic/9-522-3307?sv=5-522-0792 | Nuptial agreements and relationship planning                     |
      | Cohabitation                                  | /topic/4-522-0797?sv=5-522-0792 | Cohabitation                                                     |
      | Family ADR                                    | /topic/1-522-0812?sv=5-522-0792 | Family ADR                                                       |
      | Divorce and dissolution of civil partnership  | /topic/9-522-0813?sv=5-522-0792 | Divorce and dissolution of civil partnership                     |
      | Financial remedies: on divorce or dissolution | /topic/7-522-0814?sv=5-522-0792 | Financial remedies: divorce and dissolution of civil partnership |
      | Children law: financial support               | /topic/9-522-0832?sv=5-522-0792 | Children law: financial support                                  |
      | Children law: private                         | /topic/7-522-0833?sv=5-522-0792 | Children law: private                                            |
      | Children law: public                          | /topic/5-522-0834?sv=5-522-0792 | Children law: public                                             |
      | Domestic violence and personal protection     | /topic/2-522-0835?sv=5-522-0792 | Domestic violence and personal protection                        |
      | International aspects of family law           | /topic/0-522-0836?sv=5-522-0792 | International aspects of family law                              |
      | General contract and boilerplate              | /topic/9-103-1119?sv=5-522-0792 | General Contract and Boilerplate                                 |
      | Legal concepts                                | /topic/3-103-2070?sv=5-522-0792 | Legal Concepts and Miscellaneous                                 |

  @PhilTopicsTabDebug14
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Finance"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink       | practiceAreaTopicURL                          | practiceAreaTopicPageLabel         |
      | Lending: general            | /topic/1-103-2033?sv=3-201-3706               | Lending: General                   |
      | Guarantees                  | /topic/3-380-7404?sv=3-201-3706               | Guarantees                         |
      | Security and quasi security | /topic/6-103-1106?sv=3-201-3706               | Security and Quasi Security        |
      | Acquisition finance         | /topic/7-201-4068?sv=3-201-3706               | Acquisition Finance                |
      | Asset finance               | /topic/5-201-5200?sv=3-201-3706               | Asset Finance                      |
      | Debt capital markets        | /topic/9-103-1100?sv=3-201-3706               | Debt Capital Markets               |
      | Derivatives                 | /topic/4-103-2036?sv=3-201-3706               | Derivatives                        |
      | Islamic finance             | /topic/3-201-5201?sv=3-201-3706               | Islamic Finance                    |
      | Project finance             | /topic/3-201-5282?sv=3-201-3706               | Project Finance                    |
      | Real estate investment      | /topic/9-103-2086?sv=3-201-3706               | Real Estate Finance and Investment |
      | Structured finance          | /topic/8-103-1105?sv=3-201-3706               | Structured Finance                 |
      | Trade finance               | /topic/0-103-1109?sv=3-201-3706               | Trade Finance                      |
      | Regulation: finance         | /topic/4-103-1094?sv=3-201-3706               | Regulation: Finance                |
      | Restructuring & Insolvency  | /Browse/Home/Practice/RestructuringInsolvency | Restructuring & Insolvency         |

  @PhilTopicsTabDebug15
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Financial Services"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                                  | practiceAreaTopicURL            | practiceAreaTopicPageLabel                             |
      | Authorisation                                          | /topic/7-201-5204?sv=8-200-2201 | Authorisation: Financial Services                      |
      | Banking                                                | /topic/7-385-1287?sv=8-200-2201 | Banking                                                |
      | Client assets                                          | /topic/4-201-5205?sv=8-200-2201 | Client Assets: Financial Services                      |
      | Complaints                                             | /topic/9-541-9408?sv=8-200-2201 | Complaints: Financial Services                         |
      | Conduct of business                                    | /topic/2-201-5206?sv=8-200-2201 | Conduct of Business Regime: Financial Services         |
      | Consumer credit                                        | /topic/5-103-1116?sv=8-200-2201 | Consumer Credit                                        |
      | Financial and corporate crime                          | /topic/7-103-1182?sv=8-200-2201 | Financial Crime                                        |
      | Financial promotion and marketing                      | /topic/2-103-1354?sv=8-200-2201 | Financial Promotion and Marketing                      |
      | Individual accountability                              | /topic/9-201-5203?sv=8-200-2201 | Individual accountability                              |
      | Insurance                                              | /topic/2-103-1132?sv=8-200-2201 | Insurance                                              |
      | Investigations and enforcement                         | /topic/6-201-5209?sv=8-200-2201 | Investigations and Enforcement: Financial Services     |
      | Investment funds and asset management                  | /topic/6-103-1352?sv=8-200-2201 | Investment Funds and Asset Management                  |
      | Market conduct                                         | /topic/5-103-1357?sv=8-200-2201 | Market Conduct                                         |
      | Mortgages and home finance                             | /topic/5-541-9486?sv=8-200-2201 | Mortgages and Home Finance: Financial Services         |
      | Payment services                                       | /topic/9-103-2034?sv=8-200-2201 | Payment services                                       |
      | Prudential regulation                                  | /topic/4-201-5210?sv=8-200-2201 | Prudential Regulation                                  |
      | Regulated activities                                   | /topic/2-201-5211?sv=8-200-2201 | Regulated Activities                                   |
      | Regulatory regime                                      | /topic/9-103-1355?sv=8-200-2201 | Regulatory Regime: Financial Services                  |
      | Remuneration                                           | /topic/5-541-9467?sv=8-200-2201 | Remuneration: Financial Services                       |
      | Resolution and compensation                            | /topic/7-541-9485?sv=8-200-2201 | Resolution and Compensation: Financial Services        |
      | Securities, markets and investments                    | /topic/2-541-9505?sv=8-200-2201 | Securities, Markets and Investments                    |
      | Systems and controls                                   | /topic/8-201-5208?sv=8-200-2201 | Systems and controls                                   |
      | Training and competence                                | /topic/0-201-5212?sv=8-200-2201 | Training and Competence: Financial Services            |
      | Listing, prospectus, disclosure and transparency rules | /topic/8-103-2096?sv=8-200-2201 | Listing, Prospectus, Disclosure and Transparency Rules |

  @PhilTopicsTabDebug16
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "IP & IT"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink    | practiceAreaTopicURL                 | practiceAreaTopicPageLabel |
      | Confidentiality          | /topic/7-103-1304?sv=5-103-1753      | Confidentiality            |
      | Copyright                | /topic/0-103-1270?sv=5-103-1753      | Copyright                  |
      | Databases                | /topic/6-103-1272?sv=5-103-1753      | Databases                  |
      | Designs                  | /topic/4-103-1273?sv=5-103-1753      | Designs                    |
      | General IP               | /topic/0-103-2076?sv=5-103-1753      | General IP                 |
      | Passing off              | /topic/4-103-1305?sv=5-103-1753      | Passing Off                |
      | Patents                  | /topic/2-103-1306?sv=5-103-1753      | Patents                    |
      | Research and development | /topic/0-103-1307?sv=5-103-1753      | Research and Development   |
      | Trade marks              | /topic/2-103-2080?sv=5-103-1753      | Trademarks/Trade Marks     |
      | Freedom of information   | /topic/7-201-6246?sv=5-103-1753      | Freedom of Information     |
      | Information technology   | /topic/5-103-2074?sv=5-103-1753      | Information Technology     |
      | Data Protection          | /Browse/Home/Practice/DataProtection | Data Protection            |
      | Media & Telecoms         | /Browse/Home/Practice/MediaTelecoms  | Media & Telecoms           |

  @PhilTopicsTabDebug17
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Local Government"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink               | practiceAreaTopicURL                    | practiceAreaTopicPageLabel              |
      | Children's services                 | /topic/5-522-0834?sv=9-614-3625         | Children law: public                    |
      | Education                           | /topic/9-386-1394?sv=9-614-3625         | Education                               |
      | Adult social services               | /topic/5-540-5390?sv=9-614-3625         | Adult Social Services                   |
      | Health                              | /topic/2-384-2021?sv=9-614-3625         | Health                                  |
      | Mental capacity                     | /topic/8-383-2279?sv=9-614-3625         | Mental Capacity                         |
      | Right to buy                        | /topic/3-103-1320?sv=9-614-3625         | Right to Buy                            |
      | Social housing                      | /topic/3-103-1315?sv=9-614-3625         | Social Housing                          |
      | Access to environmental information | /topic/6-103-1229?sv=9-614-3625         | Access to Environmental Information     |
      | Freedom of information              | /topic/7-201-6246?sv=9-614-3625         | Freedom of Information                  |
      | Decision-making                     | /topic/2-614-6905?sv=9-614-3625         | Decision-making: Local Government       |
      | Enforcement                         | /topic/1-540-5387?sv=9-614-3625         | Enforcement: Local Government           |
      | Governance and powers               | /topic/4-384-2020?sv=9-614-3625         | Governance and powers: local government |
      | Judicial review                     | /topic/5-384-0921?sv=9-614-3625         | Judicial Review                         |
      | Partnership working                 | /topic/2-386-1401?sv=9-614-3625         | Partnership Working                     |
      | General contract and boilerplate    | /topic/9-103-1119?sv=9-614-3625         | General Contract and Boilerplate        |
      | Outsourcing                         | /topic/0-202-2707?sv=9-614-3625         | Outsourcing                             |
      | PFI/PPP                             | /topic/8-384-0910?sv=9-614-3625         | PFI/PPP                                 |
      | Public procurement                  | /topic/7-103-1177?sv=9-614-3625         | Public Procurement                      |
      | Public sector pensions              | /topic/8-501-5587?sv=9-614-3625         | Public-sector Pensions                  |
      | State aid                           | /topic/1-103-1180?sv=9-614-3625         | State Aid                               |
      | TUPE                                | /topic/4-103-1225?sv=9-614-3625         | Transfer of Undertakings                |
      | Data Protection                     | /Browse/Home/Practice/DataProtection    | Data Protection                         |
      | Dispute Resolution                  | /Browse/Home/Practice/DisputeResolution | Dispute Resolution                      |
      | Employment                          | /Browse/Home/Practice/Employment        | Employment                              |
      | Environment                         | /Browse/Home/Practice/Environment       | Environment                             |
      | Planning                            | /Browse/Home/Practice/Planning          | Planning                                |
      | Public Law                          | /Browse/Home/Practice/PublicLaw         | Public Law                              |

  @PhilTopicsTabDebug18
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Media & Telecoms"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink | practiceAreaTopicURL                 | practiceAreaTopicPageLabel |
      | Film                  | /topic/4-525-4283?sv=1-509-3753      | Film                       |
      | General media         | /topic/9-205-8952?sv=1-509-3753      | General Media              |
      | Internet              | /topic/8-383-8686?sv=1-509-3753      | Internet                   |
      | Music                 | /topic/9-525-4285?sv=1-509-3753      | Music                      |
      | Privacy               | /topic/6-383-8687?sv=1-509-3753      | Privacy                    |
      | Social media          | /topic/0-525-4280?sv=1-509-3753      | Social Media               |
      | Telecoms              | /topic/7-205-8953?sv=1-509-3753      | Telecoms                   |
      | TV                    | /topic/2-525-4279?sv=1-509-3753      | TV                         |
      | Data Protection       | /Browse/Home/Practice/DataProtection | Data Protection            |
      | IP & IT               | /Browse/Home/Practice/IPIT           | IP & IT                    |

  @PhilTopicsTabDebug19
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Pensions"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                  | practiceAreaTopicURL            | practiceAreaTopicPageLabel                       |
      | Administering pension schemes          | /topic/8-205-7953?sv=9-204-8963 | Administering Pension Schemes                    |
      | Auto-enrolment and NEST                | /topic/9-500-6436?sv=9-204-8963 | Auto-enrolment and NEST                          |
      | Contracting-out                        | /topic/9-540-5326?sv=9-204-8963 | Contracting-out: Pensions                        |
      | Cross-border                           | /topic/5-200-1613?sv=9-204-8963 | Cross-border: Pensions                           |
      | DC pension schemes                     | /topic/5-540-5328?sv=9-204-8963 | DC Pension Schemes                               |
      | Discrimination                         | /topic/8-379-8242?sv=9-204-8963 | Discrimination: Pensions                         |
      | Early leavers                          | /topic/7-540-5346?sv=9-204-8963 | Early Leavers: Pensions                          |
      | Employer debt                          | /topic/3-540-5367?sv=9-204-8963 | Employer Debt: Pensions                          |
      | Employers                              | /topic/2-308-5967?sv=9-204-8963 | Employers: Pensions                              |
      | Funding and investment                 | /topic/1-205-7956?sv=9-204-8963 | Funding and Investment: Pensions                 |
      | General pensions                       | /topic/1-103-1340?sv=9-204-8963 | General Pensions                                 |
      | Members and benefits                   | /topic/9-103-1341?sv=9-204-8963 | Members and Benefits: Pensions                   |
      | Pension Protection Fund                | /topic/6-379-8238?sv=9-204-8963 | Pension Protection Fund                          |
      | Pension sharing                        | /topic/9-540-5369?sv=9-204-8963 | Pension Sharing                                  |
      | Pensions and employment                | /topic/4-379-8239?sv=9-204-8963 | Pensions and Employment                          |
      | Pensions Regulator                     | /topic/2-379-8240?sv=9-204-8963 | Pensions Regulator                               |
      | Policy and reform                      | /topic/0-103-1345?sv=9-204-8963 | Policy and Reform: Pensions                      |
      | Public-sector pensions                 | /topic/8-501-5587?sv=9-204-8963 | Public-sector Pensions                           |
      | Sales and acquisitions                 | /topic/2-103-1349?sv=9-204-8963 | Sales and Acquisitions: Pensions                 |
      | Scheme documents                       | /topic/9-205-7957?sv=9-204-8963 | Pension Scheme Documents                         |
      | Scheme restructurings and mergers      | /topic/0-379-8241?sv=9-204-8963 | Scheme Restructurings and Mergers: Pensions      |
      | Tax and accounting                     | /topic/8-103-1346?sv=9-204-8963 | Tax and Accounting: Pensions                     |
      | Trustees                               | /topic/4-207-2074?sv=9-204-8963 | Pension Trustees                                 |
      | Winding-up and insolvency              | /topic/5-205-7959?sv=9-204-8963 | Winding-up and Insolvency: Pensions              |
      | Court proceedings                      | /topic/3-380-8696?sv=9-204-8963 | Court Proceedings: Pensions                      |
      | Ombudsmen and tribunals                | /topic/9-380-8698?sv=9-204-8963 | Ombudsmen and Tribunals: Pensions                |
      | Internal dispute resolution procedures | /topic/1-380-8697?sv=9-204-8963 | Internal Dispute Resolution Procedures: Pensions |
      | Challenging the Pensions Regulator     | /topic/9-382-3118?sv=9-204-8963 | Challenging the Pensions Regulator               |
      | Common issues in disputes              | /topic/5-380-8695?sv=9-204-8963 | Common Issues in Disputes: Pensions              |
      | General contract and boilerplate       | /topic/9-103-1119?sv=9-204-8963 | General Contract and Boilerplate                 |

  @PhilTopicsTabDebug20
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Planning"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                                        | practiceAreaTopicURL            | practiceAreaTopicPageLabel                                   |
      | Planning applications                                        | /topic/8-607-5245?sv=4-606-9425 | Planning Applications                                        |
      | Planning permission                                          | /topic/6-607-5246?sv=4-606-9425 | Planning Permission                                          |
      | Planning obligations and Community Infrastructure Levy (CIL) | /topic/4-607-5266?sv=4-606-9425 | Planning Obligations and Community Infrastructure Levy (CIL) |
      | Use classes order                                            | /topic/4-607-5285?sv=4-606-9425 | Use Classes Order                                            |
      | Permitted development                                        | /topic/2-607-5286?sv=4-606-9425 | Permitted Development                                        |
      | Appeals                                                      | /topic/0-607-5287?sv=4-606-9425 | Appeals: Planning                                            |
      | Judicial review                                              | /topic/5-384-0921?sv=4-606-9425 | Judicial Review                                              |
      | Local Government Ombudsman                                   | /topic/6-607-5289?sv=4-606-9425 | Local Government Ombudsman: Planning                         |
      | Enforcement                                                  | /topic/1-607-5625?sv=4-606-9425 | Enforcement: Planning                                        |
      | Advertisements                                               | /topic/3-607-5785?sv=4-606-9425 | Advertisements: Planning                                     |
      | Conservation areas                                           | /topic/1-607-5705?sv=4-606-9425 | Conservation Areas                                           |
      | Listed buildings                                             | /topic/7-607-5665?sv=4-606-9425 | Listed Buildings                                             |
      | Nationally Significant Infrastructure Projects (NSIPs)       | /topic/5-607-5765?sv=4-606-9425 | Nationally Significant Infrastructure Projects (NSIPs)       |
      | Protected Trees                                              | /topic/7-607-5745?sv=4-606-9425 | Protected Trees                                              |
      | Scheduled monuments                                          | /topic/9-607-5725?sv=4-606-9425 | Scheduled Monuments                                          |
      | Compulsory purchase and appropriation                        | /topic/1-103-2085?sv=4-606-9425 | Compulsory Purchase and Appropriation                        |
      | Environmental impact assessment                              | /topic/1-200-2228?sv=4-606-9425 | Environmental Impact Assessments                             |
      | Highways                                                     | /topic/6-103-1314?sv=4-606-9425 | Highways                                                     |
      | Policy framework                                             | /topic/1-607-5885?sv=4-606-9425 | Policy Framework: Planning                                   |

  @PhilTopicsTabDebug21
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Private Client"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink            | practiceAreaTopicURL                                | practiceAreaTopicPageLabel       |
      | Lifetime planning                | /topic/1-383-2273?sv=2-383-9212                     | Lifetime Planning                |
      | Wills                            | /topic/6-383-2275?sv=2-383-9212                     | Wills                            |
      | Mental capacity                  | /topic/8-383-2279?sv=2-383-9212                     | Mental Capacity                  |
      | After death                      | /topic/8-383-2284?sv=2-383-9212                     | After Death                      |
      | Trusts                           | /topic/0-383-2283?sv=2-383-9212                     | Trusts                           |
      | Owner-managed businesses         | /topic/7-376-4394?sv=2-383-9212                     | Owner-managed Businesses         |
      | International individuals        | /topic/5-383-2285?sv=2-383-9212                     | International Individuals        |
      | Charities                        | /topic/3-383-2286?sv=2-383-9212                     | Charities                        |
      | Contentious private client       | /topic/3-540-5386?sv=2-383-9212                     | Contentious Private Client       |
      | Private Client Global Guide      | /Browse/Home/International/PrivateClientGlobalGuide | Private Client Global Guide      |
      | General contract and boilerplate | /topic/9-103-1119?sv=2-383-9212                     | General Contract and Boilerplate |
      | Legal concepts                   | /topic/3-103-2070?sv=2-383-9212                     | Legal Concepts and Miscellaneous |
      | Family                           | /Browse/Home/Practice/Family                        | Family                           |
      | Tax                              | /Browse/Home/Practice/Tax                           | Tax                              |
      | Share Schemes & Incentives       | /Browse/Home/Practice/ShareSchemesIncentives        | Share Schemes & Incentives       |
      | Property                         | /Browse/Home/Practice/Property                      | Property                         |

  @PhilTopicsTabDebug22
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Property"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                               | practiceAreaTopicURL                       | practiceAreaTopicPageLabel                                              |
      | Title issues                                        | /topic/6-103-1328?sv=7-103-1771            | Title Issues                                                            |
      | Common land, town and village greens                | /topic/2-200-1662?sv=7-103-1771            | Common Land, Town and Village Greens                                    |
      | Easements, covenants and other third party rights   | /topic/6-103-2083?sv=7-103-1771            | Easements, Covenants and Other Third Party Rights                       |
      | Conveyancing procedure                              | /topic/8-103-2082?sv=7-103-1771            | Conveyancing Procedure                                                  |
      | Contracts and transfers                             | /topic/4-103-1310?sv=7-103-1771            | Contracts and Transfers: Land and Buildings                             |
      | Land registration                                   | /topic/9-103-1317?sv=7-103-1771            | Land Registration                                                       |
      | Charity transactions                                | /topic/2-607-3145?sv=7-103-1771            | Charity Transactions: Land and Buildings                                |
      | Insolvency                                          | /topic/1-103-1316?sv=7-103-1771            | Property: Restructuring and Insolvency                                  |
      | Assignments, variations, surrenders and termination | /topic/7-609-7865?sv=7-103-1771            | Assignments, Variations, Surrenders and Termination: Land and Buildings |
      | Business tenancies (non-contentious)                | /topic/4-607-3385?sv=7-103-1771            | Business Tenancies (Non-contentious)                                    |
      | Estate management and licences                      | /topic/0-607-3325?sv=7-103-1771            | Estate Management and Licences                                          |
      | Guarantees                                          | /topic/0-607-3306?sv=7-103-1771            | Guarantees: Land and Buildings                                          |
      | Leases and licences to occupy                       | /topic/8-607-3265?sv=7-103-1771            | Leases and Licences to Occupy                                           |
      | Residential tenancies                               | /topic/8-607-3345?sv=7-103-1771            | Residential Tenancies                                                   |
      | Development                                         | /topic/0-103-1312?sv=7-103-1771            | Development                                                             |
      | Options, pre-emptions and overage                   | /topic/8-607-3406?sv=7-103-1771            | Options, Pre-emptions and Overage                                       |
      | Corporate support                                   | /topic/2-103-1311?sv=7-103-1771            | Corporate Support: Land and Buildings                                   |
      | Mortgages and security                              | /topic/1-103-1321?sv=7-103-1771            | Mortgages and Security: Land and Buildings                              |
      | Real estate finance and investment                  | /topic/9-103-2086?sv=7-103-1771            | Real Estate Finance and Investment                                      |
      | Tax                                                 | /topic/8-103-1394?sv=7-103-1771            | Taxation: Land and Buildings                                            |
      | Energy and buildings                                | /topic/9-206-1006?sv=7-103-1771            | Energy and Buildings                                                    |
      | Sustainability                                      | /topic/4-607-3465?sv=7-103-1771            | Sustainability                                                          |
      | Utilities                                           | /topic/4-103-1329?sv=7-103-1771            | Utilities                                                               |
      | Insurance                                           | /topic/2-103-1132?sv=7-103-1771            | Insurance                                                               |
      | Professional conduct                                | /topic/1-103-2071?sv=7-103-1771            | Professional Conduct                                                    |
      | Statutory liabilities                               | /topic/8-103-1327?sv=7-103-1771            | Statutory Liabilities: Land and Buildings                               |
      | Agriculture & Rural Land                            | /Browse/Home/Practice/AgricultureRuralLand | Agriculture & Rural Land                                                |
      | Planning                                            | /Browse/Home/Practice/Planning             | Planning                                                                |
      | Property Litigation                                 | /Browse/Home/Practice/PropertyLitigation   | Property Litigation                                                     |

  @PhilTopicsTabDebug23
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Property Litigation"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                     | practiceAreaTopicURL                    | practiceAreaTopicPageLabel                   |
      | Breach of lease covenants                 | /topic/1-607-4485?sv=8-606-9466         | Breach of Lease Covenants                    |
      | Break notices                             | /topic/2-607-4545?sv=8-606-9466         | Break Notices: Land and Buildings            |
      | Business tenancies (contentious)          | /topic/0-607-4565?sv=8-606-9466         | Business Tenancies (Contentious)             |
      | Dilapidations                             | /topic/4-607-4907?sv=8-606-9466         | Dilapidations                                |
      | Forfeiture                                | /topic/0-607-5027?sv=8-606-9466         | Forfeiture                                   |
      | Rent, non-payment of rent and rent review | /topic/0-607-5046?sv=8-606-9466         | Rent, Non-payment of Rent and Rent Review    |
      | Service charges                           | /topic/8-607-5085?sv=8-606-9466         | Service Charges: Land and Buildings          |
      | Assured shorthold tenancies               | /topic/3-607-4446?sv=8-606-9466         | Assured Shorthold Tenancies                  |
      | Enfranchisement and lease extensions      | /topic/2-607-5007?sv=8-606-9466         | Enfranchisement and Lease Extensions         |
      | Right of first refusal                    | /topic/0-607-5070?sv=8-606-9466         | Right of First Refusal: Land and Buildings   |
      | Tenancy deposit schemes                   | /topic/4-607-5105?sv=8-606-9466         | Tenancy Deposit Schemes                      |
      | Party walls                               | /topic/6-607-5185?sv=8-606-9466         | Party Walls                                  |
      | Rights of light                           | /topic/0-607-5206?sv=8-606-9466         | Rights of Light                              |
      | Enforcement and remedies                  | /topic/8-103-1313?sv=8-606-9466         | Enforcement and Remedies: Land and Buildings |
      | Possession of land and buildings          | /topic/2-607-5187?sv=8-606-9466         | Possession of Land and Buildings             |
      | Trespass                                  | /topic/8-607-5207?sv=8-606-9466         | Trespass                                     |
      | Property                                  | /Browse/Home/Practice/Property          | Property                                     |
      | Dispute Resolution                        | /Browse/Home/Practice/DisputeResolution | Dispute Resolution                           |

  @PhilTopicsTabDebug24
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Public Law"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink               | practiceAreaTopicURL                  | practiceAreaTopicPageLabel          |
      | Executive and legislative powers    | /topic/8-614-6865?sv=9-527-9785       | Executive and legislative powers    |
      | Exercising statutory powers         | /topic/6-384-2019?sv=9-527-9785       | Exercising statutory powers         |
      | Judicial review                     | /topic/5-384-0921?sv=9-527-9785       | Judicial Review                     |
      | Statutory construction              | /topic/4-103-1254?sv=9-527-9785       | Statutory Construction              |
      | Equality                            | /topic/3-540-5391?sv=9-527-9785       | Equality                            |
      | Human rights                        | /topic/6-103-1253?sv=9-527-9785       | Human Rights                        |
      | Access to environmental information | /topic/6-103-1229?sv=9-527-9785       | Access to Environmental Information |
      | Freedom of information              | /topic/7-201-6246?sv=9-527-9785       | Freedom of Information              |
      | General contract and boilerplate    | /topic/9-103-1119?sv=9-527-9785       | General Contract and Boilerplate    |
      | Outsourcing                         | /topic/0-202-2707?sv=9-527-9785       | Outsourcing                         |
      | PFI/PPP                             | /topic/8-384-0910?sv=9-527-9785       | PFI/PPP                             |
      | Public procurement                  | /topic/7-103-1177?sv=9-527-9785       | Public Procurement                  |
      | Public sector pensions              | /topic/8-501-5587?sv=9-527-9785       | Public-sector Pensions              |
      | State aid                           | /topic/1-103-1180?sv=9-527-9785       | State Aid                           |
      | TUPE                                | /topic/4-103-1225?sv=9-527-9785       | Transfer of Undertakings            |
      | Data Protection                     | /Browse/Home/Practice/DataProtection  | Data Protection                     |
      | EU Law                              | /Browse/Home/Practice/EULaw           | EU Law                              |
      | Local Government                    | /Browse/Home/Practice/LocalGovernment | Local Government                    |

  @PhilTopicsTabDebug25
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Restructuring & Insolvency"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                     | practiceAreaTopicURL            | practiceAreaTopicPageLabel                            |
      | Court proceedings                         | /topic/7-540-5426?sv=1-381-9653 | Court Proceedings: Restructuring and Insolvency       |
      | Directors and employees                   | /topic/7-103-1257?sv=1-381-9653 | Directors and Employees: Restructuring and Insolvency |
      | Pensions issues                           | /topic/5-205-7959?sv=1-381-9653 | Winding-up and Insolvency: Pensions                   |
      | Property issues                           | /topic/1-103-1316?sv=1-381-9653 | Property: Restructuring and Insolvency                |
      | Restructuring and insolvency transactions | /topic/4-103-1268?sv=1-381-9653 | Restructuring and Insolvency Transactions             |
      | Reviewable transactions                   | /topic/6-103-1267?sv=1-381-9653 | Reviewable Transactions                               |
      | Tax issues                                | /topic/7-385-2121?sv=1-381-9653 | Restructuring and Insolvency: Tax                     |
      | Administration                            | /topic/9-103-1256?sv=1-381-9653 | Administration                                        |
      | Company voluntary arrangements            | /topic/9-540-5425?sv=1-381-9653 | Company Voluntary Arrangements                        |
      | Dissolution, strike off and restoration   | /topic/1-540-5405?sv=1-381-9653 | Dissolution, Strike off and Restoration               |
      | Liquidation                               | /topic/1-103-1260?sv=1-381-9653 | Liquidation                                           |
      | Receivership                              | /topic/0-386-1402?sv=1-381-9653 | Receivership                                          |
      | Schemes of arrangement                    | /topic/3-540-5409?sv=1-381-9653 | Schemes of Arrangement: Restructuring and Insolvency  |

  @PhilTopicsTabDebug26
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Share Schemes & Incentives"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                 | practiceAreaTopicURL            | practiceAreaTopicPageLabel                        |
      | EMI options                           | /topic/9-318-9952?sv=1-204-8962 | EMI Options                                       |
      | CSOP/SAYE/SIPs                        | /topic/6-319-0952?sv=1-204-8962 | CSOP/SAYE/SIPs                                    |
      | Taxable share schemes and agreements  | /topic/4-319-0953?sv=1-204-8962 | Taxable Share Schemes and Arrangements            |
      | Accounting, finance and scheme design | /topic/8-205-7175?sv=1-204-8962 | Accounting, Finance and Scheme Design: Incentives |
      | Employee benefit trusts               | /topic/9-205-7170?sv=1-204-8962 | Employee Benefit Trusts                           |
      | Cash-based employee incentive schemes | /topic/5-205-7167?sv=1-204-8962 | Cash-based Employee Incentive Schemes             |
      | Tax and NICs                          | /topic/6-205-7176?sv=1-204-8962 | Tax and NICs: Incentives                          |
      | Company law and corporate governance  | /topic/3-205-7168?sv=1-204-8962 | Company Law and Corporate Governance: Incentives  |
      | Regulatory matters                    | /topic/3-540-5428?sv=1-204-8962 | Regulatory Matters: Incentives                    |
      | Corporate transactions                | /topic/1-205-7169?sv=1-204-8962 | Corporate Transactions: Incentives                |
      | Employment law issues                 | /topic/7-205-7171?sv=1-204-8962 | Employment Law Issues: Incentives                 |
      | General contract and boilerplate      | /topic/9-103-1119?sv=1-204-8962 | General Contract and Boilerplate                  |
      | Legal concepts                        | /topic/3-103-2070?sv=1-204-8962 | Legal Concepts and Miscellaneous                  |

  @PhilTopicsTabDebug27
  Scenario: Verify the Topics Tab functionality for each Practice Area page
    When the user is on the home page
    When navigates to the Practice Area "Tax"
    Then user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label
      | practiceAreaTopiclink                    | practiceAreaTopicURL            | practiceAreaTopicPageLabel                    |
      | Companies and groups                     | /topic/3-540-5447?sv=5-378-8744 | Companies and Groups: Tax                     |
      | Asset acquisitions                       | /topic/5-103-1079?sv=5-378-8744 | Asset Acquisitions                            |
      | Equity capital markets                   | /topic/5-540-5446?sv=5-378-8744 | Equity Capital Markets: Tax                   |
      | Joint ventures                           | /topic/8-103-1308?sv=5-378-8744 | Joint Ventures                                |
      | Private equity and venture capital       | /topic/0-103-1350?sv=5-378-8744 | Private Equity and Venture Capital            |
      | Share acquisitions                       | /topic/1-540-5429?sv=5-378-8744 | Share Acquisitions: Tax                       |
      | Cross-border                             | /topic/2-103-1387?sv=5-378-8744 | Cross-border: Tax                             |
      | Anti-avoidance                           | /topic/6-376-4380?sv=5-378-8744 | Anti-avoidance: Tax                           |
      | Disputes and investigations              | /topic/2-376-3556?sv=5-378-8744 | Disputes and Investigations: Tax              |
      | Cross-border and immigration             | /topic/6-382-8829?sv=5-378-8744 | Cross-border and Immigration                  |
      | Employment income, pensions and benefits | /topic/4-376-4395?sv=5-378-8744 | Employment Income, Pensions and Benefits: Tax |
      | Employment status and self-employment    | /topic/2-382-8831?sv=5-378-8744 | Employment Status and Independent Contractors |
      | National Insurance Contributions         | /topic/8-103-2100?sv=5-378-8744 | National Insurance Contributions              |
      | Termination of employment                | /topic/1-103-1222?sv=5-378-8744 | Termination of Employment                     |
      | Energy and environment                   | /topic/7-376-3554?sv=5-378-8744 | Energy and Environment: Tax                   |
      | Asset finance                            | /topic/5-201-5200?sv=5-378-8744 | Asset Finance                                 |
      | Cross-border: finance                    | /topic/7-200-1612?sv=5-378-8744 | Cross-border: Finance                         |
      | Debt capital markets                     | /topic/9-103-1100?sv=5-378-8744 | Debt Capital Markets                          |
      | Derivatives                              | /topic/4-103-2036?sv=5-378-8744 | Derivatives                                   |
      | Islamic finance                          | /topic/3-201-5201?sv=5-378-8744 | Islamic Finance                               |
      | Lending: general                         | /topic/1-103-2033?sv=5-378-8744 | Lending: General                              |
      | Structured finance                       | /topic/8-103-1105?sv=5-378-8744 | Structured Finance                            |
      | Investment funds and asset management    | /topic/6-103-1352?sv=5-378-8744 | Investment Funds and Asset Management         |
      | IP and IT                                | /topic/1-376-3552?sv=5-378-8744 | IP and IT: Tax                                |
      | Owner-managed businesses                 | /topic/7-376-4394?sv=5-378-8744 | Owner-managed Businesses                      |
      | Partnerships and LLPs                    | /topic/5-103-2045?sv=5-378-8744 | Partnerships and LLPs                         |
      | Development and construction             | /topic/0-103-1312?sv=5-378-8744 | Development                                   |
      | Landlord and tenant                      | /topic/7-103-1318?sv=5-378-8744 | Landlord and Tenant: Tax                      |
      | Real estate finance and investment       | /topic/9-103-2086?sv=5-378-8744 | Real Estate Finance and Investment            |
      | Stamp duty land tax                      | /topic/5-376-3550?sv=5-378-8744 | Stamp Duty Land Tax                           |
      | Dividends and distributions              | /topic/4-376-3555?sv=5-378-8744 | Dividends and Distributions: Tax              |
      | Reorganisations, schemes and demergers   | /topic/8-103-1153?sv=5-378-8744 | Reorganisations, Schemes and Demergers        |
      | Buybacks and other returns of value      | /topic/7-103-2054?sv=5-378-8744 | Returns of value                              |
      | Restructuring and insolvency             | /topic/7-385-2121?sv=5-378-8744 | Restructuring and Insolvency: Tax             |
      | Stamp duty and SDRT                      | /topic/3-376-3551?sv=5-378-8744 | Stamp Duty and SDRT                           |
      | VAT                                      | /topic/9-376-3548?sv=5-378-8744 | VAT                                           |
      | Professional conduct                     | /topic/1-103-2071?sv=5-378-8744 | Professional Conduct                          |
      | Taxes, clearances and concepts           | /topic/9-376-4393?sv=5-378-8744 | Taxes, clearances and concepts                |
      | Contract and boilerplate                 | /topic/9-103-1119?sv=5-378-8744 | General Contract and Boilerplate              |
      | Legal concepts                           | /topic/3-103-2070?sv=5-378-8744 | Legal Concepts and Miscellaneous              |

