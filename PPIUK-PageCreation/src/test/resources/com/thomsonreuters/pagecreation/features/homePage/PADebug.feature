@wip
Feature: To verify all the topic links for all the Practice area ASK pages

  Background:
    Given PL+ user is logged in
    And The user clicks the Home page tab link "Resources"
    And clicks on Ask link

  Scenario: Scenario to verify the topic links on Tax Practice area page

    When the user clicks link 'Tax' on 'the Ask Landing' page
    Then clicks on the Subtopic Topiclink and verifies the correct page is opened
      | TopicLink                                      | TopicPLCRef              |
      | Companies and groups                           | 3-540-5447?sv=5-378-8744 |
      | Asset acquisitions                             | 5-103-1079?sv=5-378-8744 |
      | Equity capital markets                         | 5-540-5446?sv=5-378-8744 |
      | Joint ventures                                 | 8-103-1308?sv=5-378-8744 |
      | Private equity and venture capital             | 0-103-1350?sv=5-378-8744 |
      | Share acquisitions                             | 1-540-5429?sv=5-378-8744 |
      | Cross-border                                   | 2-103-1387?sv=5-378-8744 |
      | Anti-avoidance                                 | 6-376-4380?sv=5-378-8744 |
      | Disputes and investigations                    | 2-376-3556?sv=5-378-8744 |
      | Cross-border and immigration                   | 6-382-8829?sv=5-378-8744 |
      | Employment income, pensions and benefits       | 4-376-4395?sv=5-378-8744 |
      #| Employment status and self-employment          | 2-382-8831?sv=5-378-8744 | *Needs an exception. Page title is "Employment Status and Independent Contractors"
      | National Insurance Contributions               | 8-103-2100?sv=5-378-8744 |
      | Termination of employment                      | 1-103-1222?sv=5-378-8744 |
      | Energy and environment                         | 7-376-3554?sv=5-378-8744 |
      | Asset finance                                  | 5-201-5200?sv=5-378-8744 |
      | Cross-border: finance                          | 7-200-1612?sv=5-378-8744 |
      | Debt capital markets                           | 9-103-1100?sv=5-378-8744 |
      | Derivatives                                    | 4-103-2036?sv=5-378-8744 |
      | Islamic finance                                | 3-201-5201?sv=5-378-8744 |
      | Lending: general                               | 1-103-2033?sv=5-378-8744 |
      | Structured finance                             | 8-103-1105?sv=5-378-8744 |
      | Investment funds and asset management          | 6-103-1352?sv=5-378-8744 |
      | IP and IT                                      | 1-376-3552?sv=5-378-8744 |
      | Owner-managed businesses                       | 7-376-4394?sv=5-378-8744 |
      | Partnerships and LLPs                          | 5-103-2045?sv=5-378-8744 |
      #| Development and construction                   | 0-103-1312?sv=5-378-8744 | *Needs exception: Page title is just "Development"
      | Landlord and tenant                            | 7-103-1318?sv=5-378-8744 |
      | Real estate finance and investment             | 9-103-2086?sv=5-378-8744 |
      | Stamp duty land tax                            | 5-376-3550?sv=5-378-8744 |
      | Dividends and distributions                    | 4-376-3555?sv=5-378-8744 |
      | Reorganisations, schemes and demergers         | 8-103-1153?sv=5-378-8744 |
      #| Buybacks and other returns of value            | 7-103-2054?sv=5-378-8744 | *Needs exception: page title is just "Returns of value"
      | Restructuring and insolvency                   | 7-385-2121?sv=5-378-8744 |
      | Stamp duty and SDRT                            | 3-376-3551?sv=5-378-8744 |
      | VAT                                            | 9-376-3548?sv=5-378-8744 |
      | Taxes                                          | 9-376-4393?sv=5-378-8744 |
      | Contract and boilerplate                       | 9-103-1119?sv=5-378-8744 |
      | Legal concepts                                 | 3-103-2070?sv=5-378-8744 |


  Scenario: Scenario to verify the topic links on Share Schemes & Incentives Practice area page

    When the user clicks link 'Share Schemes & Incentives' on 'the Ask Landing' page
    Then clicks on the Subtopic Topiclink and verifies the correct page is opened
      | TopicLink                                             | TopicPLCRef              |
      | Accounting, finance and scheme design: incentives     | 8-205-7175?sv=1-204-8962 |
      | CSOP/SAYE/SIPs                                        | 6-319-0952?sv=1-204-8962 |
      | Cash-based employee incentive schemes                 | 5-205-7167?sv=1-204-8962 |
      | Company law and corporate governance: incentives      | 3-205-7168?sv=1-204-8962 |
      | Corporate transactions: incentives                    | 1-205-7169?sv=1-204-8962 |
      | EMI options                                           | 9-318-9952?sv=1-204-8962 |
      | Employee benefit trusts                               | 9-205-7170?sv=1-204-8962 |
      | Employment law issues: incentives                     | 7-205-7171?sv=1-204-8962 |
      | General contract and boilerplate                      | 9-103-1119?sv=1-204-8962 |
      | International aspects of incentives                   | 3-205-7173?sv=1-204-8962 |
      | Legal concepts and miscellaneous                      | 3-103-2070?sv=1-204-8962 |
      | Conflicts of interest                                 | 7-103-1988?sv=1-204-8962 |
      | Conspiracy                                            | 2-103-1250?sv=1-204-8962 |
      | Cross-border: legal concepts                          | 7-200-1626?sv=1-204-8962 |
      | Deceit                                                | 0-103-1251?sv=1-204-8962 |
      | Defamation                                            | 8-103-1252?sv=1-204-8962 |
      | Human rights                                          | 6-103-1253?sv=1-204-8962 |
      | Miscellaneous: legal concepts                         | 9-200-1625?sv=1-204-8962 |
      | Negligence                                            | 7-103-0818?sv=1-204-8962 |
      | Professional conduct                                  | 1-103-2071?sv=1-204-8962 |
      | Statutory construction                                | 4-103-1254?sv=1-204-8962 |
      | Trading vehicles                                      | 4-200-1661?sv=1-204-8962 |
      | Trusts and fiduciary relationship                     | 1-103-1255?sv=1-204-8962 |
      | Regulatory matters: incentives                        | 3-540-5428?sv=1-204-8962 |
      | Tax and NICs: incentives                              | 6-205-7176?sv=1-204-8962 |
      | Taxable share schemes and arrangements                | 4-319-0953?sv=1-204-8962 |


  Scenario: Scenario to verify the topic links on Restructuring & Insolvency Practice area page

    When the user clicks link 'Restructuring & Insolvency' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                                    | TopicPLCRef              |
      | Administration                                               | 9-103-1256?sv=1-381-9653 |
      | Company voluntary arrangements                               | 9-540-5425?sv=1-381-9653 |
      | Court proceedings: restructuring and insolvency              | 7-540-5426?sv=1-381-9653 |
      | Cross-border: restructuring and insolvency                   | 7-103-2073?sv=1-381-9653 |
      | Directors and employees: restructuring and insolvency        | 7-103-1257?sv=1-381-9653 |
      | Dissolution, Strike off and Restoration                      | 1-540-5405?sv=1-381-9653 |
      | Individual Voluntary Arrangements                            | 5-540-5408?sv=1-381-9653 |
      | Liquidation                                                  | 1-103-1260?sv=1-381-9653 |
      | Partnerships and LLPs                                        | 5-103-2045?sv=1-381-9653 |
      | Policy and Reform: Restructuring and Insolvency              | 0-103-1265?sv=1-381-9653 |
      | Property: Restructuring and Insolvency                       | 1-103-1316?sv=1-381-9653 |
      | Receivership                                                 | 0-386-1402?sv=1-381-9653 |
      | Regulation, Powers and Duties of Insolvency Practitioners    | 8-103-1266?sv=1-381-9653 |
      | Regulatory Matters: Incentives                               | 3-540-5428?sv=1-381-9653 |
      | Restructuring and Insolvency Transactions                    | 4-103-1268?sv=1-381-9653 |
      | Restructuring and Insolvency: Tax                            | 7-385-2121?sv=1-381-9653 |
      | Reviewable Transactions                                      | 6-103-1267?sv=1-381-9653 |
      | Schemes of Arrangement: Restructuring and Insolvency         | 3-540-5409?sv=1-381-9653 |
      | UK Bankruptcy and Debt Relief Orders                         | 3-103-1264?sv=1-381-9653 |
      | Winding-up and Insolvency: Pensions                          | 5-205-7959?sv=1-381-9653 |

   @sandystest9
  Scenario: Scenario to verify the topic links on Public Law Practice area page

    When the user clicks link 'Public Law' on 'the Ask Landing' page
    Then clicks on the topic Topiclink and verifies the correct page is opened
      | TopicLink                                         | TopicPLCRef              |
      | Access to environmental information               | 6-103-1229?sv=9-527-9785 |
      | Equality                                          | 3-540-5391?sv=9-527-9785 |
      | Executive and legislative powers                  | 8-614-6865?sv=9-527-9785 |
      | Exercising statutory powers                       | 6-384-2019?sv=9-527-9785 |
      | Freedom of Information                            | 7-201-6246?sv=9-527-9785 |
      | General contract and boilerplate                  | 9-103-1119?sv=9-527-9785 |
      | Human rights                                      | 6-103-1253?sv=9-527-9785 |
      | Judicial review                                   | 5-384-0921?sv=9-527-9785 |
      | Outsourcing                                       | 0-202-2707?sv=9-527-9785 |
      | PFI/PPP                                           | 8-384-0910?sv=9-527-9785 |
      #| Pensions                                          | 3-384-0757?sv=9-527-9785 | *Needs updated xpath*
      | Public procurement                                | 7-103-1177?sv=9-527-9785 |
      | State aid                                         | 1-103-1180?sv=9-527-9785 |
      | Statutory construction                            | 4-103-1254?sv=9-527-9785 |
      | Transfer of undertakings                          | 4-103-1225?sv=9-527-9785 |

