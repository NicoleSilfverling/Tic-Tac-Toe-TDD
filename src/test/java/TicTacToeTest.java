import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void beforeTest() {
        game = new TicTacToe();
        System.out.println("Test started");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Gameboard has 9 squares")
    public void nrOfSquaresGameboard() {
        int nrOfSquares = (game.gameBoard().length * game.gameBoard()[0].length);
        assertEquals(9, nrOfSquares);
    }

    @Test
    @DisplayName("Gameboard is empty at start of game")
    public void gameboardIsEmpty() {
        boolean boardIsEmpty = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (game.gameBoard()[i][j] == 'x' || game.gameBoard()[i][j] == 'o') {
                    boardIsEmpty = false;
                }
            }
        }
        assertTrue(boardIsEmpty);
    }

}
