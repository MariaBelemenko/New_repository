Feature: Entity ID testing scenarios

  Scenario Outline: Entity ID Testing by Serial number
    Given the user queries "<SerialNumber>" in the GetSerialNumber URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal to Metatool results
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              | SerialNumber |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 | 403782068    |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 | 428630600    |
    | External resource | 6-386-1748 | Ic3c6d4f9e83311e398db8b09b4f043e0 | 403795052    |
    | Standard Document | 6-376-3125 | I33f12c0ce8cd11e398db8b09b4f043e0 | 403942386    |
    | Case Tracker      | 4-200-6833 | I0b3ad5eae01011e398db8b09b4f043e0 | 403536373    |

  Scenario Outline: Entity ID Testing by Doc GUID
    Given the user queries "<GUID>" in the GetGUIDNumber URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal to Metatool results
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              |
    | Practice Note     | 7-203-1181 | I640a4d77010811e498db8b09b4f043e0 |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 |
    | External resource | 6-386-1748 | Ic3c6d4f9e83311e398db8b09b4f043e0 |
    | Standard Document | 6-376-3125 | I33f12c0ce8cd11e398db8b09b4f043e0 |
    | Case Tracker      | 4-200-6833 | I0b3ad5eae01011e398db8b09b4f043e0 |

  Scenario Outline: Entity ID Testing by Serial number and Pub number
    Given the user queries "<SerialNumber>" and "<PubNumber>" in the GetSerialPubNumber URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal to Metatool results
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              | SerialNumber | PubNumber |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 | 403782068    | 220810    |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 | 428630600    | 220805    |
    | External resource | 6-386-1748 | Ic3c6d4f9e83311e398db8b09b4f043e0 | 403795052    | 220800    |
    | Standard Document | 6-376-3125 | I33f12c0ce8cd11e398db8b09b4f043e0 | 403942386    | 220813    |
    | Case Tracker      | 4-200-6833 | I0b3ad5eae01011e398db8b09b4f043e0 | 403536373    | 220794    |

  Scenario Outline: Entity ID Testing by Family GUID for case locator
    Given the user queries "<Family GUID>" in the GetCaseLocatorFamilyGUID URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal to Metatool results
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              | Family GUID                       |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 | I99185201e83711e398db8b09b4f043e0 |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 | I1218b4c3d91f11e498db8b09b4f043e0 |
    | Case 1            | null       | I344DCE30E42811DA8FC2A0F0355337E9 | IC3F8D260E57111DAB242AFEA6182DD7E |
    | Case 2            | null       | I6F2E9701E42811DA8FC2A0F0355337E9 | ID995F6C0E57111DAB242AFEA6182DD7E |

  Scenario: Entity ID Testing for a UK Research Doc
    Given the user queries "I8400C1E0C5DD11DEB1DBCF8C0012BED5" in the GetCaseLocatorFamilyGUID URL
    And the user extracts the values for "I7B32D820C5D111DE8405B6EF4FE8F8F3" from the MetaTools URL
    Then the results should be equal for "I7B32D820C5D111DE8405B6EF4FE8F8F3"

  Scenario Outline: Entity ID Testing by GUID for case locator
    Given the user queries "<GUID>" in the GetCaseLocatorDocGUID URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal to Metatool results
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 |
    | Case 1            | null       | I344DCE30E42811DA8FC2A0F0355337E9 |
    | Case 2            | null       | I6F2E9701E42811DA8FC2A0F0355337E9 |

  Scenario Outline: Entity ID Testing by GUID for case locator by POST request url
    Given the user queries the PostCaseLocatorDocGUID URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal for "<GUID>"
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 |
    | Case 1            | null       | I344DCE30E42811DA8FC2A0F0355337E9 |
    | Case 2            | null       | I6F2E9701E42811DA8FC2A0F0355337E9 |

  Scenario Outline: Entity ID Testing by Family GUID for case locator by POST request url
    Given the user queries the PostCaseLocatorDocGUID URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results should be equal for "<Family GUID>"
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              | Family GUID                       |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 | I99185201e83711e398db8b09b4f043e0 |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 | I1218b4c3d91f11e498db8b09b4f043e0 |
    | Case 1            | null       | I344DCE30E42811DA8FC2A0F0355337E9 | IC3F8D260E57111DAB242AFEA6182DD7E |
    | Case 2            | null       | I6F2E9701E42811DA8FC2A0F0355337E9 | ID995F6C0E57111DAB242AFEA6182DD7E |

  Scenario Outline: Entity ID Testing by Serial number and Pub number in Post request
    Given the user queries the PostCaseLocatorDocGUID URL
    And the user extracts the values for "<GUID>" from the MetaTools URL
    Then the Entity ID results for "<SerialNumber>" and "<PubNumber>" should be equal
  Examples:
    | PLC document TYPE | PlcRef     | GUID                              | SerialNumber | PubNumber |
    | Practice Note     | 9-376-4010 | Ib5556d4de83211e398db8b09b4f043e0 | 403782068    | 220810    |
    | Legal Update      | 6-581-7526 | I864e6172d91d11e498db8b09b4f043e0 | 428630600    | 220805    |
    | External resource | 6-386-1748 | Ic3c6d4f9e83311e398db8b09b4f043e0 | 403795052    | 220800    |
    | Standard Document | 6-376-3125 | I33f12c0ce8cd11e398db8b09b4f043e0 | 403942386    | 220813    |
    | Case Tracker      | 4-200-6833 | I0b3ad5eae01011e398db8b09b4f043e0 | 403536373    | 220794    |
    | Case 1            | null       | I7B32D820C5D111DE8405B6EF4FE8F8F3 | 2020221896   | 4924      |
