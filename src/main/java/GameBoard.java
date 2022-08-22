public class GameBoard {
    private char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

    int squareNr = 1;

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, char input) {
        if (board[x][y] != 'X' && board[x][y] != 'O')
            board[x][y] = input;
    }
}
