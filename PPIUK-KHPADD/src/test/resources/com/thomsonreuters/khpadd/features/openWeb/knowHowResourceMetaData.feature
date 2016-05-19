Feature: Check meta data (title, Author,status, jurisdictions, resource history link, related content link and document type) for different Know How resources

  @e2e @prod @e2eprod
  Scenario Outline: Check correct metadata is displayed for "<document Description>"
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    Then document title is displayed as "<title>"
    And "<author>" is displayed underneath the title
    And resource status "<resource status>" is displayed on the document right hand panel
    And following jurisdictions are displayed on the document right hand panel
      | <jurisdictions> |
    And 'View Resource History' link is <resource history> on the right hand panel
    And 'Related Content' link is <related content> on the right hand panel
    And resource type is displayed as "<documentType>" on right hand panel
    And plc reference is displayed as "<plc ref>"
  Examples:
    | document Description              | guid                              | title                                                                                                  | author                                                                       | resource status              | jurisdictions                                        | resource history | related content | documentType                       | plc ref    |
    | Legal update: case report         | I1bc298adc1c611e498db8b09b4f043e0 | Reasonable, not perfect, efforts required to avoid having constructive knowledge of a disability (EAT) | Practical Law Employment                                                     | Published on 02-Mar-2015     | England,Scotland,Wales                               | Not displayed    | displayed       | Legal update: case report          | 3-601-9365 |
    | Legislation tracker               | I7bc53d0ae1aa11e398db8b09b4f043e0 | Practical Law Employment: legislation tracker                                                          | Practical Law Employment                                                     | Maintained                   | England,European Union,Scotland,United Kingdom,Wales | Not displayed    | displayed       | Legislation Tracker                | 1-200-2153 |
    | Legal update: archive             | Ib74809c6ce3411e498db8b09b4f043e0 | ECJ preliminary ruling on whether a state guarantee given prior to accession is state aid              | Practical Law Competition                                                    | Published on 19-Mar-2015     | European Union                                       | Not displayed    | Not displayed   | Legal update: archive              | 5-605-1585 |
    | Emails                            | I1f4a08fbce5311e498db8b09b4f043e0 | Practical Law Pensions weekly email to 19 March 2015                                                   | Practical Law Pensions                                                       | Published on 19-Mar-2015     | No jurisdictions                                     | Not displayed    | Not displayed   | Emails                             | 0-605-3105 |
    | Article                           | I01e8643390af11e498db8b09b4f043e0 | Practical Law Family: looking back and what to expect in 2015                                          | Practical Law Family                                                         | Law stated as at 31-Dec-2014 | England,Wales                                        | Not displayed    | Not displayed   | Articles                           | 4-592-8605 |
    | Articles - professional           | I5aae94d305fe11e498db8b09b4f043e0 | Lawyer Superleagues                                                                                    | No Author                                                                    | Law stated as at 01-Nov-2001 | Argentina,Australia,Austria,Belgium,Brazil           | Not displayed    | Not displayed   | Articles: professional             | 2-200-7367 |
    | EU Case Tracker                   | I33f1f225e8cd11e398db8b09b4f043e0 | OFT (and Regulator) investigations under the Competition Act 1998 concluded in 2003.                   | No Author                                                                    | Law stated as at 08-Jan-2004 | United Kingdom                                       | Not displayed    | Not displayed   | CaseTracker                        | 8-102-3365 |
    | Checklist                         | I01e88ae090af11e498db8b09b4f043e0 | ISDA Master Agreement: Events of Default and Termination Events: checklist                             | Practical Law Finance                                                        | Maintained                   | England,Wales                                        | displayed        | displayed       | Checklists                         | 8-592-6765 |
    | Country Q&As                      | Ieb49d7981cb511e38578f7ccc38dcbee | Cartel leniency in Germany: overview                                                                   | Torsten Uhlig, Kümmerlein Simon & Partner Rechtsanwälte mbB                | Law stated as at 01-Mar-2016 | Germany                                              | Not displayed    | displayed       | Country Q&A                        | 2-501-2172 |
    | Drafting Notes                    | I3351a9f5e8da11e398db8b09b4f043e0 | Compulsory liquidation: statutory demand: drafting note                                                | Alex Barden, barrister, Erskine Chambers                                     | Maintained                   | United Kingdom                                       | displayed        | displayed       | Drafting notes                     | 8-383-6282 |
    | Help and Information Notes        | I33f1f4cae8cd11e398db8b09b4f043e0 | CRC Survival Kit: what is it?                                                                          | Practical Law Environment                                                    | Maintained                   | No jurisdictions                                     | Not displayed    | Not displayed   | Help and information notes         | 5-501-4792 |
    | Policy guidance and consultations | I012e0956549211e498db8b09b4f043e0 | MoJ: Protecting the vulnerable: Parents' pack (October 2010)                                           | No Author                                                                    | Published on 28-Aug-2013     | England,Wales                                        | Not displayed    | displayed       | Policy, guidance and consultations | 2-539-5825 |
    | Practice Note Overview            | I020628c51cb611e38578f7ccc38dcbee | TUPE: overview                                                                                         | Practical Law Employment                                                     | Maintained                   | United Kingdom                                       | displayed        | displayed       | Practice note: overview            | 8-202-1704 |
    | Standard Clauses                  | I2a0644671cb811e38578f7ccc38dcbee | Agency agreement tax clauses                                                                           | Practical Law Tax                                                            | Maintained                   | International,United Kingdom                         | displayed        | displayed       | Standard clauses                   | 5-513-5633 |
    | Standard Documents                | Idfa7d588e25211e398db8b09b4f043e0 | Contract for the sale of freehold land with vacant possession conditional on planning permission       | Practical Law Property                                                       | Maintained                   | England,Wales                                        | displayed        | displayed       | Standard documents                 | 8-200-0344 |
    | Toolkits                          | I3351a6f4e8da11e398db8b09b4f043e0 | Co-ownership and trusts of land toolkit                                                                | Practical Law Property                                                       | Maintained                   | England,Wales                                        | displayed        | displayed       | Toolkit                            | 2-523-5827 |
    | State Q&A                         | I7a8127a8012111e38578f7ccc38dcbee | Mini-WARN Acts: Washington                                                                             | Timothy J. O'Connell, Stoel Rives LLP, with Practical Law Labor & Employment | Law stated as at 12-May-2016 | United States                                        | Not displayed    | displayed       | State Q&A                          | 2-508-4526 |
    | Binary Document                   | I008576af7a4b11e498db8b09b4f043e0 | Informa PLC premium listing - publication of prospectus announcement dated 16 May 2014                 | No Author                                                                    | No Status                    | No Jurisdictions                                     | Not displayed    | Not displayed   | Binary Document                    | 7-590-7786 |
    | Glossary Entry                    | I0206508d1cb611e38578f7ccc38dcbee | EU Service Regulation                                                                                  | No Author                                                                    | Maintained                   | European Union,United Kingdom                        | Not displayed    | displayed       | Glossary                           | 0-339-4990 |
