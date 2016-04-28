@wip
Feature: [848166] Test for bug Document not showing images/logos

  Scenario Outline: Test for bug 848166 Document not showing images/logos
    Given PL+ user is logged in
     When the user opens <DocUrl> url on plcuk website
     Then the user should see logos for contributing firms on new site
     Then the user opens <DocUrl> on the old practical law website
     Then the user should see logos for contributing firms on old site
     Then the count of links should be identical on new and legacy site

    Examples: 
      | DocUrl     |
      | /3-383-5789 |
