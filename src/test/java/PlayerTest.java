import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import Game.Arena.Player;
import Game.Utility.RollDice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Player1", 100, 10, 5);
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, player.getHealth(), "The player's initial health should be 100");
    }

    @Test
    public void testAttack() {
        try (MockedStatic<RollDice> mockedRollDice = mockStatic(RollDice.class)) {
            mockedRollDice.when(RollDice::rollDice).thenReturn(2); // Mocking rollDice to always return 2
            int expectedAttack = 10 * 2;
            assertEquals(expectedAttack, player.attack(), "The attack value should be 20 (10 * 2)");
        }
    }

    @Test
    public void testDefend() {
        try (MockedStatic<RollDice> mockedRollDice = mockStatic(RollDice.class)) {
            mockedRollDice.when(RollDice::rollDice).thenReturn(3); // Mocking rollDice to always return 3
            int expectedDefense = 5 * 3;
            assertEquals(expectedDefense, player.defend(), "The defense value should be 15 (5 * 3)");
        }
    }

    @Test
    public void testTakeDamage() {
        player.takeDamage(30);
        assertEquals(70, player.getHealth(), "The player's health should be reduced to 70");

        player.takeDamage(80);
        assertEquals(0, player.getHealth(), "The player's health should not go below 0");
    }

    @Test
    public void testIsAlive() {
        assertTrue(player.isAlive(), "The player should be alive initially");

        player.takeDamage(100);
        assertTrue(!player.isAlive(), "The player should be dead after taking 100 damage");
    }
}
