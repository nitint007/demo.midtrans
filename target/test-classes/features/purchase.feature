# This feature file is to describe purchase related scenarios
@purchase
Feature: Purchase a pillow
Description: The feature should implement valid and invalid scenarios qhile buying a pillow.

@positiveBuy
Scenario:
Given user adds pillow to the cart
When entered valid details
Then purchase should be successful


@negativeBuy
Scenario Outline:
Given user adds pillow to the cart
When entered invalid details "<CardNumber>"
Then purchase should be un-successful

Examples:
|CardNumber|
|4911111111111113|
|4911111111111115|
