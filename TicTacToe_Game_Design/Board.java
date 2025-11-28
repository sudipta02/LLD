package TicTacToe_Game_Design;

public class Board {
    private final int size;
    private final char[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean placeMove(int row, int col, char symbol) {
        if (grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        if (grid[row][col] == '-')
            return true;
        return false;
    }

    public boolean checkWinner(char symbol) {
        for (int i = 0; i < size; i++) {
            if (isRowUniform(i, symbol) || isColumnUniform(i, symbol))
                return true;
        }
        return isDiagonalUniform(symbol) || isAntiDiagonalUniform(symbol);
    }

    public boolean isRowUniform(int row, char symbol) {
        for (int col = 0; col < size; col++) {
            if (grid[row][col] != symbol)
                return false;
        }
        return true;
    }

    public boolean isColumnUniform(int col, char symbol) {
        for (int row = 0; row < size; row++) {
            if (grid[row][col] != symbol)
                return false;
        }
        return true;
    }

    public boolean isDiagonalUniform(char symbol) {
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != symbol)
                return false;
        }
        return true;
    }

    public boolean isAntiDiagonalUniform(char symbol) {
        for (int i = 0; i < size; i++) {
            if (grid[i][size - 1 - i] != symbol)
                return false;
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
