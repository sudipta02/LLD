package TicTacToe_Game_Design;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public int[] getMove(Board board) {
        Random r = new Random();
        int row = r.nextInt(board.getSize()), col = r.nextInt(board.getSize());
        while (!board.isCellEmpty(row, col)) {
            row = r.nextInt(board.getSize());
            col = r.nextInt(board.getSize());
        }

        int[] move = { row, col };
        return move;
    }
}
