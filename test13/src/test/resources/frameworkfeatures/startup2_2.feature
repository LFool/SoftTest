@S2 @framework
Feature: Move the Player
  As a player
  I want to move my Pacman around on the board
  So that I can earn all points and win the game

  @S2.2:
  Scenario: The player moves on empty square
    Given the game has started 02
    And  my Pacman is next to an empty square 02
    When  I press an arrow key towards that square 02
    Then  my Pacman can move to that square 02
    And  my points remain the same 02
