Feature: Test Webpage

  Background: 
    Given User launches the url
    And User verifies the title
    And User verifies the heading

  Scenario: Palindrome Positive Check
    When User enters value for palindrome check
    And Clicks on palindrome Submit button
    Then User should be able to verify the palindrome result

  Scenario: Anagram Positive Check
    When User enters value for anagram check
    And Clicks on anagram Submit button
    Then User should be able to verify the anagram result
