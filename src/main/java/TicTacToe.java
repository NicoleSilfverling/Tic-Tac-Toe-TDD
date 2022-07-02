public class TicTacToe {

    public char[][] gameBoard() {
        char[][] gameBoard = new char[3][3];
        int squareNr = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char chNr = Integer.toString(squareNr).charAt(0);
                gameBoard[i][j] = chNr;
                squareNr++;
            }
        }
        return gameBoard;
    }

    public void printGame() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBoard()[i][j] + " |");
            }
            System.out.println("\n-------------");
        }
    }

    public void run() {
        gameBoard();
        printGame();

    }
}
