package TicTacToe_Game_Design;

public class PlayerStats {
    private int wins;
    private int losses;
    private int draws;

    public PlayerStats() {
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public void incrementWin() {
        wins++;
    }

    public void incrementLoss() {
        losses++;
    }

    public void incrementDraw() {
        draws++;
    }

    public int getWins() {
        return wins;
    }

    @Override
    public String toString() {
        return "Wins: " + wins + ", Losses: " + losses + ", Draws: " + draws;
    }
}
