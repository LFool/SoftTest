package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GameTest {

    private SinglePlayerGame game;
    private Level level;

    @BeforeEach
    void setup() {
        level = mock(Level.class);
    }

    @Test
    @Order(1)
    @DisplayName("有豆子无玩家存活，则游戏结束")
    void testNoPlayAlive() {
        // Arrange
        when(level.isAnyPlayerAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(23);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        // act
        game.start();

        // assert
        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("没有豆子没有玩家存活，游戏结束")
    @Order(2)
    void testNoPelletsNoPlayerAlive() {
        // Arrange
        when(level.isAnyPlayerAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(0);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        // act
        game.start();

        // assert
        assertThat(game.isInProgress()).isFalse();

    }


    @Test
    @DisplayName("有豆子且有玩家存活，游戏进行中")
    @Order(3)
    void testHasPelletsAndPlayerAlive() {
        // Arrange
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(20);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        // act
        game.start();

        // assert
        assertThat(game.isInProgress()).isTrue();

    }

    @Test
    @DisplayName("没有豆子但有玩家存活，游戏结束")
    @Order(4)
    void testNoPelletsAndPlayerAlive() {
        // Arrange
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(0);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        // act
        game.start();

        // assert
        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("游戏进行中再次调用start，状态不变")
    @Order(5)
    void testReStart() {

        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(23);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
        assertThat(game.isInProgress()).isFalse();

        game.start();
        assertThat(game.isInProgress()).isTrue();

        game.start();
        assertThat(game.isInProgress()).isTrue();

        verify(level, times(1)).isAnyPlayerAlive();
        verify(level, times(1)).remainingPellets();

    }


}
