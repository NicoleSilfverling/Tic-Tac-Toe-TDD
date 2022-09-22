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
    @DisplayName("Add play of x to the game board")
    public void addPlayToBoard() {
        game.gameBoard.setBoard( 1, 'X');

        assertEquals('X', game.gameBoard.getBoard()[0][0]);
    }

    @Test
    @DisplayName("Chosen spot on the game board is not empty")
    public void boardSpotIsNotEmpty() {
        game.gameBoard.setBoard( 1, 'O');

        assertFalse(game.isEmptySpot(game.gameBoard.getBoard()[0][0]));
    }

    @Test
    @DisplayName("Player X play when the number of turns is an odd number")
    public void playerXPlaysOnOddTurns() {
        char player = game.playersTurn(3);
        assertEquals('X', player);
    }
}
