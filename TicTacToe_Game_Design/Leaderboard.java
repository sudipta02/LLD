package TicTacToe_Game_Design;

import java.util.*;

public class Leaderboard {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void showTopPlayers() {
        users.sort((a, b) -> b.getStats().getWins() - a.getStats().getWins());
        users.forEach(u -> System.out.println(u.getName() + " -> " + u.getStats()));
    }
}
