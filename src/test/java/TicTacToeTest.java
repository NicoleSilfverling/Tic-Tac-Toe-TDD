import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    TicTacToe game;

    @BeforeEach
    public void beforeTest() {
        game = new TicTacToe();
        game.initializeGameBoard();
        System.out.println("Test started");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Game board has 9 squares")
    public void gameBoardHasNineSquares() {
        int nrOfSquares = game.gameBoard.getBoard().length * game.gameBoard.getBoard()[0].length;
        assertEquals(9, nrOfSquares);
    }

    @Test
    @DisplayName("Game board is empty at start of a new game")
    public void gameBoardIsEmptyWhenStaringGame() {
        boolean boardIsEmpty = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (game.gameBoard.getBoard()[i][j] == 'x' || game.gameBoard.getBoard()[i][j] == 'o') {
                    boardIsEmpty = false;
                }
            }
        }
        assertTrue(boardIsEmpty);
    }

    @Test
    @DisplayName("Only one integer is a valid input from user")
    public void shouldOnlyAcceptSingleInteger() {
        assertFalse(game.isValidInput("nine"));
    }

    @Test
    @DisplayName("Only 1-9 is valid input from user")
    public void onlyAcceptNumbersOneToNine() {
        assertFalse(game.isValidInput("0"));
    }

    @Test
    @DisplayName("Add x/o to list if square is free")
    public void addToListIfFree() {
        game.gameBoard.setBoard(0, 0, 'X');
        game.gameBoard.setBoard(0, 0, 'O');

        assertEquals('X', game.gameBoard.getBoard()[0][0]);

    }

}
