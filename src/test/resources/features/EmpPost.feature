Feature: Verify Employee details

  Scenario Outline: Post employee details
    Given Entering employee details like "<name>", "<permanent>", "<street>", "<city>", "<zipcode>", "<phoneNumbers>", "<role>"
    When Post request for employee details is initiated with "<endPoint>"
    Then Employee Details should be posted successfully with "<statusCode>"

    Examples:
     | name | permanent  | street            | city      | zipcode       | phoneNumbers                  | role  | endPoint   | statusCode |
     | pintu   | true       | world street     | faridabad   | 121005       | 9958307606,9958307607  | Consultant   | empDetails |  201       |


  Scenario Outline: Update employee details
    Given Give employee details like "<name>", "<permanent>", "<street>", "<city>", "<zipcode>", "<phoneNumbers>", "<role>"
    When Put request for employee details is initiated with "<endPoint>", "<id>"
    Then Employee Details should be updated successfully with "<statusCode>"

    Examples:
     | name | permanent    | street         | city      | zipcode | phoneNumbers           | role        | endPoint     |  id    | statusCode |
     | Manto | true        | world street   | faridabad | 121004  | 9958307606,9958307607  | Senior QA   | empDetails   |  139  |   200      |


  Scenario: Get employee details
    Given We have employee details in application
    When Get request for employee details is initiated with "empDetails" as end point and "136" as id
    Then Role should be returned as "Senior QA"

