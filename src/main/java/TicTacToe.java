import java.util.Scanner;

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

    public boolean isValidInput(String userInput) {
        if (userInput.length() == 1) {
            char ch = userInput.charAt(0);
            if (Character.isDigit(ch) && (ch >= 1 && ch <= 9))
                return true;
        }
        return false;
    }

    public void run() {
        initializeGameBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a number:");
        String userInput = scanner.nextLine();
        boolean isValid = isValidInput(userInput);

        // printGame();

    }
}
