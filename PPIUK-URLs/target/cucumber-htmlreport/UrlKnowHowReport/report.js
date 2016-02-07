$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("correctDisplayOfKHDocumentURLInBrowser.feature");
formatter.feature({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx)",
  "description": "",
  "name": "[742387] When a user clicks on a KH Document link, the URL in the browser displays the PLC Ref type URL (X-XXX-XXX)",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser",
  "description": "",
  "name": "Correct PLC Reference is displayed in the browser",
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
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to page with PLCRef",
  "keyword": "Then ",
  "line": 7
});
formatter.examples({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 8,
  "rows": [
    {
      "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;1",
      "cells": [
        "URL"
      ],
      "line": 9
    },
    {
      "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;2",
      "cells": [
        "/1-107-4909"
      ],
      "line": 10
    },
    {
      "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;3",
      "cells": [
        "/8-382-6136"
      ],
      "line": 11
    },
    {
      "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;4",
      "cells": [
        "/6-580-7706"
      ],
      "line": 12
    }
  ]
});
formatter.scenario({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;2",
  "description": "",
  "name": "Correct PLC Reference is displayed in the browser",
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
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to page with PLCRef",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 94395087493,
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
  "duration": 7149694228,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 66219199,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef()"
});
formatter.result({
  "duration": 35574388258,
  "status": "failed",
  "error_message": "java.lang.AssertionError: Document doesnt contain PLC ref: https://a.uk.practicallaw.demo.thomsonreuters.com/4-508-2913?originationContext\u003ddocument\u0026transitionType\u003dPLDocumentLink\u0026contextData\u003d(sc.Default)\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.thomsonreuters.urls.step_definitions.knowHow.rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef(rendoringKHDocumentByURL.java:43)\r\n\tat ✽.Then all links to KH Documents with PLC Ref on the page takes user to page with PLCRef(correctDisplayOfKHDocumentURLInBrowser.feature:7)\r\n"
});
formatter.scenario({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;3",
  "description": "",
  "name": "Correct PLC Reference is displayed in the browser",
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
  "name": "the user opens /8-382-6136 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to page with PLCRef",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2172357798,
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
  "duration": 5102700977,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 63010245,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef()"
});
formatter.result({
  "duration": 28807396194,
  "status": "failed",
  "error_message": "java.lang.AssertionError: Document doesnt contain PLC ref: https://a.uk.practicallaw.demo.thomsonreuters.com/0-503-9375?originationContext\u003ddocument\u0026transitionType\u003dPLDocumentLink\u0026contextData\u003d(sc.Default)\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.thomsonreuters.urls.step_definitions.knowHow.rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef(rendoringKHDocumentByURL.java:43)\r\n\tat ✽.Then all links to KH Documents with PLC Ref on the page takes user to page with PLCRef(correctDisplayOfKHDocumentURLInBrowser.feature:7)\r\n"
});
formatter.scenario({
  "id": "[742387]-when-a-user-clicks-on-a-kh-document-link,-the-url-in-the-browser-displays-the-plc-ref-type-url-(x-xxx-xxx);correct-plc-reference-is-displayed-in-the-browser;;4",
  "description": "",
  "name": "Correct PLC Reference is displayed in the browser",
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
  "name": "the user opens /6-580-7706 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to page with PLCRef",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2221786871,
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
  "duration": 4961675565,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 51670851,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef()"
});
formatter.result({
  "duration": 101849015570,
  "status": "failed",
  "error_message": "java.lang.AssertionError: Document doesnt contain PLC ref: https://a.uk.practicallaw.demo.thomsonreuters.com/D-027-3161?originationContext\u003ddocument\u0026transitionType\u003dPLDocumentLink\u0026contextData\u003d(sc.Default)\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.thomsonreuters.urls.step_definitions.knowHow.rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToPageWithPLCRef(rendoringKHDocumentByURL.java:43)\r\n\tat ✽.Then all links to KH Documents with PLC Ref on the page takes user to page with PLCRef(correctDisplayOfKHDocumentURLInBrowser.feature:7)\r\n"
});
formatter.uri("rendoringKHDocumentByURL.feature");
formatter.feature({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.",
  "description": "",
  "name": "[742386] User clicks on a KH Document URL with a PLC Reference in a Document and it takes them to that document.",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document",
  "description": "",
  "name": "Correct PLC Reference is displayed and user is taken to the correct document",
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
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to correct page",
  "keyword": "Then ",
  "line": 7
});
formatter.examples({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 8,
  "rows": [
    {
      "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;1",
      "cells": [
        "URL"
      ],
      "line": 9
    },
    {
      "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;2",
      "cells": [
        "/1-107-4909"
      ],
      "line": 10
    },
    {
      "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;3",
      "cells": [
        "/8-382-6136"
      ],
      "line": 11
    },
    {
      "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;4",
      "cells": [
        "/6-580-7706"
      ],
      "line": 12
    }
  ]
});
formatter.scenario({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;2",
  "description": "",
  "name": "Correct PLC Reference is displayed and user is taken to the correct document",
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
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to correct page",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2230952592,
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
  "duration": 4950903845,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 53478123,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToCorrectPage()"
});
formatter.result({
  "duration": 256204433637,
  "status": "passed"
});
formatter.scenario({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;3",
  "description": "",
  "name": "Correct PLC Reference is displayed and user is taken to the correct document",
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
  "name": "the user opens /8-382-6136 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to correct page",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 83847898,
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
  "duration": 4269792194,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 54567433,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToCorrectPage()"
});
formatter.result({
  "duration": 60776879933,
  "status": "passed"
});
formatter.scenario({
  "id": "[742386]-user-clicks-on-a-kh-document-url-with-a-plc-reference-in-a-document-and-it-takes-them-to-that-document.;correct-plc-reference-is-displayed-and-user-is-taken-to-the-correct-document;;4",
  "description": "",
  "name": "Correct PLC Reference is displayed and user is taken to the correct document",
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
  "name": "the user opens /6-580-7706 url on plcuk website",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "current url contain PLC Ref",
  "keyword": "Then ",
  "line": 6
});
formatter.step({
  "name": "all links to KH Documents with PLC Ref on the page takes user to correct page",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 76262683,
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
  "duration": 5025393119,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.currentUrlContainPLCRef()"
});
formatter.result({
  "duration": 49515061,
  "status": "passed"
});
formatter.match({
  "location": "rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToCorrectPage()"
});
formatter.result({
  "duration": 90276926542,
  "status": "failed",
  "error_message": "org.openqa.selenium.InvalidSelectorException: The given selector co_title noTOC is either invalid or does not result in a WebElement. The following error occurred:\nInvalidSelectorError: Compound class names not permitted\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/invalid_selector_exception.html\nBuild info: version: \u00272.48.2\u0027, revision: \u002741bccdd\u0027, time: \u00272015-10-09 19:59:12\u0027\nSystem info: host: \u0027U0171579-TPD-Y\u0027, ip: \u002710.194.240.144\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_60\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 144 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/invalid_selector_exception.html\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027UC172487-TPL-A\u0027, ip: \u002710.44.22.236\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.7.0_51\u0027\n*** Element info: {Using\u003dclass name, value\u003dco_title noTOC}\nSession ID: 00cf679a-8e95-4d25-857f-5eb51c58512c\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{platform\u003dWINDOWS, javascriptEnabled\u003dtrue, acceptSslCerts\u003dtrue, browserName\u003dfirefox, rotatable\u003dfalse, locationContextEnabled\u003dtrue, webdriver.remote.sessionid\u003d00cf679a-8e95-4d25-857f-5eb51c58512c, version\u003d37.0.2, cssSelectorsEnabled\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, webStorageEnabled\u003dtrue, nativeEvents\u003dfalse, applicationCacheEnabled\u003dtrue, takesScreenshot\u003dtrue}]\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:526)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:595)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:373)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsByClassName(RemoteWebDriver.java:433)\r\n\tat org.openqa.selenium.By$ByClassName.findElements(By.java:380)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:336)\r\n\tat com.thomsonreuters.driver.framework.AbstractPage.findElements(AbstractPage.java:151)\r\n\tat com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage.isDocumentBlockPresent(KHDocumentPage.java:24)\r\n\tat com.thomsonreuters.urls.step_definitions.knowHow.rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToCorrectPage(rendoringKHDocumentByURL.java:33)\r\n\tat ✽.Then all links to KH Documents with PLC Ref on the page takes user to correct page(rendoringKHDocumentByURL.feature:7)\r\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027UC172487-TPL-A\u0027, ip: \u002710.44.22.236\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.7.0_51\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:138)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:595)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:373)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementsByClassName(RemoteWebDriver.java:433)\r\n\tat org.openqa.selenium.By$ByClassName.findElements(By.java:380)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElements(RemoteWebDriver.java:336)\r\n\tat com.thomsonreuters.driver.framework.AbstractPage.findElements(AbstractPage.java:151)\r\n\tat com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage.isDocumentBlockPresent(KHDocumentPage.java:24)\r\n\tat com.thomsonreuters.urls.step_definitions.knowHow.rendoringKHDocumentByURL.allLinksToKHDocumentsOnThePageTakesUserToCorrectPage(rendoringKHDocumentByURL.java:33)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:606)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:283)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:173)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:153)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:128)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:203)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:155)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:103)\r\nCaused by: org.openqa.selenium.InvalidSelectorException: The given selector co_title noTOC is either invalid or does not result in a WebElement. The following error occurred:\nInvalidSelectorError: Compound class names not permitted\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/invalid_selector_exception.html\nBuild info: version: \u00272.48.2\u0027, revision: \u002741bccdd\u0027, time: \u00272015-10-09 19:59:12\u0027\nSystem info: host: \u0027U0171579-TPD-Y\u0027, ip: \u002710.194.240.144\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_60\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/invalid_selector_exception.html\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027UC172487-TPL-A\u0027, ip: \u002710.44.22.236\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.7.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.annotateInvalidSelectorError_(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10633)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementsInternal_(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10691)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElements(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10695)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12534)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12539)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/uc172487/AppData/Local/Temp/anonymous3031812811455214863webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12481)\r\n"
});
formatter.uri("userCanSeeKHDocument.feature");
formatter.feature({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser",
  "description": "",
  "name": "[URLS001] User can see a KH Document in PL+ by entering PLC document in browser",
  "keyword": "Feature",
  "line": 2
});
formatter.scenarioOutline({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 4,
  "type": "scenario_outline"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user opens \u003cURL\u003e url on plcuk website",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "the document opens correctly with PLC Ref",
  "keyword": "Then ",
  "line": 7
});
formatter.examples({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 8,
  "rows": [
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;1",
      "cells": [
        "URL"
      ],
      "line": 9
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;2",
      "cells": [
        "/1-107-4909"
      ],
      "line": 10
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;3",
      "cells": [
        "/7-503-7052"
      ],
      "line": 11
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;4",
      "cells": [
        "/8-382-6136"
      ],
      "line": 12
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;5",
      "cells": [
        "/6-580-7706"
      ],
      "line": 13
    }
  ]
});
formatter.scenario({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;2",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user opens /1-107-4909 url on plcuk website",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the document opens correctly with PLC Ref",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2606087044,
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
  "duration": 5194725734,
  "status": "passed"
});
formatter.match({
  "location": "userCanSeeKHDocument.theDocumentOpensCorrectlyWithPLCRef()"
});
formatter.result({
  "duration": 181767025,
  "status": "passed"
});
formatter.scenario({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;3",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 11,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user opens /7-503-7052 url on plcuk website",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the document opens correctly with PLC Ref",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 1971558869,
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
  "duration": 5052117533,
  "status": "passed"
});
formatter.match({
  "location": "userCanSeeKHDocument.theDocumentOpensCorrectlyWithPLCRef()"
});
formatter.result({
  "duration": 87055711,
  "status": "passed"
});
formatter.scenario({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;4",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 12,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user opens /8-382-6136 url on plcuk website",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the document opens correctly with PLC Ref",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 2093979654,
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
  "duration": 4224115016,
  "status": "passed"
});
formatter.match({
  "location": "userCanSeeKHDocument.theDocumentOpensCorrectlyWithPLCRef()"
});
formatter.result({
  "duration": 87815145,
  "status": "passed"
});
formatter.scenario({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;5",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "the user opens /6-580-7706 url on plcuk website",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the document opens correctly with PLC Ref",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 3246519860,
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
  "duration": 4294451751,
  "status": "passed"
});
formatter.match({
  "location": "userCanSeeKHDocument.theDocumentOpensCorrectlyWithPLCRef()"
});
formatter.result({
  "duration": 165248180,
  "status": "passed"
});
formatter.scenarioOutline({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 15,
  "type": "scenario_outline"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 16
});
formatter.step({
  "name": "the user opens \u003cURL\u003e url on plcuk website",
  "keyword": "When ",
  "line": 17
});
formatter.step({
  "name": "the user is redirected to an error page",
  "keyword": "Then ",
  "line": 18
});
formatter.examples({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 19,
  "rows": [
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;1",
      "cells": [
        "URL"
      ],
      "line": 20
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;2",
      "cells": [
        "/456456"
      ],
      "line": 21
    },
    {
      "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;3",
      "cells": [
        "/abracadabra"
      ],
      "line": 22
    }
  ]
});
formatter.scenario({
  "id": "[urls001]-user-can-see-a-kh-document-in-pl+-by-entering-plc-document-in-browser;;;2",
  "description": "",
  "name": "",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "PL+ user is logged in",
  "keyword": "Given ",
  "line": 16
});
formatter.step({
  "name": "the user opens /456456 url on plcuk website",
  "keyword": "When ",
  "line": 17,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "the user is redirected to an error page",
  "keyword": "Then ",
  "line": 18
});
formatter.match({
  "location": "CommonLoginNaviagtionSteps.plUserIsLoggedIn()"
});
formatter.result({
  "duration": 3110299889,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/456456",
      "offset": 15
    }
  ],
  "location": "URLsCommonBehaviorPLCUK.theUserOpensUrlOnPLCUKSite(String)"
});
