package TicTacToe_Game_Design;

public abstract class Player {
    private User user;
    private char symbol;

    public Player(User user, char symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);

    public char getSymbol() {
        return symbol;
    }

    public User getUser() {
        return user;
    }
}
