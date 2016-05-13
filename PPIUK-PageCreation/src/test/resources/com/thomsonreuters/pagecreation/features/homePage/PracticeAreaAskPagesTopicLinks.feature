@wip
Feature: To verify all the topic links for all the Practice area ASK pages

  Background:
    Given PL+ user is logged in
    And The user clicks the Home page tab link "Resources"
    And clicks on Ask link

  Scenario: Scenario to verify the topic links on 'Ask:Agriculture & Rural Land' Practice area page

    When the user clicks link 'Agriculture & Rural Land' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                          | TopicPLCRef              |
      | Agricultural finance                               | 1-607-6333?sv=4-606-9406 |
      | Agricultural holdings                              | 4-607-6586?sv=4-606-9406 |
      | Agricultural licences                              | 6-607-6665?sv=4-606-9406 |
      | Buying and selling rural land                      | 3-607-6346?sv=4-606-9406 |
      | Common agricultural policy (CAP)                   | 4-607-6666?sv=4-606-9406 |
      | Direct payment schemes: agriculture and rural land | 4-607-6685?sv=4-606-9406 |
      | EU agriculture                                     | 3-607-6365?sv=4-606-9406 |
      | Easements, covenants and other third party rights  | 6-103-2083?sv=4-606-9406 |
      | Environmental land management schemes              | 2-607-6686?sv=4-606-9406 |
      | Equestrian                                         | 6-607-6378?sv=4-606-9406 |
      | Farm business tenancies                            | 8-607-6626?sv=4-606-9406 |
      | Farm dwellings                                     | 8-607-6645?sv=4-606-9406 |
      | Farm partnerships and farming agreements           | 9-607-6428?sv=4-606-9406 |
      | Forestry                                           | 8-607-6706?sv=4-606-9406 |
      | Rural environmental issues                         | 6-607-6726?sv=4-606-9406 |
      | Rural planning issues                              | 2-607-6747?sv=4-606-9406 |
      | Sporting rights: agriculture & rural land          | 9-607-6466?sv=4-606-9406 |
      | Tax planning for agriculture and landed estates    | 7-607-6486?sv=4-606-9406 |

  Scenario: Scenario to verify the topic links on 'Ask:Commercial' Practice area page

    When the user clicks link 'Commercial' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                        | TopicPLCRef              |
      | Advertising and marketing        | 0-103-1114?sv=1-379-8575 |
      | Agency                           | 7-103-1115?sv=1-379-8575 |
      | Bailment and leasing             | 0-505-0382?sv=1-379-8575 |
      | Confidentiality                  | 7-103-1304?sv=1-379-8575 |
      | Consumer                         | 0-103-2038?sv=1-379-8575 |
      | Distribution                     | 6-103-1130?sv=1-379-8575 |
      | E-commerce                       | 2-103-1274?sv=1-379-8575 |
      | Franchising                      | 4-103-1131?sv=1-379-8575 |
      | General commercial               | 7-379-8563?sv=1-379-8575 |
      | General contract and boilerplate | 9-103-1119?sv=1-379-8575 |
      | Outsourcing                      | 0-202-2707?sv=1-379-8575 |
      | Preliminary agreements           | 9-103-1138?sv=1-379-8575 |
      | Supply of goods and service      | 0-103-1128?sv=1-379-8575 |

  Scenario: Scenario to verify the topic links on 'Ask:Construction' Practice area page

    When the user clicks link 'Construction' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                 | TopicPLCRef              |
      | Building contracts and contractors        | 1-381-2944?sv=4-383-5821 |
      | Engineering contracts                     | 6-381-2946?sv=4-383-5821 |
      | General contract and boilerplate          | 9-103-1119?sv=4-383-5821 |
      | Insurance                                 | 2-103-1132?sv=4-383-5821 |
      | International construction contracts      | 4-381-2947?sv=4-383-5821 |
      | Professional appointments and liabilities | 8-381-2950?sv=4-383-5821 |
      | Adjudication: ADR                         | 3-204-9135?sv=4-383-5821 |
      | Construction ADR                          | 0-381-2954?sv=4-383-5821 |
      | Construction arbitration                  | 7-381-2955?sv=4-383-5821 |
      | Construction litigation                   | 5-381-2956?sv=4-383-5821 |
      | Project finance                           | 3-201-5282?sv=4-383-5821 |
      | Real estate finance and investment        | 9-103-2086?sv=4-383-5821 |
      | Procurement                               | 0-381-2949?sv=4-383-5821 |
      | Public procurement                        | 7-103-1177?sv=4-383-5821 |
      | Collateral warranties and third parties   | 2-381-2953?sv=4-383-5821 |
      | Development documents                     | 8-381-2945?sv=4-383-5821 |
      | Regeneration                              | 6-381-2951?sv=4-383-5821 |
      | Sustainability and environment            | 4-381-2952?sv=4-383-5821 |
      | Health and safety                         | 3-200-1671?sv=4-383-5821 |
      | Insolvency                                | 1-103-1316?sv=4-383-5821 |
      | Statutory liabilities: land and buildings | 8-103-1327?sv=4-383-5821 |
      | Taxation                                  | 8-103-1394?sv=4-383-5821 |

  Scenario: Scenario to verify the topic links on 'Ask:Corporate' Practice area page

    When the user clicks link 'Corporate' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                              | TopicPLCRef              |
      | Acquisitions: auctions                                 | 3-103-1080?sv=3-103-1749 |
      | Asset acquisitions                                     | 5-103-1079?sv=3-103-1749 |
      | Cross-border acquisitions                              | 9-103-1077?sv=3-103-1749 |
      | Share acquisitions: private                            | 1-103-1081?sv=3-103-1749 |
      | Public mergers & acquisitions                          | 7-103-1083?sv=3-103-1749 |
      | Joint ventures                                         | 8-103-1308?sv=3-103-1749 |
      | Private equity and venture capital                     | 0-103-1350?sv=3-103-1749 |
      | Reorganisations, schemes and demergers                 | 8-103-1153?sv=3-103-1749 |
      | Returns of value                                       | 7-103-2054?sv=3-103-1749 |
      | Company Law                                            | 7-103-1144?sv=3-103-1749 |
      | Company administration and meetings                    | 4-103-1145?sv=3-103-1749 |
      | Company formation and constitution                     | 2-103-1146?sv=3-103-1749 |
      | Corporate governance                                   | 8-103-1148?sv=3-103-1749 |
      | Cross-border: company law and corporate governance     | 8-200-1621?sv=3-103-1749 |
      | Directors                                              | 7-200-0622?sv=3-103-1749 |
      | Miscellaneous: company law                             | 8-200-1621?sv=3-103-1749 |
      | Financial and narrative reporting                      | 3-103-1240?sv=3-103-1749 |
      | Share capital: structure, allotment and transfers      | 9-103-1157?sv=3-103-1749 |
      | Shareholder rights and remedies                        | 6-103-1154?sv=3-103-1749 |
      | AIM                                                    | 1-103-1364?sv=3-103-1749 |
      | Initial public offerings                               | 3-103-1377?sv=3-103-1749 |
      | Listing, prospectus, disclosure and transparency rules | 8-103-2096?sv=3-103-1749 |
      | Rights issues and other secondary issues               | 0-103-2095?sv=3-103-1749 |
      | Financial promotion                                    | 2-103-1354?sv=3-103-1749 |
      | Market conduct                                         | 5-103-1357?sv=3-103-1749 |
      | US securities law: for non - US companies              | 9-201-5199?sv=3-103-1749 |
      | Partnership and LLP's                                  | 5-103-2045?sv=3-103-1749 |
      | Owner-managed businesses                               | 7-376-4394?sv=3-103-1749 |
      | Financial Crime                                        | 7-103-1182?sv=3-103-1749 |
      | General contract and boilerplate                       | 9-103-1119?sv=3-103-1749 |


  Scenario: Scenario to verify the topic links on 'Ask:Data Protection' Practice area page

    When the user clicks link 'Data Protection' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                    | TopicPLCRef              |
      | Compliance                   | 1-616-6178?sv=1-614-3506 |
      | Cookies                      | 5-616-6218?sv=1-614-3506 |
      | Data security                | 8-616-6189?sv=1-614-3506 |
      | Data sharing                 | 2-616-6187?sv=1-614-3506 |
      | Direct marketing             | 9-616-6179?sv=1-614-3506 |
      | Employee data and monitoring | 5-200-0623?sv=1-614-3506 |
      | EU data protection reform    | 7-616-6199?sv=1-614-3506 |
      | Exporting personal data      | 2-616-6192?sv=1-614-3506 |
      | General                      | 1-616-6550?sv=1-614-3506 |
      | Rights of data subjects      | 6-616-6190?sv=1-614-3506 |
      | Sanctions and remedies       | 0-616-6193?sv=1-614-3506 |
      | Surveillance                 | 7-616-6222?sv=1-614-3506 |
      | Technology                   | 8-616-6207?sv=1-614-3506 |
      | Transactions                 | 5-616-6195?sv=1-614-3506 |

  Scenario: Scenario to verify the topic links on 'Ask:Dispute Resolution' Practice area page

    When the user clicks link 'Dispute Resolution' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                        | TopicPLCRef              |
      | Pre-action conduct               | 9-203-6804?sv=1-203-9929 |
      | Funding                          | 5-381-9613?sv=1-203-9929 |
      | Jurisdiction and cross-border    | 3-103-1202?sv=1-203-9929 |
      | Limitation                       | 1-103-1203?sv=1-203-9929 |
      | Security for costs               | 4-203-6806?sv=1-203-9929 |
      | Injunctive relief                | 7-203-6800?sv=1-203-9929 |
      | Starting a claim                 | 3-381-9614?sv=1-203-9929 |
      | Service                          | 2-203-6807?sv=1-203-9929 |
      | Responding to a claim            | 7-381-7646?sv=1-203-9929 |
      | Statements of case               | 6-203-6810?sv=1-203-9929 |
      | Interim applications             | 5-203-6801?sv=1-203-9929 |
      | Early determination              | 5-203-6797?sv=1-203-9929 |
      | Case management                  | 2-203-6794?sv=1-203-9929 |
      | Disclosure                       | 4-103-1193?sv=1-203-9929 |
      | Evidence                         | 5-103-1197?sv=1-203-9929 |
      | Experts                          | 3-203-6798?sv=1-203-9929 |
      | Settlement and Part 36           | 0-203-6808?sv=1-203-9929 |
      | Trial                            | 4-203-6811?sv=1-203-9929 |
      | Costs                            | 1-203-6799?sv=1-203-9929 |
      | Appeals                          | 4-203-6793?sv=1-203-9929 |
      | Enforcement                      | 7-204-0010?sv=1-203-9929 |
      | Insolvency litigation            | 7-540-5426?sv=1-203-9929 |
      | Judicial review                  | 5-384-0921?sv=1-203-9929 |
      | Adjudication                     | 3-204-9135?sv=1-203-9929 |
      | Early neutral evaluation         | 1-204-9141?sv=1-203-9929 |
      | Expert determination             | 7-204-9138?sv=1-203-9929 |
      | Mediation                        | 1-204-9136?sv=1-203-9929 |
      | Dispute resolution clauses       | 1-540-5207?sv=1-203-9929 |
      | General contract and boilerplate | 9-103-1119?sv=1-203-9929 |
      | Remedies                         | 8-103-1214?sv=1-203-9929 |
      | Substantive law                  | 6-204-9134?sv=1-203-9929 |
      | Tort                             | 1-540-5226?sv=1-203-9929 |

  Scenario: Scenario to verify the topic links on 'Ask:Employment' Practice area page

    When the user clicks link 'Employment' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                             | TopicPLCRef              |
      | ADR                                                   | 7-382-7457?sv=0-200-2200 |
      | Atypical working                                      | 5-200-0618?sv=0-200-2200 |
      | Civil litigation                                      | 1-540-5245?sv=0-200-2200 |
      | Collective consultation                               | 1-200-0620?sv=0-200-2200 |
      | Contracts of employment                               | 9-103-1223?sv=0-200-2200 |
      | Cross-border and immigration                          | 6-382-8829?sv=0-200-2200 |
      | Directors                                             | 7-200-0622?sv=0-200-2200 |
      | Directors and employees: restructuring and insolvency | 7-103-1257?sv=0-200-2200 |
      | Discipline and performance management                 | 9-540-5246?sv=0-200-2200 |
      | Discrimination                                        | 4-382-8830?sv=0-200-2200 |
      | Employee data, monitoring and privacy                 | 5-200-0623?sv=0-200-2200 |
      | Employment appeal tribunal                            | 3-382-7459?sv=0-200-2200 |
      | Employment status and independent contractors         | 2-382-8831?sv=0-200-2200 |
      | Employment tribunals                                  | 1-382-7460?sv=0-200-2200 |
      | Equal pay                                             | 0-382-8832?sv=0-200-2200 |
      | Families and Pregnancy                                | 7-200-0617?sv=0-200-2200 |
      | General contract and boilerplate                      | 9-103-1119?sv=0-200-2200 |
      | Grievances                                            | 3-540-5249?sv=0-200-2200 |
      | Partnerships and LLPs                                 | 5-103-2045?sv=0-200-2200 |
      | Pay and benefits                                      | 0-200-0630?sv=0-200-2200 |
      | Policies and procedures                               | 9-382-7461?sv=0-200-2200 |
      | Recruitment                                           | 8-200-0626?sv=0-200-2200 |
      | Redundancy and business reorganisation                | 3-200-0619?sv=0-200-2200 |
      | Restraint of trade, Confidentiality and IP            | 2-103-2061?sv=0-200-2200 |
      | Sickness and incapacity                               | 6-200-0627?sv=0-200-2200 |
      | Taxation                                              | 4-200-0628?sv=0-200-2200 |
      | Termination of employment                             | 1-103-1222?sv=0-200-2200 |
      | Transfer of shares                                    | 7-103-1224?sv=0-200-2200 |
      | Transfer of undertakings                              | 4-103-1225?sv=0-200-2200 |
      | Unfair dismissal                                      | 5-540-5248?sv=0-200-2200 |
      | Unions                                                | 8-103-2063?sv=0-200-2200 |
      | Whistleblowing                                        | 8-200-0631?sv=0-200-2200 |
      | Working time and time off                             | 2-103-1226?sv=0-200-2200 |
      | Legal concepts and miscellaneous                      | 3-103-2070?sv=0-200-2200 |
      | Conflicts of interest                                 | 7-103-1988?sv=0-200-2200 |
      | Conspiracy                                            | 2-103-1250?sv=0-200-2200 |
      | Cross-border: legal concepts                          | 7-200-1626?sv=0-200-2200 |
      | Deceit                                                | 0-103-1251?sv=0-200-2200 |
      | Defamation                                            | 8-103-1252?sv=0-200-2200 |
      | Human rights                                          | 6-103-1253?sv=0-200-2200 |
      | Miscellaneous: legal concepts                         | 9-200-1625?sv=0-200-2200 |
      | Negligence                                            | 7-103-0818?sv=0-200-2200 |
      | Professional conduct                                  | 1-103-2071?sv=0-200-2200 |
      | Statutory construction                                | 4-103-1254?sv=0-200-2200 |
      | Trusts and fiduciary relationships                    | 1-103-1255?sv=0-200-2200 |

  Scenario: Scenario to verify the topic links on 'Ask:Family' Practice area page

    When the user clicks link 'Family' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                     | TopicPLCRef              |
      | Nuptial agreements and relationship planning  | 9-522-3307?sv=5-522-0792 |
      | Cohabitation                                  | 4-522-0797?sv=5-522-0792 |
      | Family ADR                                    | 1-522-0812?sv=5-522-0792 |
      | Divorce and dissolution of civil partnership  | 9-522-0813?sv=5-522-0792 |
      | Financial remedies: on divorce or dissolution | 7-522-0814?sv=5-522-0792 |
      | Children law: financial support               | 9-522-0832?sv=5-522-0792 |
      | Children law: private                         | 7-522-0833?sv=5-522-0792 |
      | Children law: public                          | 5-522-0834?sv=5-522-0792 |
      | Domestic violence and personal protection     | 2-522-0835?sv=5-522-0792 |
      | International aspects of family law           | 0-522-0836?sv=5-522-0792 |
      | General contract and boilerplate              | 9-103-1119?sv=5-522-0792 |
      | Legal concepts                                | 3-103-2070?sv=5-522-0792 |

  Scenario: Scenario to verify the topic links on 'Ask:Finance' Practice area page

    When the user clicks link 'Finance' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                          | TopicPLCRef              |
      | Acquisition finance                | 7-201-4068?sv=3-201-3706 |
      | Asset finance                      | 5-201-5200?sv=3-201-3706 |
      | Debt capital markets               | 9-103-1100?sv=3-201-3706 |
      | Derivatives                        | 4-103-2036?sv=3-201-3706 |
      | Guarantees                         | 3-380-7404?sv=3-201-3706 |
      | Islamic finance                    | 3-201-5201?sv=3-201-3706 |
      | Lending: general                   | 1-103-2033?sv=3-201-3706 |
      | Project finance                    | 3-201-5282?sv=3-201-3706 |
      | Real estate finance and investment | 9-103-2086?sv=3-201-3706 |
      | Regulation: finance                | 4-103-1094?sv=3-201-3706 |
      | Security and quasi security        | 6-103-1106?sv=3-201-3706 |
      | Structured finance                 | 8-103-1105?sv=3-201-3706 |
      | Trade finance                      | 0-103-1109?sv=3-201-3706 |

  Scenario: Scenario to verify the topic links on 'Ask:IP&IT' Practice area page

    When the user clicks link 'IP & IT' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                | TopicPLCRef              |
      | Confidentiality          | 7-103-1304?sv=5-103-1753 |
      | Copyright                | 0-103-1270?sv=5-103-1753 |
      | Databases                | 6-103-1272?sv=5-103-1753 |
      | Data protection          | 8-103-1271?sv=5-103-1753 |
      | Designs                  | 4-103-1273?sv=5-103-1753 |
      | General IP               | 0-103-2076?sv=5-103-1753 |
      | Information technology   | 9-103-1119?sv=5-103-1753 |
      | Passing off              | 4-103-1305?sv=5-103-1753 |
      | Patents                  | 2-103-1306?sv=5-103-1753 |
      | Research and development | 0-103-1307?sv=5-103-1753 |
      | Trade marks              | 2-103-2080?sv=5-103-1753 |

  Scenario: Scenario to verify the topic links on 'Ask:Local Goverenment' Practice area page

    When the user clicks link 'Local Government' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                               | TopicPLCRef              |
      | Access to environmental information     | 6-103-1229?sv=9-614-3625 |
      | Adult social services                   | 5-540-5390?sv=9-614-3625 |
      | Decision-making: local government       | 2-614-6905?sv=9-614-3625 |
      | Education                               | 9-386-1394?sv=9-614-3625 |
      | Enforcement: local government           | 1-540-5387?sv=9-614-3625 |
      | Freedom of information                  | 7-201-6246?sv=9-614-3625 |
      | General contract and boilerplate        | 9-103-1119?sv=9-614-3625 |
      | Governance and powers: local government | 4-384-2020?sv=9-614-3625 |
      | Health                                  | 2-384-2021?sv=9-614-3625 |
      | Judicial review                         | 5-384-0921?sv=9-614-3625 |
      | Mental capacity                         | 8-383-2279?sv=9-614-3625 |
      | Outsourcing                             | 0-202-2707?sv=9-614-3625 |
      | PFI/PPP                                 | 8-384-0910?sv=9-614-3625 |
      | Partnership working                     | 2-386-1401?sv=9-614-3625 |
      | Public procurement                      | 7-103-1177?sv=9-614-3625 |
      | Public-sector pensions                  | 8-501-5587?sv=9-614-3625 |
      | Right to buy                            | 3-103-1320?sv=9-614-3625 |
      | Social housing                          | 3-103-1315?sv=9-614-3625 |
      | State aid                               | 1-103-1180?sv=9-614-3625 |
      | Transfer of undertakings                | 4-103-1225?sv=9-614-3625 |

  Scenario: Scenario to verify the topic links on 'Ask:Media & Telecoms' Practice area page

    When the user clicks link 'Media & Telecoms' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink     | TopicPLCRef              |
      | Film          | 4-525-4283?sv=1-509-3753 |
      | General media | 9-205-8952?sv=1-509-3753 |
      | Internet      | 8-383-8686?sv=1-509-3753 |
      | Music         | 9-525-4285?sv=1-509-3753 |
      | Privacy       | 6-383-8687?sv=1-509-3753 |
      | Social media  | 0-525-4280?sv=1-509-3753 |
      | Telecoms      | 7-205-8953?sv=1-509-3753 |
      | TV            | 2-525-4279?sv=1-509-3753 |

  Scenario: Scenario to verify the topic links on 'Ask:Pensions' Practice area page

    When the user clicks link 'Pensions' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                              | TopicPLCRef              |
      | Administering pension schemes          | 8-205-7953?sv=9-204-8963 |
      | Auto-enrolment and NEST                | 9-500-6436?sv=9-204-8963 |
      | Contracting-out                        | 9-540-5326?sv=9-204-8963 |
      | Cross-border                           | 5-200-1613?sv=9-204-8963 |
      | DC pension schemes                     | 5-540-5328?sv=9-204-8963 |
      | Discrimination                         | 8-379-8242?sv=9-204-8963 |
      | Early leavers                          | 7-540-5346?sv=9-204-8963 |
      | Employer debt                          | 3-540-5367?sv=9-204-8963 |
      | Employers                              | 2-308-5967?sv=9-204-8963 |
      | Funding and investment                 | 1-205-7956?sv=9-204-8963 |
      | General pensions                       | 1-103-1340?sv=9-204-8963 |
      | Members and benefits                   | 9-103-1341?sv=9-204-8963 |
      | Pension Protection Fund                | 6-379-8238?sv=9-204-8963 |
      | Pension sharing                        | 9-540-5369?sv=9-204-8963 |
      | Pensions and employment                | 4-379-8239?sv=9-204-8963 |
      | Pensions Regulator                     | 2-379-8240?sv=9-204-8963 |
      | Policy and reform                      | 0-103-1345?sv=9-204-8963 |
      | Public-sector pensions                 | 8-501-5587?sv=9-204-8963 |
      | Sales and acquisitions                 | 2-103-1349?sv=9-204-8963 |
      | Scheme documents                       | 9-205-7957?sv=9-204-8963 |
      | Scheme restructurings and mergers      | 0-379-8241?sv=9-204-8963 |
      | Tax and accounting                     | 8-103-1346?sv=9-204-8963 |
      | Trustees                               | 4-207-2074?sv=9-204-8963 |
      | Winding-up and insolvency              | 5-205-7959?sv=9-204-8963 |
      | Court proceedings                      | 3-380-8696?sv=9-204-8963 |
      | Ombudsmen and tribunals                | 9-380-8698?sv=9-204-8963 |
      | Internal dispute resolution procedures | 1-380-8697?sv=9-204-8963 |
      | Challenging the Pensions Regulator     | 9-382-3118?sv=9-204-8963 |
      | Common issues in disputes              | 5-380-8695?sv=9-204-8963 |
      | General contract and boilerplate       | 9-103-1119?sv=9-204-8963 |

  Scenario: Scenario to verify the topic links on 'Ask:Planning' Practice area page

    When the user clicks link 'Planning' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                                    | TopicPLCRef              |
      | Advertisements: planning                                     | 3-607-5785?sv=4-606-9425 |
      | Appeals: planning                                            | 0-607-5287?sv=4-606-9425 |
      | Conservation areas                                           | 1-607-5705?sv=4-606-9425 |
      | Enforcement: planning                                        | 1-607-5625?sv=4-606-9425 |
      | Environment impact assessments                               | 1-200-2228?sv=4-606-9425 |
      | Judicial review                                              | 5-384-0921?sv=4-606-9425 |
      | Listed buildings                                             | 7-607-5665?sv=4-606-9425 |
      | Local government ombudsman: planning                         | 6-607-5289?sv=4-606-9425 |
      | Nationally Significant Infrastructure Projects (NSIPs)       | 5-607-5765?sv=4-606-9425 |
      | Permitted development                                        | 2-607-5286?sv=4-606-9425 |
      | Planning applications                                        | 8-607-5245?sv=4-606-9425 |
      | Planning obligations and Community Infrastructure Levy (CIL) | 4-607-5266?sv=4-606-9425 |
      | Planning permission                                          | 6-607-5246?sv=4-606-9425 |
      | Policy framework: planning                                   | 1-607-5885?sv=4-606-9425 |
      | Protected trees                                              | 7-607-5745?sv=4-606-9425 |
      | Scheduled monuments                                          | 9-607-5725?sv=4-606-9425 |
      | Use classes order                                            | 4-607-5285?sv=4-606-9425 |

  Scenario: Scenario to verify the topic links on 'Ask:Private Client' Practice area page

    When the user clicks link 'Private Client' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                          | TopicPLCRef              |
      | After death                        | 8-383-2284?sv=2-383-9212 |
      | Charities                          | 3-383-2286?sv=2-383-9212 |
      | Contentious private client         | 3-540-5386?sv=2-383-9212 |
      | General contract and boilerplate   | 9-103-1119?sv=2-383-9212 |
      | International individuals          | 5-383-2285?sv=2-383-9212 |
      | Lifetime planning                  | 1-383-2273?sv=2-383-9212 |
      | Mental capacity                    | 8-383-2279?sv=2-383-9212 |
      | Owner-managed businesses           | 7-376-4394?sv=2-383-9212 |
      | Trusts                             | 0-383-2283?sv=2-383-9212 |
      | Wills                              | 6-383-2275?sv=2-383-9212 |
      | Legal concepts and miscellaneous   | 3-103-2070?sv=2-383-9212 |
      | Conflicts of interest              | 7-103-1988?sv=2-383-9212 |
      | Conspiracy                         | 2-103-1250?sv=2-383-9212 |
      | Cross-border: legal concepts       | 7-200-1626?sv=2-383-9212 |
      | Deceit                             | 0-103-1251?sv=2-383-9212 |
      | Defamation                         | 8-103-1252?sv=2-383-9212 |
      | Human rights                       | 6-103-1253?sv=2-383-9212 |
      | Miscellaneous: legal concepts      | 9-200-1625?sv=2-383-9212 |
      | Negligence                         | 7-103-0818?sv=2-383-9212 |
      | Professional conduct               | 1-103-2071?sv=2-383-9212 |
      | Statutory construction             | 4-103-1254?sv=2-383-9212 |
      | Trading vehicles                   | 4-200-1661?sv=2-383-9212 |
      | Trusts and fiduciary relationships | 1-103-1255?sv=2-383-9212 |

  Scenario: Scenario to verify the topic links on 'Ask:Property' Practice area page

    When the user clicks link 'Property' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                                               | TopicPLCRef              |
      | Assignments, variations, surrenders and termination: land and buildings | 7-609-7865?sv=7-103-1771 |
      | Business tenancies (non-contentious)                                    | 4-607-3385?sv=7-103-1771 |
      | Charity transactions: land and buildings                                | 2-607-3145?sv=7-103-1771 |
      | Common land, town and village greens                                    | 2-200-1662?sv=7-103-1771 |
      | Commonhold                                                              | 6-103-1309?sv=7-103-1771 |
      | Contracts and transfers: land and buildings                             | 4-103-1310?sv=7-103-1771 |
      | Conveyancing procedure                                                  | 8-103-2082?sv=7-103-1771 |
      | Corporate support: land and buildings                                   | 2-103-1311?sv=7-103-1771 |
      | Development                                                             | 0-103-1312?sv=7-103-1771 |
      | Easements, covenants and other third party rights                       | 6-103-2083?sv=7-103-1771 |
      | Energy and buildings                                                    | 9-206-1006?sv=7-103-1771 |
      | Estate management and licences                                          | 0-607-3325?sv=7-103-1771 |
      | Execution formalities                                                   | 0-607-3486?sv=7-103-1771 |
      | Financial and corporate crime                                           | 7-103-1182?sv=7-103-1771 |
      | Governance and powers: local government                                 | 4-384-2020?sv=7-103-1771 |
      | Guarantees: land and buildings                                          | 0-607-3306?sv=7-103-1771 |
      | Insurance                                                               | 2-103-1132?sv=7-103-1771 |
      | Land registration                                                       | 9-103-1317?sv=7-103-1771 |
      | Leases and licences to occupy                                           | 8-607-3265?sv=7-103-1771 |
      | Mortgages and security: land and buildings                              | 1-103-1321?sv=7-103-1771 |
      | Options, pre-emptions and overage                                       | 8-607-3406?sv=7-103-1771 |
      | Property: restructuring and insolvency                                  | 1-103-1316?sv=7-103-1771 |
      | Real estate finance and investment                                      | 9-103-2086?sv=7-103-1771 |
      | Residential tenancies                                                   | 8-607-3345?sv=7-103-1771 |
      | Restructuring and insolvency transactions                               | 1-103-1316?sv=7-103-1771 |
      | Statutory liabilities: land and buildings                               | 8-103-1327?sv=7-103-1771 |
      | Sustainability                                                          | 4-607-3465?sv=7-103-1771 |
      | Taxation: land and buildings                                            | 8-103-1394?sv=7-103-1771 |
      | Title issues                                                            | 6-103-1328?sv=7-103-1771 |
      | Utilities                                                               | 4-103-1329?sv=7-103-1771 |
      | Legal concepts and miscellaneous                                        | 3-103-2070?sv=7-103-1771 |
      | Deceit                                                                  | 0-103-1251?sv=7-103-1771 |
      | Human rights                                                            | 6-103-1253?sv=7-103-1771 |
      | Negligence                                                              | 7-103-0818?sv=7-103-1771 |
      | Professional conduct                                                    | 1-103-2071?sv=7-103-1771 |
      | Trusts and fiduciary relationships                                      | 1-103-1255?sv=7-103-1771 |

  Scenario: Scenario to verify the topic links on 'Ask:Property Litigation' Practice area page

    When the user clicks link 'Property Litigation' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                    | TopicPLCRef              |
      | Assured shorthold tenancies                  | 3-607-4446?sv=8-606-9466 |
      | Breach of lease covenants                    | 1-607-4485?sv=8-606-9466 |
      | Break notices: land and buildings            | 2-607-4545?sv=8-606-9466 |
      | Business tenancies (contentious)             | 0-607-4565?sv=8-606-9466 |
      | CPR procedure                                | 8-607-4585?sv=8-606-9466 |
      | Dilapidations                                | 4-607-4907?sv=8-606-9466 |
      | Enforcement and Remedies: Land and Buildings | 8-103-1313?sv=8-606-9466 |
      | Enfranchisement and lease extensions         | 2-607-5007?sv=8-606-9466 |
      | Forfeiture                                   | 0-607-5027?sv=8-606-9466 |
      | Party walls                                  | 6-607-5185?sv=8-606-9466 |
      | Possession of land and buildings             | 2-607-5187?sv=8-606-9466 |
      | Rent, non-payment of rent and rent review    | 0-607-5046?sv=8-606-9466 |
      | Right of first refusal: land and buildings   | 0-607-5070?sv=8-606-9466 |
      | Rights of light                              | 0-607-5206?sv=8-606-9466 |
      | Service charges: land and buildings          | 8-607-5085?sv=8-606-9466 |
      | Tenancy deposit schemes                      | 4-607-5105?sv=8-606-9466 |
      | Trespass                                     | 8-607-5207?sv=8-606-9466 |

  Scenario: Scenario to verify the topic links on 'Ask:Tax' Practice area page

    When the user clicks link 'Tax' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                | TopicPLCRef              |
      | Companies and groups                     | 3-540-5447?sv=5-378-8744 |
      | Asset acquisitions                       | 5-103-1079?sv=5-378-8744 |
      | Equity capital markets                   | 5-540-5446?sv=5-378-8744 |
      | Joint ventures                           | 8-103-1308?sv=5-378-8744 |
      | Private equity and venture capital       | 0-103-1350?sv=5-378-8744 |
      | Share acquisitions                       | 1-540-5429?sv=5-378-8744 |
      | Cross-border                             | 2-103-1387?sv=5-378-8744 |
      | Anti-avoidance                           | 6-376-4380?sv=5-378-8744 |
      | Disputes and investigations              | 2-376-3556?sv=5-378-8744 |
      | Cross-border and immigration             | 6-382-8829?sv=5-378-8744 |
      | Employment income, pensions and benefits | 4-376-4395?sv=5-378-8744 |
      | Employment status and self-employment    | 2-382-8831?sv=5-378-8744 |
      | National Insurance Contributions         | 8-103-2100?sv=5-378-8744 |
      | Termination of employment                | 1-103-1222?sv=5-378-8744 |
      | Energy and environment                   | 7-376-3554?sv=5-378-8744 |
      | Asset finance                            | 5-201-5200?sv=5-378-8744 |
      | Cross-border: finance                    | 7-200-1612?sv=5-378-8744 |
      | Debt capital markets                     | 9-103-1100?sv=5-378-8744 |
      | Derivatives                              | 4-103-2036?sv=5-378-8744 |
      | Islamic finance                          | 3-201-5201?sv=5-378-8744 |
      | Lending: general                         | 1-103-2033?sv=5-378-8744 |
      | Structured finance                       | 8-103-1105?sv=5-378-8744 |
      | Investment funds and asset management    | 6-103-1352?sv=5-378-8744 |
      | IP and IT                                | 1-376-3552?sv=5-378-8744 |
      | Owner-managed businesses                 | 7-376-4394?sv=5-378-8744 |
      | Partnerships and LLPs                    | 5-103-2045?sv=5-378-8744 |
      | Development and construction             | 0-103-1312?sv=5-378-8744 |
      | Landlord and tenant                      | 7-103-1318?sv=5-378-8744 |
      | Real estate finance and investment       | 9-103-2086?sv=5-378-8744 |
      | Stamp duty land tax                      | 5-376-3550?sv=5-378-8744 |
      | Dividends and distributions              | 4-376-3555?sv=5-378-8744 |
      | Reorganisations, schemes and demergers   | 8-103-1153?sv=5-378-8744 |
      | Buybacks and other returns of value      | 7-103-2054?sv=5-378-8744 |
      | Restructuring and insolvency             | 7-385-2121?sv=5-378-8744 |
      | Stamp duty and SDRT                      | 3-376-3551?sv=5-378-8744 |
      | VAT                                      | 9-376-3548?sv=5-378-8744 |
      | Taxes                                    | 9-376-4393?sv=5-378-8744 |
      | Contract and boilerplate                 | 9-103-1119?sv=5-378-8744 |
      | Legal concepts                           | 3-103-2070?sv=5-378-8744 |


  Scenario: Scenario to verify the topic links on 'Ask:Share Schemes & Incentives' Practice area page

    When the user clicks link 'Share Schemes & Incentives' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                         | TopicPLCRef              |
      | Accounting, finance and scheme design: incentives | 8-205-7175?sv=1-204-8962 |
      | CSOP/SAYE/SIPs                                    | 6-319-0952?sv=1-204-8962 |
      | Cash-based employee incentive schemes             | 5-205-7167?sv=1-204-8962 |
      | Company law and corporate governance: incentives  | 3-205-7168?sv=1-204-8962 |
      | Corporate transactions: incentives                | 1-205-7169?sv=1-204-8962 |
      | EMI options                                       | 9-318-9952?sv=1-204-8962 |
      | Employee benefit trusts                           | 9-205-7170?sv=1-204-8962 |
      | Employment law issues: incentives                 | 7-205-7171?sv=1-204-8962 |
      | General contract and boilerplate                  | 9-103-1119?sv=1-204-8962 |
      | International aspects of incentives               | 3-205-7173?sv=1-204-8962 |
      | Legal concepts and miscellaneous                  | 3-103-2070?sv=1-204-8962 |
      | Conflicts of interest                             | 7-103-1988?sv=1-204-8962 |
      | Conspiracy                                        | 2-103-1250?sv=1-204-8962 |
      | Cross-border: legal concepts                      | 7-200-1626?sv=1-204-8962 |
      | Deceit                                            | 0-103-1251?sv=1-204-8962 |
      | Defamation                                        | 8-103-1252?sv=1-204-8962 |
      | Human rights                                      | 6-103-1253?sv=1-204-8962 |
      | Miscellaneous: legal concepts                     | 9-200-1625?sv=1-204-8962 |
      | Negligence                                        | 7-103-0818?sv=1-204-8962 |
      | Professional conduct                              | 1-103-2071?sv=1-204-8962 |
      | Statutory construction                            | 4-103-1254?sv=1-204-8962 |
      | Trading vehicles                                  | 4-200-1661?sv=1-204-8962 |
      | Trusts and fiduciary relationship                 | 1-103-1255?sv=1-204-8962 |
      | Regulatory matters: incentives                    | 3-540-5428?sv=1-204-8962 |
      | Tax and NICs: incentives                          | 6-205-7176?sv=1-204-8962 |
      | Taxable share schemes and arrangements            | 4-319-0953?sv=1-204-8962 |


  Scenario: Scenario to verify the topic links on 'Ask:Restructuring & Insolvency' Practice area page

    When the user clicks link 'Restructuring & Insolvency' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                                 | TopicPLCRef              |
      | Administration                                            | 9-103-1256?sv=1-381-9653 |
      | Company voluntary arrangements                            | 9-540-5425?sv=1-381-9653 |
      | Court proceedings: restructuring and insolvency           | 7-540-5426?sv=1-381-9653 |
      | Cross-border: restructuring and insolvency                | 7-103-2073?sv=1-381-9653 |
      | Directors and employees: restructuring and insolvency     | 7-103-1257?sv=1-381-9653 |
      | Dissolution, Strike off and Restoration                   | 1-540-5405?sv=1-381-9653 |
      | Individual Voluntary Arrangements                         | 5-540-5408?sv=1-381-9653 |
      | Liquidation                                               | 1-103-1260?sv=1-381-9653 |
      | Partnerships and LLPs                                     | 5-103-2045?sv=1-381-9653 |
      | Policy and Reform: Restructuring and Insolvency           | 0-103-1265?sv=1-381-9653 |
      | Property: Restructuring and Insolvency                    | 1-103-1316?sv=1-381-9653 |
      | Receivership                                              | 0-386-1402?sv=1-381-9653 |
      | Regulation, Powers and Duties of Insolvency Practitioners | 8-103-1266?sv=1-381-9653 |
      | Regulatory Matters: Incentives                            | 3-540-5428?sv=1-381-9653 |
      | Restructuring and Insolvency Transactions                 | 4-103-1268?sv=1-381-9653 |
      | Restructuring and Insolvency: Tax                         | 7-385-2121?sv=1-381-9653 |
      | Reviewable Transactions                                   | 6-103-1267?sv=1-381-9653 |
      | Schemes of Arrangement: Restructuring and Insolvency      | 3-540-5409?sv=1-381-9653 |
      | UK Bankruptcy and Debt Relief Orders                      | 3-103-1264?sv=1-381-9653 |
      | Winding-up and Insolvency: Pensions                       | 5-205-7959?sv=1-381-9653 |

  Scenario: Scenario to verify the topic links on 'Ask:Public Law' Practice area page

    When the user clicks link 'Public Law' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                           | TopicPLCRef              |
      | Access to environmental information | 6-103-1229?sv=9-527-9785 |
      | Equality                            | 3-540-5391?sv=9-527-9785 |
      | Executive and legislative powers    | 8-614-6865?sv=9-527-9785 |
      | Exercising statutory powers         | 6-384-2019?sv=9-527-9785 |
      | Freedom of Information              | 7-201-6246?sv=9-527-9785 |
      | General contract and boilerplate    | 9-103-1119?sv=9-527-9785 |
      | Human rights                        | 6-103-1253?sv=9-527-9785 |
      | Judicial review                     | 5-384-0921?sv=9-527-9785 |
      | Outsourcing                         | 0-202-2707?sv=9-527-9785 |
      | PFI/PPP                             | 8-384-0910?sv=9-527-9785 |
      | Pensions                            | 3-384-0757?sv=9-527-9785 |
      | Public procurement                  | 7-103-1177?sv=9-527-9785 |
      | State aid                           | 1-103-1180?sv=9-527-9785 |
      | Statutory construction              | 4-103-1254?sv=9-527-9785 |
      | Transfer of undertakings            | 4-103-1225?sv=9-527-9785 |

