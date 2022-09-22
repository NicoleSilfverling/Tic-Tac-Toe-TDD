import java.util.Scanner;

public class TicTacToe {
    GameBoard gameBoard = new GameBoard();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public void run() {

        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Player X starts the game.\nLets play!");

        int turn = 1;

        while (true) {
            // gameBoard = new GameBoard();

            printGame();

            while (true){

                Scanner scanner = new Scanner(System.in);
                System.out.print("Player " + playersTurn(turn) + " turn\nChoose a number: ");
                String userInput = scanner.nextLine();


                if(isValidInput(userInput) ){
                     int boardSpot = Integer.parseInt(userInput);
                     if (isEmptySpot(boardSpot)){
                         gameBoard.setBoard(boardSpot, playersTurn(turn));
                         turn += 1;
                     break;
                     }
                     else
                         System.out.println("Spot is already taken, try an empty spot");
                }
                else{
                    System.out.println("You must choose a number between 1-9, please try again");
                }
            }


        }

    }

    // --------------------------------

    public void printGame() {
        System.out.println(ANSI_GREEN + "-------------" + ANSI_RESET);

        for (int i = 0; i < 3; i++) {
            System.out.print(ANSI_GREEN + "|" + ANSI_RESET);
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBoard.getBoard()[i][j] + ANSI_GREEN + " |" + ANSI_RESET);
            }
            System.out.println(ANSI_GREEN + "\n-------------" + ANSI_RESET);
        }
    }

    // --------------------------------

    public boolean isValidInput(String userInput) {
        boolean isValid = false;

        if (userInput.length() == 1 ) {
            char ch = userInput.charAt(0);
            if (Character.isDigit(ch) && ch != '0'){
                isValid = true;
            }
        }
        return isValid;

    }

    public boolean isEmptySpot(int input){
        int x = gameBoard.boardSpotInArray(input)[0];
        int y = gameBoard.boardSpotInArray(input)[1];

        if(gameBoard.getBoard()[x][y] != 'X' && gameBoard.getBoard()[x][y] != 'O'){
            return true;

        }

        return false;
    }

    public char playersTurn(int turn){
        char player= ' ';
        if(turn%2 == 1)
            player = 'X';
        else
            player = 'O';
        return player;
    }

}
