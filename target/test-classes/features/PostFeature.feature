Feature: Verify post details

  Scenario Outline: Post author details
    Given User post details like "<title>" and "<author>"
    When Post request is initiated with "<endPoint>"
    Then Details should be posted successfully with "<statusCode>"

    Examples:
      | title | author | endPoint | statusCode |
      | newEight | vj8   | posts     | 201       |