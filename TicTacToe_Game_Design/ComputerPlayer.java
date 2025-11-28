package TicTacToe_Game_Design;

public class ComputerPlayer extends Player {
    private final MoveStrategy strategy;

    public ComputerPlayer(User user, char symbol, Difficulty level) {
        super(user, symbol);
        switch (level) {
            case EASY:
                strategy = new RandomMoveStrategy();
                break;

            // case MEDIUM:
            // strategy = new MediumStrategy();
            // break;

            // case HARD:
            // strategy = new HardStrategy();
            // break;

            default:
                strategy = new RandomMoveStrategy();
                break;
        }
    }

    @Override
    public void makeMove(Board board) {
        int[] move = strategy.getMove(board);
        board.placeMove(move[0], move[1], getSymbol());
        System.out.println("Computer made move at " + "(" + move[0] + "," + move[1] + ")");
    }
}
