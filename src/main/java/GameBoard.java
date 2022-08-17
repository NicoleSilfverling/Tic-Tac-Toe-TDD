public class GameBoard {
    private char[][] board = new char[3][3];

    int squareNr = 1;

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, char input) {
        if (board[x][y] != 'X' || board[x][y] != 'X')
            board[x][y] = input;
    }
}
