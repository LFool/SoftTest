package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapParserTest {

    private final LevelFactory levelCreator = Mockito.mock(LevelFactory.class);
    private final BoardFactory boardCreator = Mockito.mock(BoardFactory.class);
    private final Square wall = Mockito.mock(Square.class);
    private final Square ground = Mockito.mock(Square.class);
    private final Square palletSquare = Mockito.mock(Square.class);
    private final Square playerSquare = Mockito.mock(Square.class);
    private final Square ghostSquare = Mockito.mock(Square.class);
    private final Pellet pellet = Mockito.mock(Pellet.class);
    private final Ghost ghost = Mockito.mock(Ghost.class);
    private final List<String> string = null;

    private MapParser mapParser;
    /**
     * create a before each.
     */
    @BeforeEach
    void setup() {
        mapParser = new MapParser(levelCreator, boardCreator);
        Mockito.when(boardCreator.createGround()).thenReturn(ground);
        Mockito.when(boardCreator.createWall()).thenReturn(wall);
        Mockito.when(levelCreator.createPellet()).thenReturn(pellet);
        Mockito.when(boardCreator.createGround()).thenReturn(playerSquare);
        Mockito.when(boardCreator.createGround()).thenReturn(ghostSquare);
        Mockito.when(boardCreator.createGround()).thenReturn(palletSquare);
        Mockito.when(levelCreator.createGhost()).thenReturn(ghost);
    }


    /**
     *Nice Weather test for checking ground is created when empty space is passed.
     */
    @Test
    void forGround() {
        mapParser.parseMap(Lists.newArrayList(" "));
        Mockito.verify(boardCreator).createGround();
    }

    /**
     * Nice weather test for checking if wall is created when "#" is passed.
     */

    @Test
    void forWall() {
        mapParser.parseMap(Lists.newArrayList("#"));
        Mockito.verify(boardCreator).createWall();
    }

    /**
     * Nice weather test for creating a pallet in the square when "." is passed.
     */

    @Test
    void forPallet() {
        mapParser.parseMap(Lists.newArrayList("."));
        Mockito.verify(boardCreator).createGround();
        Mockito.verify(levelCreator).createPellet();
        Mockito.verify(pellet).occupy(palletSquare);
    }

    /**
     * Nice weather test for creating a player.
     */

    @Test
    void forPlayer() {
        mapParser.parseMap(Lists.newArrayList("P"));
        Mockito.verify(boardCreator).createGround();
        Mockito.verify(levelCreator).createLevel(Mockito.any(),
            Mockito.anyList(), Mockito.anyList());
    }

    /**
     * Bad weather Test for mapParser with null input.
     */
    @Test
    void noInput() {
        try {
            mapParser.parseMap(string);
        }
        catch (PacmanConfigurationException e) {
            assertThat(e.getMessage()).contains("Input text cannot be null.");
        }
    }



    /**
     * Bad weather test for MapParser should ensure equal width.
     */
    @Test
    void equalWidth() {
        try {
            mapParser.parseMap(Lists.newArrayList("##", "   "));
        }
        catch (PacmanConfigurationException e){
            assertThat(e.getMessage()).contains("Input text lines are not of equal width.");
        }
    }


    /**
     * Bad Weather Test for empty input
     */
    @Test
    void errorEmptyList() {
        try {
            mapParser.parseMap(Lists.newArrayList());
        }
        catch (PacmanConfigurationException e) {
            assertThat(e.getMessage()).contains("Input text must consist of at least 1 row.");

        }
    }


    /**
     * Bad weather Test for mapParser with 0 width.
     */
    @Test
    void zeroWidth() {
        try {
            mapParser.parseMap(Lists.newArrayList(""));
        }
        catch (PacmanConfigurationException e) {
            assertThat(e.getMessage()).contains("Input text lines cannot be empty.");
        }
    }

}
