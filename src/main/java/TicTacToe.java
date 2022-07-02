public class TicTacToe {
    GameBoard gameBoard;

    public void initializeGameBoard() {
        gameBoard = new GameBoard();
        int squareNr = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.getBoard()[i][j] != 'x' || gameBoard.getBoard()[i][j] != 'o') {
                    char chNr = Integer.toString(squareNr).charAt(0);
                    gameBoard.setBoard(i, j, chNr);
                }
                squareNr++;
            }
        }
    }

    public void printGame() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBoard.getBoard()[i][j] + " |");
            }
            System.out.println("\n-------------");
        }
    }

    public void run() {
        initializeGameBoard();
        printGame();

    }
}
