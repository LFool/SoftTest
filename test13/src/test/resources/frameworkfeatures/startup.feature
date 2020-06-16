@S1 @framework
Feature: Start to play
  As a player
  I want to start the Game
  So that I can actually play the Game

  @S1.1
  Scenario: Press start button
    Given The user has lanched the game
    When The user presses the "Start" button
    Then The game is running
