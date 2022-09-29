public class GameBoard {
    private char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int input, char playerSymbol) {
        switch (input) {
            case 1 -> board[0][0] = playerSymbol;
            case 2 -> board[0][1] = playerSymbol;
            case 3 -> board[0][2] = playerSymbol;
            case 4 -> board[1][0] = playerSymbol;
            case 5 -> board[1][1] = playerSymbol;
            case 6 -> board[1][2] = playerSymbol;
            case 7 -> board[2][0] = playerSymbol;
            case 8 -> board[2][1] = playerSymbol;
            case 9 -> board[2][2] = playerSymbol;
            default -> {
            }
        }
    }

    public int[] boardSpotInArray(int input) {
        int[] spotInList = new int[2];
        if (input == 1) {
            spotInList[0] = 0;
            spotInList[1] = 0;
        } else if (input == 2) {
            spotInList[0] = 0;
            spotInList[1] = 1;
        } else if (input == 3) {
            spotInList[0] = 0;
            spotInList[1] = 2;
        } else if (input == 4) {
            spotInList[0] = 1;
            spotInList[1] = 0;
        } else if (input == 5) {
            spotInList[0] = 1;
            spotInList[1] = 1;
        } else if (input == 6) {
            spotInList[0] = 1;
            spotInList[1] = 2;
        } else if (input == 7) {
            spotInList[0] = 2;
            spotInList[1] = 0;
        } else if (input == 8) {
            spotInList[0] = 2;
            spotInList[1] = 1;
        } else if (input == 9) {
            spotInList[0] = 2;
            spotInList[1] = 2;
        }

        return spotInList;
    }


}
