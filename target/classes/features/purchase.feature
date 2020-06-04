@Purchase
Feature: Purchase a pillow
Description: The feature should implement valid and invalid scenarios qhile buying a pillow.

Background: 
Given User adds pillow to the cart

@positiveBuy
Scenario:
When Entered valid details
Then Purchase should be successful


@negativeBuy
Scenario Outline:
When Entered invalid details <cardNumber>
Then Purchase should be un-successful

Examples:
|cardNumber|
|4911111111111113|
|4911111111111115|