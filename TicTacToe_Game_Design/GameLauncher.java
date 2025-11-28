package TicTacToe_Game_Design;

public class GameLauncher {
    public static void main(String[] args) {
        User computer = new User(0, "AI");
        User user1 = new User(1, "Sudipta");
        Player p1 = new HumanPlayer(user1, 'X');
        Player p2 = new ComputerPlayer(computer, 'O', Difficulty.EASY);

        Game game = new Game(new Board(3), p1, p2);
        game.play();

        Leaderboard lb = new Leaderboard();
        lb.addUser(user1);
        lb.addUser(computer);
        lb.showTopPlayers();
    }
}
