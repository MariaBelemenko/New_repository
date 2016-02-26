@manual
Feature: [637926][638469][638471] productSearch.feature
  The <region> entry point is used to verify the product search results
  This feature covers tests for the following stories:
  [637926], [638469], [638471]

  Scenario Outline: The <region> entry point is used for the KH search and results
    Given PL+ user is logged in
    And has selected the Know How - <region> link
    And the user runs a free text search for the query "<query>"
    And the user can open the first know how search result "1"
    And the user verifies that the product detail contains the practice area "<productArea>"
  Examples:
    | region | query                                        | productArea                               |
    | UK     | appeal(md.plc.reference(1-103-1613))         | PLC Magazine (UK)                         |
    | UK     | corporation(md.plc.reference(9-202-3364))    | PLC Business Development                  |
    | UK     | dismissal(md.plc.reference(1-379-8575))      | PLC UK Commercial                         |
    | UK     | companies(md.plc.reference(7-103-2186))      | PLC EU Competition Law                    |
    | UK     | pension reform(md.plc.reference(9-204-8963)) | PLC UK Pensions                           |
    | US     | appeal(md.plc.reference(3-504-6510))         | PLC US Antitrust                          |
    | US     | arbitration(md.plc.reference(9-523-0906))    | PLC US Bankruptcy                         |
    | US     | arbitration(md.plc.reference(1-523-0910))    | PLC US Corporate & Securities             |
    | US     | tax(md.plc.reference(3-504-6505))            | PLC US Intellectual Property & Technology |