Feature: As a PL+ User I want to view links to�Bailii on the case asset page
  As a PL+ User I want to view links to legal updates on the case asset page
  As a PL+ User I want to view hardcoded links on the case asset page
  As a PL+ User I want to view celex links on the case asset page
  As a PL+ User I want to view link to curia.europa.eu on the case asset page

  Background:
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |

  Scenario Outline: The case assert documents contains links to�Bailii
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see links to "Bailii" Bailii
    When the user click on "Bailii" Bailii link
    Then the user is taken to "http://www.bailii.org" resource
  Examples:
    | GUID                              |
    | I984ef7466cf011e498db8b09b4f043e0 |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984f1d486cf011e498db8b09b4f043e0 |
    | I984ef7466cf011e498db8b09b4f043e0 |

  Scenario Outline: The primary source documents contains link to curia.europa.eu
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees the "curia.europa.eu" link
    When the user clicks on this "curia.europa.eu" link
    Then the user is taken to "curia.europa.eu" resource
  Examples:
    | GUID                              |
    | I1d52fc53ad5511e498db8b09b4f043e0 |

  @e2e @prod
  Scenario Outline: The case assert documents contains links to legal updates
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see links to legal updates
    When the user click on link to legal updates
    Then the user is taken to the legal updates
  Examples:
    | GUID                              |
    | I984f1d8d6cf011e498db8b09b4f043e0 |
    | I984f1db76cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |
    | I984f1d556cf011e498db8b09b4f043e0 |

  Scenario Outline: The case assert documents contains hardcoded links
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see hardcoded "<link>" links
    When the user clicks on hardcoded "<link>" link
    Then the user is taken to "<link>" resource
  Examples:
    | GUID                              | link          |
    | I6e2323994d6111e498db8b09b4f043e0 | casetrack.com |
