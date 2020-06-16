@S2 @framework
Feature: Move the Player
  As a player
  I want to move my Pacman around on the board
  So that I can earn all points and win the game

  @S2.3:
  Scenario: The move fails
    Given the game has started 03
    And my Pacman is next to a cell containing a wall 03
    When  I press an arrow key towards that cell 03
    Then  the move is not conducted 03