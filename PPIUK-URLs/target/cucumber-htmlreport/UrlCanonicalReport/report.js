$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("canonicalURLs.feature");
formatter.feature({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document",
  "description": "",
  "name": "[755712] PLC Documents indexed by search engines contain html markup to the PLC reference for the given document",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute",
  "description": "",
  "name": "Document contains link tag with canonical attribute",
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
  "name": "the user opens \u003cURL\u003e url on plcuk website",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "current url contains link tag with attribute rel\u003d\"canonical\"",
  "keyword": "Then ",
  "line": 6
});
formatter.examples({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 8,
  "rows": [
    {
      "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;1",
      "cells": [
        "URL"
      ],
      "line": 9
    },
    {
      "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;2",
      "cells": [
        "/1-107-4909"
      ],
      "line": 10
    },
    {
      "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;3",
      "cells": [
        "/7-503-7052"
      ],
      "line": 11
    },
    {
      "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;4",
      "cells": [
        "/8-382-6136"
      ],
      "line": 12
    },
    {
      "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;5",
      "cells": [
        "/6-580-7706"
      ],
      "line": 13
    }
  ]
});
formatter.scenario({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;2",
  "description": "",
  "name": "Document contains link tag with canonical attribute",
  "keyword": "Scenario Outline",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "the user opens /1-107-4909 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contains link tag with attribute rel\u003d\"canonical\"",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 100155023207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/1-107-4909",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
formatter.result({
  "duration": 7429374672,
  "status": "passed"
});
formatter.match({
  "location": "canonicalURLs.currentUrlContainsLinkTagWithAttributeRel()"
});
formatter.result({
  "duration": 53958287,
  "status": "passed"
});
formatter.scenario({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;3",
  "description": "",
  "name": "Document contains link tag with canonical attribute",
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
  "name": "the user opens /7-503-7052 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contains link tag with attribute rel\u003d\"canonical\"",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 3273792162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/7-503-7052",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
formatter.result({
  "duration": 5819341308,
  "status": "passed"
});
formatter.match({
  "location": "canonicalURLs.currentUrlContainsLinkTagWithAttributeRel()"
});
formatter.result({
  "duration": 46458299,
  "status": "passed"
});
formatter.scenario({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;4",
  "description": "",
  "name": "Document contains link tag with canonical attribute",
  "keyword": "Scenario Outline",
  "line": 12,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "the user opens /8-382-6136 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contains link tag with attribute rel\u003d\"canonical\"",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2154831066,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/8-382-6136",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
formatter.result({
  "duration": 6755775565,
  "status": "passed"
});
formatter.match({
  "location": "canonicalURLs.currentUrlContainsLinkTagWithAttributeRel()"
});
formatter.result({
  "duration": 40858800,
  "status": "passed"
});
formatter.scenario({
  "id": "[755712]-plc-documents-indexed-by-search-engines-contain-html-markup-to-the-plc-reference-for-the-given-document;document-contains-link-tag-with-canonical-attribute;;5",
  "description": "",
  "name": "Document contains link tag with canonical attribute",
  "keyword": "Scenario Outline",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "the user opens /6-580-7706 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contains link tag with attribute rel\u003d\"canonical\"",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2194288945,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/6-580-7706",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
formatter.result({
  "duration": 4956555469,
  "status": "passed"
});
formatter.match({
  "location": "canonicalURLs.currentUrlContainsLinkTagWithAttributeRel()"
});
formatter.result({
  "duration": 42796196,
  "status": "passed"
});
});