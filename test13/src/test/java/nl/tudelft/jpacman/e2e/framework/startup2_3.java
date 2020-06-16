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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup2_3 {
    private Launcher launcher;
    private Player player;
    private Square square;
    private Square nextsqure;

    private Game game() {
        return launcher.getGame();
    }

    @Given("the game has started 03")
    public void the_game_has_started() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher = new Launcher();
        launcher.withMapFile("/simplemap3.txt");
        launcher.launch();

        launcher.getGame().start();

        assertThat(launcher.getGame().isInProgress()).isTrue();
    }

    @Given("my Pacman is next to a cell containing a wall 03")
    public void my_Pacman_is_next_to_a_cell_containing_a_wall() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        List<Player> players = launcher.getGame().getPlayers();
        player = players.get(0);

        square = player.getSquare();

        nextsqure = square.getSquareAt(Direction.WEST);

        List<Unit> units = nextsqure.getOccupants();
        assertThat(units.size()).isEqualTo(0);
        // assertThat(nextsqure.getOccupants()).isNotInstanceOfAny(Pellet.class, Player.class, Ghost.class);
    }

    @When("I press an arrow key towards that cell 03")
    public void i_press_an_arrow_key_towards_that_cell() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher.getGame().move(player, Direction.WEST);
    }

    @Then("the move is not conducted 03")
    public void the_move_is_not_conducted() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertThat(player.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).containsExactly(player);
        assertThat(nextsqure.getOccupants()).doesNotContain(player);
    }

    @After("@framework")
    void teardownUI() {
        launcher.dispose();
    }
}
