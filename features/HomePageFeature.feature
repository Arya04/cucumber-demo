#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Facebook navigate to different page
  I want to use this template for my feature file

  Background: 
    When I Login to facebook

  @tag2
  Scenario: go to friends page
    When I go to friends page
    Then I should see friends page

  Scenario Outline: post a status
    When I post a status saying "<text>"
    Then I should see status with "<text>"

    Examples: 
      | text |
      | what's up |
      | nothing much |
