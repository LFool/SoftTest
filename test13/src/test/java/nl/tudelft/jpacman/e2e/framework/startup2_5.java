package nl.tudelft.jpacman.e2e.framework;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup2_5 {

    private Launcher launcher;
    private Player player;
    private Pellet pellet;
    private Level level;
    private Square square;
    private Square nextsqure;

    private Game game() {
        return launcher.getGame();
    }

    @When("I have eaten the last pellet 05")
    public void i_have_eaten_the_last_pellet() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher = new Launcher();
        launcher.withMapFile("/simplemap5.txt");
        launcher.launch();

        launcher.getGame().start();
        level = launcher.getGame().getLevel();

        assertThat(launcher.getGame().isInProgress()).isTrue();
    }

    @Then("I win the game 05")
    public void i_win_the_game() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        List<Player> players = launcher.getGame().getPlayers();
        player = players.get(0);
        Square square = player.getSquare();
        nextsqure = square.getSquareAt(Direction.EAST);

        List<Unit> units = nextsqure.getOccupants();
        pellet = (Pellet)units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Pellet.class);

        launcher.getGame().move(player, Direction.EAST);
    }

    @After("@framework")
    void teardownUI() {
        launcher.dispose();
    }
}
