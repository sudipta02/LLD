package TicTacToe_Game_Design;

public class User {
    private int id;
    private String name;
    private PlayerStats stats;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.stats = new PlayerStats();
    }

    public String getName() {
        return name;
    }

    public void updateStats(boolean winner, boolean draw) {
        if (draw)
            stats.incrementDraw();
        else if (winner)
            stats.incrementWin();
        else
            stats.incrementLoss();
    }

    public PlayerStats getStats() {
        return stats;
    }
}
