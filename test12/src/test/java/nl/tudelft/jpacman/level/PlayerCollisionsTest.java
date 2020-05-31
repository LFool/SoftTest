package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PlayerCollisionsTest {

    private PlayerCollisions playerCollisions;
    private PointCalculator pointCalculator;

    @BeforeEach
    void setUp() {
        pointCalculator = mock(PointCalculator.class);
        playerCollisions = new PlayerCollisions(pointCalculator);
    }

    @Test
    @DisplayName("Player移动到Ghost的位置")
    void playerCollisideGhost() {
        Player player = mock(Player.class);
        Ghost ghost = mock(Ghost.class);

        playerCollisions.collide(player, ghost);

        verify(pointCalculator).collidedWithAGhost(player, ghost);
        verify(player).setAlive(false);
        verify(player).setKiller(ghost);
    }

    @Test
    @DisplayName("Player移动到Pellet的位置")
    void playerCollisidePellet() {
        Player player = mock(Player.class);
        Pellet pellet = mock(Pellet.class);

        playerCollisions.collide(player, pellet);

        verify(pointCalculator).consumedAPellet(player, pellet);
        verify(pellet).leaveSquare();
    }

    @Test
    @DisplayName("Player移动到Player的位置")
    void playerCollisidePlayer() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        playerCollisions.collide(player1, player2);

        verifyZeroInteractions(player1, player2);
    }

    @Test
    @DisplayName("Ghost移动到Ghost的位置")
    void ghostCollisideGhost() {
        Ghost ghost1 = mock(Ghost.class);
        Ghost ghost2 = mock(Ghost.class);

        playerCollisions.collide(ghost1, ghost2);

        verifyZeroInteractions(ghost1, ghost2);
    }

    @Test
    @DisplayName("Ghost移动到Player的位置")
    void ghostCollosidePlayer() {
        Ghost ghost = mock(Ghost.class);
        Player player = mock(Player.class);

        playerCollisions.collide(ghost, player);

        verify(pointCalculator).collidedWithAGhost(player, ghost);
        verify(player).setAlive(false);
        verify(player).setKiller(ghost);
    }

    @Test
    @DisplayName("Ghost移动到Pellet的位置")
    void ghostCollisidePellet() {
        Ghost ghost = mock(Ghost.class);
        Pellet pellet = mock(Pellet.class);

        playerCollisions.collide(ghost, pellet);

        verifyZeroInteractions(ghost, pellet);
    }

}
