package TicTacToe_Game_Design;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Player current = player1;
        while (true) {
            board.print();
            current.makeMove(board);

            if (board.checkWinner(current.getSymbol())) {
                board.print();
                System.out.println(current.getUser().getName() + " wins !");
                updatePlayerStats(current);
                break;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("Game is draw");
                updateDrawStats();
                break;
            }

            current = (current == player1) ? player2 : player1;
        }
    }

    private void updatePlayerStats(Player current) {
        Player other = (current == player1) ? player2 : player1;
        current.getUser().updateStats(true, false);
        other.getUser().updateStats(false, false);
    }

    private void updateDrawStats() {
        player1.getUser().updateStats(false, true);
        player2.getUser().updateStats(false, true);
    }

}
