$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("purchase.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# This feature file is to describe purchase related scenarios"
    }
  ],
  "line": 3,
  "name": "Purchase a pillow",
  "description": "Description: The feature should implement valid and invalid scenarios qhile buying a pillow.",
  "id": "purchase-a-pillow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@purchase"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "",
  "description": "",
  "id": "purchase-a-pillow;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@positiveBuy"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "user adds pillow to the cart",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "entered valid details",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "purchase should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "purchase.user_adds_pillow_to_the_cart()"
});
formatter.result({
  "duration": 227541477,
  "status": "passed"
});
formatter.match({
  "location": "purchase.entered_valid_details()"
});
formatter.result({
  "duration": 30581,
  "status": "passed"
});
formatter.match({
  "location": "purchase.purchase_should_be_successful()"
});
formatter.result({
  "duration": 27902,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "",
  "description": "",
  "id": "purchase-a-pillow;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@negativeBuy"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "user adds pillow to the cart",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "entered invalid details \"\u003cCardNumber\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "purchase should be un-successful",
  "keyword": "Then "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "purchase-a-pillow;;",
  "rows": [
    {
      "cells": [
        "CardNumber"
      ],
      "line": 20,
      "id": "purchase-a-pillow;;;1"
    },
    {
      "cells": [
        "4911111111111113"
      ],
      "line": 21,
      "id": "purchase-a-pillow;;;2"
    },
    {
      "cells": [
        "4911111111111115"
      ],
      "line": 22,
      "id": "purchase-a-pillow;;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 21,
  "name": "",
  "description": "",
  "id": "purchase-a-pillow;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@purchase"
    },
    {
      "line": 13,
      "name": "@negativeBuy"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "user adds pillow to the cart",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "entered invalid details \"4911111111111113\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "purchase should be un-successful",
  "keyword": "Then "
});
formatter.match({
  "location": "purchase.user_adds_pillow_to_the_cart()"
});
formatter.result({
  "duration": 124633,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4911111111111113",
      "offset": 25
    }
  ],
  "location": "purchase.entered_invalid_details(String)"
});
formatter.result({
  "duration": 2229005,
  "status": "passed"
});
formatter.match({
  "location": "purchase.purchase_should_be_un_successful()"
});
formatter.result({
  "duration": 34048,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "",
  "description": "",
  "id": "purchase-a-pillow;;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@purchase"
    },
    {
      "line": 13,
      "name": "@negativeBuy"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "user adds pillow to the cart",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "entered invalid details \"4911111111111115\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "purchase should be un-successful",
  "keyword": "Then "
});
formatter.match({
  "location": "purchase.user_adds_pillow_to_the_cart()"
});
formatter.result({
  "duration": 618905,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4911111111111115",
      "offset": 25
    }
  ],
  "location": "purchase.entered_invalid_details(String)"
});
formatter.result({
  "duration": 108742,
  "status": "passed"
});
formatter.match({
  "location": "purchase.purchase_should_be_un_successful()"
});
formatter.result({
  "duration": 42855,
  "status": "passed"
});
});