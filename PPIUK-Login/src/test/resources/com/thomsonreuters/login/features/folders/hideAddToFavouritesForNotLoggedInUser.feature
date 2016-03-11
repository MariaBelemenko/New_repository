Feature:  [757145] Not logged in user should not see favourites (star) or make this my start page (house) icons.

  Scenario: [757145] As a not logged in user I do not want to see the favourites icon on documents and category pages so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When he navigate to a page "/Browse/Home/Practice/MediaTelecoms" eligible to be selected as Favourite
    Then he does not see any favourites icon/link

  Scenario: [757145] I do not want to see start page icon on documents and category pages
    Given PL+ user is not logged in
    When he navigates to a page "/Browse/Home/Practice/MediaTelecoms" eligible to be selected as Start Page
    Then he does not see any Start Page icon/link