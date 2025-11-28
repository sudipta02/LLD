package TicTacToe_Game_Design;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(User user, char symbol) {
        super(user, symbol);
    }

    @Override
    public void makeMove(Board board) {
        System.out.println(getUser().getName() + "(" + getSymbol() + "), enter row and column: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        while (!board.placeMove(row, col, getSymbol())) {
            System.out.println("Invalid move! try again");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
    }
}
