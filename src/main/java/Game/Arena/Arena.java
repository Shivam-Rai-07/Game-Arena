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
        this.players.add(player);
    }

    public Player getPlayer(int num) {
        if (num < 1 || num > this.players.size())
            return null;
        return this.players.get(num-1);
    }

    public void displayAlivePlayers() {
        for(int i=0; i<this.players.size(); i++) {
            if(players.get(i).isAlive())
                System.out.printf("Player %d: , Name: %s, Health: %d\n", i+1, players.get(i).getName(), players.get(i).getHealth());
        }
    }

    public int getTotalNumberOfAlivePlayers() {
        int alivePlayersCount = 0;
        for(Player player: this.players) {
            if (player.isAlive())
                alivePlayersCount++;
        }
        return alivePlayersCount;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player player) {
        this.winner = player;
    }
}
