Feature: [755712] PLC Documents indexed by search engines contain html markup to the PLC reference for the given document

  Scenario Outline: Document contains link tag with canonical attribute
    Given PL+ user is logged in
    When the user opens <URL> url on plcuk website
    Then current url contains link tag with attribute rel="canonical"

    Examples: 
      | URL         |
      | /1-107-4909 |
      | /7-503-7052 |
      | /8-382-6136 |
      | /6-580-7706 |
