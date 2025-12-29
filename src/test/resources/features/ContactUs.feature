@contact-us @regression
Feature: Contact Us Page

  Background:
    Given user navigates to ContactUs page

  @smoke
  Scenario: user enters all data in contact us form
    When user enters first name
    And user enters last name
    And user enters unique email address
    And user enters a comment
    And user clicks on submit button
    Then system displays a thank you message

  Scenario: user enters specific data in contact us form
    When user enters the first name "Hans"
    And user enters the last name "Dampf"
    And users enters the email address "hans.dampf@dampf.de"
    And user enters the comment "Mo mah du! Ja mahd den a pater a?"
    And user clicks on submit button
    Then system displays a thank you message