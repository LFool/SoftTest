package nl.tudelft.jpacman.e2e.framework;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class sartup2_2 {
    private Launcher launcher;
    private Player player;
    private Square square;
    private Square nextsqure;
    private int score;

    private Game game() {
        return launcher.getGame();
    }

    @Given("the game has started 02")
    public void the_game_has_started() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher = new Launcher();
        launcher.withMapFile("/simplemap2.txt");
        launcher.launch();

        launcher.getGame().start();

        assertThat(launcher.getGame().isInProgress()).isTrue();
    }

    @Given("my Pacman is next to an empty square 02")
    public void my_Pacman_is_next_to_an_empty_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();


        List<Player> players = launcher.getGame().getPlayers();
        player = players.get(0);

        score = player.getScore();
        square = player.getSquare();

        nextsqure = square.getSquareAt(Direction.WEST);

        assertThat(nextsqure.getOccupants()).isNotInstanceOfAny(Pellet.class, Player.class, Ghost.class);
    }

    @When("I press an arrow key towards that square 02")
    public void i_press_an_arrow_key_towards_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();


        launcher.getGame().move(player, Direction.WEST);
    }

    @Then("my Pacman can move to that square 02")
    public void my_Pacman_can_move_to_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();


        assertThat(player.getSquare()).isEqualTo(nextsqure);
    }

    @Then("my points remain the same 02")
    public void my_points_remain_the_same() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();

        assertThat(player.getScore()).isEqualTo(score);
        assertThat(nextsqure.getOccupants()).contains(player);
    }

    @After("@framework")
    void teardownUI() {
        launcher.dispose();
    }
}
