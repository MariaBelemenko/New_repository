$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("newUrlForTopics.feature");
formatter.feature({
  "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home",
  "description": "",
  "name": "[URLS009] new Topic URLs doesn\u0027t contain /Browse/Home",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home;make-sure-urls-do-not-contain-/browse/home",
  "description": "",
  "name": "Make sure URLs do not contain /Browse/Home",
  "keyword": "Scenario Outline",
  "line": 3,
  "type": "scenario_outline"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "the user opens \u003cPracticeAreaPageURL\u003e url on plcuk website",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "the user opens \u003cTopicName\u003e topic",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "the Topic page URL is in this format: hostname/topic/x-xxx-xxxx",
  "keyword": "Then ",
  "line": 7
});
formatter.examples({
  "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home;make-sure-urls-do-not-contain-/browse/home;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 9,
  "comments": [
    {
      "value": "#    And user sign out",
      "line": 8
    }
  ],
  "rows": [
    {
      "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home;make-sure-urls-do-not-contain-/browse/home;;1",
      "cells": [
        "PracticeAreaPageURL",
        "TopicName"
      ],
      "line": 10
    },
    {
      "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home;make-sure-urls-do-not-contain-/browse/home;;2",
      "cells": [
        "/Browse/Home/Practice/MediaTelecoms",
        "Telecoms"
      ],
      "line": 11
    }
  ]
});
formatter.scenario({
  "id": "[urls009]-new-topic-urls-doesn\u0027t-contain-/browse/home;make-sure-urls-do-not-contain-/browse/home;;2",
  "description": "",
  "name": "Make sure URLs do not contain /Browse/Home",
  "keyword": "Scenario Outline",
  "line": 11,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "the user opens /Browse/Home/Practice/MediaTelecoms url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the user opens Telecoms topic",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "the Topic page URL is in this format: hostname/topic/x-xxx-xxxx",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 94886676831,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/Browse/Home/Practice/MediaTelecoms",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
formatter.result({
  "duration": 5475532014,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Telecoms",
      "offset": 15
    }
  ],
  "location": "rendoringTopicPages.theUserOpensTopic(String)"
});
formatter.result({
  "duration": 5526759607,
  "status": "passed"
});
formatter.match({
  "location": "rendoringTopicPages.theTopicPageURLIsInCorectFormat()"
});
formatter.result({
  "duration": 59423096,
  "status": "passed"
});
});