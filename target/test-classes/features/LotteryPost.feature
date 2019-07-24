Feature: Verify lottery post details

  Scenario Outline: Post lottery details
    Given User post details of lottery like "<lottoId>", "<winnerId>", "<winningNumbers>" and "<winnerNumbers>"
    When Post request for lottery is initiated with "<endPoint>"
    Then Details of lottery should be posted successfully with "<statusCode>"

    Examples:
      |lottoId | winnerId |winningNumbers    | winnerNumbers | endPoint | statusCode |
      |   6    |    7     | 1;7;5;3          |  1;7;3       | lotto    |  201       |