package Game.Arena;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    List<Player> players;
    private Player winner;

    public Arena() {
        winner = null;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player player) {
        winner = player;
    }
}
