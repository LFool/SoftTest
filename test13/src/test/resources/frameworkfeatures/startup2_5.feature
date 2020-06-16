@S2 @framework
Feature: Move the Player
  As a player
  I want to move my Pacman around on the board
  So that I can earn all points and win the game

  @S2.5:
  Scenario: Player wins, extends S2.1
    When  I have eaten the last pellet 05
    Then  I win the game 05