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
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup2_1 {
    private Launcher launcher;
    private Player player;
    private Square square, nextsqure;
    private Pellet pellet;
    private int score;

    private Game game() {
        return launcher.getGame();
    }

    @Given("the game has started 01")
    public void the_game_has_started() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher = new Launcher();
        launcher.withMapFile("/simplemap1.txt");
        launcher.launch();

        launcher.getGame().start();

        assertThat(launcher.getGame().isInProgress()).isTrue();
    }

    @Given("my Pacman is next to a square containing a pellet 01")
    public void my_Pacman_is_next_to_a_square_containing_a_pellet() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        List<Player> players = launcher.getGame().getPlayers();
        player = players.get(0);
        // 存储原始分数
        score = player.getScore();
        square = player.getSquare();

        // 取豆子的方块
        nextsqure = square.getSquareAt(Direction.EAST);
        List<Unit> units = nextsqure.getOccupants();
        pellet = (Pellet) units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Pellet.class);
    }

    @When("I press an arrow key towards that square 01")
    public void i_press_an_arrow_key_towards_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        launcher.getGame().move(player, Direction.EAST);
    }

    @Then("my Pacman can move to that square 01")
    public void my_Pacman_can_move_to_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertThat(player.getSquare()).isEqualTo(nextsqure);
    }

    @Then("I earn the points for the pellet 01")
    public void i_earn_the_points_for_the_pellet() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertThat(score).isEqualTo(0);
        assertThat(player.getScore()).isEqualTo(score + pellet.getValue());
    }

    @Then("the pellet disappears from that square 01")
    public void nd_the_pellet_disappears_from_that_square() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();


        List<Unit> units = nextsqure.getOccupants();
        assertThat(units.size()).isEqualTo(1);

        // 清除pellet
        pellet.leaveSquare();

        units = nextsqure.getOccupants();
        assertThat(units.get(0)).isInstanceOf(Player.class).doesNotHaveSameClassAs(Pellet.class);
    }

    @After("@framework")
    void teardownUI() {
        launcher.dispose();
    }
}
