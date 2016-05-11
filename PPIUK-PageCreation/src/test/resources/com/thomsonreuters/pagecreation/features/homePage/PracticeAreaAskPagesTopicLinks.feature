@wip
Feature: To verify all the topic links for all the Practice area ASK pages

  Background:
    Given PL+ user is logged in
    And The user clicks the Home page tab link "Resources"
    And clicks on Ask link

  Scenario: Scenario to verify the topic links on Agriculture & Rural Land Practice area page

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

  Scenario: Scenario to verify the topic links on Commercial Practice area page

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

  Scenario: Scenario to verify the topic links on Construction Practice area page

    When the user clicks link 'Construction' on 'the Ask Landing' page
    Then clicks on the Subtopic Topiclink and verifies the correct page is opened
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

  Scenario: Scenario to verify the topic links on Corporate Practice area page

    When the user clicks link 'Corporate' on 'the Ask Landing' page
    Then clicks on the Subtopic Topiclink and verifies the correct page is opened
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


  Scenario: Scenario to verify the topic links on Data Protection Practice area page

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


