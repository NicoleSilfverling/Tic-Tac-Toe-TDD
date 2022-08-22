import java.util.Scanner;

public class TicTacToe {
    GameBoard gameBoard = new GameBoard();

    public void run() {

        while (true) {
            // gameBoard = new GameBoard();
            System.out.println("Welcome to Tic Tac Toe");
            System.out.println("Player X starts the game.\nLets play!");

            printGame();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a number:");
            String userInput = scanner.nextLine();
            boolean isValid = isValidInput(userInput);

        }

    }

    // --------------------------------

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

    // --------------------------------

    public boolean isValidInput(String userInput) {
        if (userInput.length() == 1) {
            char ch = userInput.charAt(0);
            if (Character.isDigit(ch) && (ch >= 1 && ch <= 9))
                return true;
        }
        return false;
    }

}
