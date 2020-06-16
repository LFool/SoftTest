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

  @S2.2:
  Scenario: The player moves on empty square
    Given the game has started 02
    And  my Pacman is next to an empty square 02
    When  I press an arrow key towards that square 02
    Then  my Pacman can move to that square 02
    And  my points remain the same 02

  @S2.3:
  Scenario: The move fails
    Given the game has started 03
    And my Pacman is next to a cell containing a wall 03
    When  I press an arrow key towards that cell 03
    Then  the move is not conducted 03

  @S2.4:
  Scenario: The player dies
    Given the game has started 04
    And  my Pacman is next to a cell containing a ghost 04
    When  I press an arrow key towards that square 04
    Then  my Pacman dies 04
    And  the game is over 04

  @S2.5:
  Scenario: Player wins, extends S2.1
    When  I have eaten the last pellet 05
    Then  I win the game 05