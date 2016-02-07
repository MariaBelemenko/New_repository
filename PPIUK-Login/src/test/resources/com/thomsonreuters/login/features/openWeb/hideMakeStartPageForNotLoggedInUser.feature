Feature: Not logged in user should not see favourites (star) or make this my start page (house) icons.

  Scenario: I do not want to see start page icon on documents and category pages
    Given PL+ user is not logged in
    When he navigates to a page "/Browse/Home/Practice/MediaTelecoms" eligible to be selected as Start Page
    Then he does not see any Start Page icon/link
    And he is not able to select the page as start page