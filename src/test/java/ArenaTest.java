import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import Game.Arena.Arena;
import Game.Arena.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ArenaTest {

    private Arena arena;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        arena = new Arena();
        player1 = new Player("Player1", 100, 50, 10);
        player2 = new Player("Player2", 0, 30, 10);

        arena.addPlayer(player1);
        arena.addPlayer(player2);
    }

    @Test
    public void testAddPlayer() {
        Player player3 = new Player("Player3", 100, 30, 50);
        arena.addPlayer(player3);
        assertEquals(player3, arena.getPlayer(3), "Player3 should be the third player in the list");
    }

    @Test
    public void testGetPlayer() {
        assertEquals(player1, arena.getPlayer(1), "Player1 should be the first player in the list");
        assertEquals(player2, arena.getPlayer(2), "Player2 should be the second player in the list");
        assertNull(arena.getPlayer(3), "There should be no third player in the list");
    }

    @Test
    public void testGetTotalNumberOfAlivePlayers() {
        assertEquals(1, arena.getTotalNumberOfAlivePlayers(), "There should be one alive player in the list");
    }

    @Test
    public void testGetWinner() {
        assertNull(arena.getWinner(), "There should be no winner initially");
    }

    @Test
    public void testSetWinner() {
        arena.setWinner(player1);
        assertEquals(player1, arena.getWinner(), "Player1 should be the winner");
    }

    @Test
    public void testDisplayAlivePlayers() {
        arena.displayAlivePlayers();
    }
}
