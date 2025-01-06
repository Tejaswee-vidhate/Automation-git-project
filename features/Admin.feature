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
@tag
Feature: Facebook Login
  I want to use this template for my feature file

  @valid
  Scenario: Login with valid credential
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When user enters email as "admin@yourstore.com" and password as "admin"
    When User click login button
    Then User verify page title should be "Dashboard/nopcommerce administration"
    Then close  browser
   @DataDriven
    Scenario Outline: Login data driven
    Given User launch chrome browser
    When User open url "<url>"
    When user enters email as "<email>" and password as "<password>"
    When User click login button
    Then User verify page title should be "Dashboard/nopcommerce administration"
    Then close  browser

    Examples: 
      | url                                      | email                  | password  |
      | https://admin-demo.nopcommerce.com/login | admin@yourstore.com    | admin     |
      | https://admin-demo.nopcommerce.com/login | admin123@yourstore.com | admin123  |
