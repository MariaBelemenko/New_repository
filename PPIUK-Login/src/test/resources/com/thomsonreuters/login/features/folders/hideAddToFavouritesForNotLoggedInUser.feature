Feature: Not logged in user should not see favourites (star) or make this my start page (house) icons.

  Scenario: As a not logged in user I do not want to see the favourites icon on documents and category pages so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When he navigate to a page "/Browse/Home/Practice/MediaTelecoms" eligible to be selected as Favourite
    Then he does not see any favourites icon/link
    And he is not able to add it to Favourites