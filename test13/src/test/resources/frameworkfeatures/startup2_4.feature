@S2 @framework
Feature: Move the Player
  As a player
  I want to move my Pacman around on the board
  So that I can earn all points and win the game

  @S2.4:
  Scenario: The player dies
    Given the game has started 04
    And  my Pacman is next to a cell containing a ghost 04
    When  I press an arrow key towards that square 04
    Then  my Pacman dies 04
    And  the game is over 04