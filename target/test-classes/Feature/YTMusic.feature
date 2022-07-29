Feature: Youtube Music Basic
  Scenario: I want to Open Youtube Music with Login
    Given I Open browser
    And Open website Youtube Music
    And Click Sign in
    When I input valid username and password
    Then I success login to Youtube Music

  Scenario: I want to Search a Music
    Given I Open browser
    And Open website Youtube Music
    When I search "NOAH"
    Then Showing result related with "NOAH"

  Scenario: I want to Play Music
    Given I Open browser
    And Open website Youtube Music
    When I click play
    Then Playing a random music