Feature: [URLS009] new Topic URLs doesn't contain /Browse/Home

  Scenario Outline: Make sure URLs do not contain /Browse/Home
    Given PL+ user is logged in
    When the user opens <PracticeAreaPageURL> url on plcuk website
    When the user opens <TopicName> topic
    Then the Topic page URL is in this format: hostname/topic/x-xxx-xxxx
#    And user sign out
  Examples:
    | PracticeAreaPageURL                 | TopicName     |
    | /Browse/Home/Practice/MediaTelecoms | Telecoms      |
#    | /Browse/Home/Practice/MediaTelecoms | Internet      |
#    | /Browse/Home/Practice/MediaTelecoms | General media |
#    | /Browse/Home/Practice/MediaTelecoms | Privacy       |
#    | /Browse/Home/Practice/MediaTelecoms | Film          |
#    | /Browse/Home/Practice/MediaTelecoms | Music         |
#    | /Browse/Home/Practice/MediaTelecoms | Social media  |
#    | /Browse/Home/Practice/MediaTelecoms | TV            |