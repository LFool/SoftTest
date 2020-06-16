@S2 @framework
Feature: Move the Player
  As a player
  I want to move my Pacman around on the board
  So that I can earn all points and win the game

  @S2.1:
  Scenario: The player consumes
    Given the game has started 01
    And my Pacman is next to a square containing a pellet 01
    When  I press an arrow key towards that square 01
    Then  my Pacman can move to that square 01
    And  I earn the points for the pellet 01
    And  the pellet disappears from that square 01