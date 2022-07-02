import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    GameBoard board;

    @BeforeEach
    public void beforeTest() {
        board = new GameBoard();
        System.out.println("Test started");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Game board has 9 squares")
    public void gameBoardHasNineSquares() {
        int nrOfSquares = (board.getBoard().length * board.getBoard()[0].length);
        assertEquals(9, nrOfSquares);
    }

    @Test
    @DisplayName("Game board is empty at start of a new game")
    public void gameBoardIsEmptyWhenStaringGame() {
        boolean boardIsEmpty = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board.getBoard()[i][j] == 'x' || board.getBoard()[i][j] == 'o') {
                    boardIsEmpty = false;
                }
            }
        }
        assertTrue(boardIsEmpty);
    }

}
