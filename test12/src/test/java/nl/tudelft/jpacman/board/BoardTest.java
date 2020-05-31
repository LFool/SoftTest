package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

class BoardTest {

    private static  Square[][] grid = {
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)}
    };

    private final Board board = new Board(grid);

    @DisplayName("边界值方法测试游戏棋盘边界")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void withinBorders(int num, int x, int y, boolean result) {
        assertThat(board.withinBorders(x, y)).isEqualTo(result);
    }
}
