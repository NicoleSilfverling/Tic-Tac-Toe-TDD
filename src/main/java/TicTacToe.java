import java.util.Scanner;

public class TicTacToe {
    GameBoard gameBoard = new GameBoard();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public void run() {

        while (true){
            System.out.println("\nWelcome to Tic Tac Toe");
            System.out.println("\nMain menu");
            System.out.println("[1] Play Game");
            System.out.println("[2] Quit");
            System.out.println("Insert your selection and hit enter");


            Scanner scanner = new Scanner(System.in);
            String menuInput = scanner.nextLine();

            if(menuInput.equals("2")){
                break;
            } else if( menuInput.equals("1")){
                System.out.println("Player X starts the game.\nLets play!");

                int turn = 1;

                while (true) {
                    // gameBoard = new GameBoard();

                    printGame();

                    while (true){
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

                    if (checkWinner(turn) == 'D'){
                        printGame();
                        System.out.println("It's a draw!");
                        break;

                    }else if (checkWinner(turn) == 'X'|| checkWinner(turn) == 'O'){
                        printGame();
                        System.out.println("Player " + checkWinner(turn) + " wins the game!");
                        break;
                    }

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
                if(gameBoard.getBoard()[i][j] == 'X'){
                    System.out.print(" " + ANSI_RED + gameBoard.getBoard()[i][j] + ANSI_GREEN + " |" + ANSI_RESET);

                }else if(gameBoard.getBoard()[i][j] == 'O'){
                    System.out.print(" " + ANSI_BLUE + gameBoard.getBoard()[i][j] + ANSI_GREEN + " |" + ANSI_RESET);

                }else
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
    // ----------------------------------------------

    public boolean isEmptySpot(int input){
        int x = gameBoard.boardSpotInArray(input)[0];
        int y = gameBoard.boardSpotInArray(input)[1];

        return gameBoard.getBoard()[x][y] != 'X' && gameBoard.getBoard()[x][y] != 'O';
    }
    // ----------------------------------------------

    public char playersTurn(int turn){
        char player;
        if(turn%2 == 1)
            player = 'X';
        else
            player = 'O';
        return player;
    }

    // ----------------------------------------------

    public char checkWinner(int turn){
        char winner = ' ';

        // Check if X wins
        //diagonal
        if (gameBoard.getBoard()[0][0] == 'X' && gameBoard.getBoard()[1][1] == 'X' && gameBoard.getBoard()[2][2] == 'X')  winner = 'X';
        if (gameBoard.getBoard()[0][2] == 'X' && gameBoard.getBoard()[1][1] == 'X' && gameBoard.getBoard()[2][0] == 'X')  winner = 'X';
        // horizontal
        if (gameBoard.getBoard()[0][0] == 'X' && gameBoard.getBoard()[0][1] == 'X' && gameBoard.getBoard()[0][2] == 'X')  winner = 'X';
        if (gameBoard.getBoard()[1][0] == 'X' && gameBoard.getBoard()[1][1] == 'X' && gameBoard.getBoard()[1][2] == 'X')  winner = 'X';
        if (gameBoard.getBoard()[2][0] == 'X' && gameBoard.getBoard()[2][1] == 'X' && gameBoard.getBoard()[2][2] == 'X')  winner = 'X';
        // vertical
        if (gameBoard.getBoard()[0][0] == 'X' && gameBoard.getBoard()[1][0] == 'X' && gameBoard.getBoard()[2][0] == 'X')  winner = 'X';
        if (gameBoard.getBoard()[0][1] == 'X' && gameBoard.getBoard()[1][1] == 'X' && gameBoard.getBoard()[2][1] == 'X')  winner = 'X';
        if (gameBoard.getBoard()[0][2] == 'X' && gameBoard.getBoard()[1][2] == 'X' && gameBoard.getBoard()[2][2] == 'X')  winner = 'X';

        if (winner == 'X' ) {
            return winner;
        }

        // Check if O wins
        //diagonal
        if (gameBoard.getBoard()[0][0] == 'O' && gameBoard.getBoard()[1][1] == 'O' && gameBoard.getBoard()[2][2] == 'O')  winner = 'O';
        if (gameBoard.getBoard()[0][2] == 'O' && gameBoard.getBoard()[1][1] == 'O' && gameBoard.getBoard()[2][0] == 'O')  winner = 'O';
        // horizontal
        if (gameBoard.getBoard()[0][0] == 'O' && gameBoard.getBoard()[0][1] == 'O' && gameBoard.getBoard()[0][2] == 'O')  winner = 'O';
        if (gameBoard.getBoard()[1][0] == 'O' && gameBoard.getBoard()[1][1] == 'O' && gameBoard.getBoard()[1][2] == 'O')  winner = 'O';
        if (gameBoard.getBoard()[2][0] == 'O' && gameBoard.getBoard()[2][1] == 'O' && gameBoard.getBoard()[2][2] == 'O')  winner = 'O';
        // vertical
        if (gameBoard.getBoard()[0][0] == 'O' && gameBoard.getBoard()[1][0] == 'O' && gameBoard.getBoard()[2][0] == 'O')  winner = 'O';
        if (gameBoard.getBoard()[0][1] == 'O' && gameBoard.getBoard()[1][1] == 'O' && gameBoard.getBoard()[2][1] == 'O')  winner = 'O';
        if (gameBoard.getBoard()[0][2] == 'O' && gameBoard.getBoard()[1][2] == 'O' && gameBoard.getBoard()[2][2] == 'O')  winner = 'O';

        if (winner == 'O' )
        {
            return winner; }

        if(turn > 9){
            winner = 'D';
            return winner;

        }
        return winner;

    }

}

