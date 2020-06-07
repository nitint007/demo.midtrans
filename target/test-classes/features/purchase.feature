@Purchase
Feature: Purchase a pillow
Description: The feature should implement valid and invalid scenarios while buying a pillow.

Background: To add pillow to cart
Given User adds pillow to the cart

@PositiveBuy
Scenario: To check successful purchase
When Entered valid details
Then Purchase should be successful


@NegativeBuy
Scenario Outline: To check un-successful purchase
When Entered invalid details <cardNumber>
Then Purchase should be un-successful

Examples:
|cardNumber|
|4911111111111113|
|4911111111111115|