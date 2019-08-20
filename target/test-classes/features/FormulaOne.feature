Feature: Verify formula one circuit details

  Scenario: Get circuit details
    Given We have details of formula one
    When when we send get request for
    Then Season value should be "2017" and series should be "f1"

