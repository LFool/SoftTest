package nl.tudelft.jpacman.e2e.framework;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup2_4 {
    private Launcher launcher;
    private Player player;
    private Ghost ghost;
    private Square square;
    private Square nextsqure;

    private Game game() {
        return launcher.getGame();
    }

    @Given("the game has started 04")
    public void the_game_has_started() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher = new Launcher();
        launcher.withMapFile("/simplemap4.txt");
        launcher.launch();

        launcher.getGame().start();

        assertThat(launcher.getGame().isInProgress()).isTrue();
    }

    @Given("my Pacman is next to a cell containing a ghost 04")
    public void my_Pacman_is_next_to_a_cell_containing_a_ghost() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        List<Player> players = launcher.getGame().getPlayers();
        player = players.get(0);

        square = player.getSquare();

        nextsqure = square.getSquareAt(Direction.EAST);

        List<Unit> units = nextsqure.getOccupants();

        assertThat(units.size()).isEqualTo(1);
        ghost = (Ghost) units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Ghost.class);
        // assertThat(nextsqure.getOccupants()).isNotInstanceOfAny(Pellet.class, Player.class, Ghost.class);
    }

    @When("I press an arrow key towards that square 04")
    public void i_press_an_arrow_key_towards_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher.getGame().move(player, Direction.EAST);
    }

    @Then("my Pacman dies 04")
    public void my_Pacman_dies() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertThat(player.isAlive()).isFalse();
        assertThat(player.getKiller()).isEqualTo(ghost);

        assertThat(square.getOccupants()).doesNotContain(player);
    }

    @Then("the game is over 04")
    public void the_game_is_over() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertThat(launcher.getGame().isInProgress()).isFalse();
        launcher.getGame().stop();
    }

    @After("@framework")
    void teardownUI() {
        launcher.dispose();
    }
}
