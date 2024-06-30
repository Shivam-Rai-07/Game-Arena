import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Game.Arena.Arena;
import Game.Arena.Player;
import Game.implementation.GameImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Scanner;

public class GameImplTest {

    private GameImpl gameImpl;
    private Arena mockArena;
    private Scanner mockScanner;
    private Player mockPlayer1;
    private Player mockPlayer2;

    @BeforeEach
    public void setUp() {
        gameImpl = new GameImpl();
        mockArena = mock(Arena.class);
        mockScanner = mock(Scanner.class);
        mockPlayer1 = mock(Player.class);
        mockPlayer2 = mock(Player.class);
    }

    @Test
    public void testCreateArena() {
        Arena arena = gameImpl.createArena();
        assertNotNull(arena, "The created arena should not be null");
    }

    @Test
    public void testAddPlayers() {
        try (MockedStatic<Scanner> mockedScanner = mockStatic(Scanner.class)) {
            when(mockScanner.nextInt()).thenReturn(2);
            when(mockScanner.nextLine()).thenReturn("Player1", "Player2");
            when(mockScanner.next()).thenReturn("Player1", "Player2");

            doNothing().when(mockArena).addPlayer(any(Player.class));

            gameImpl.addPlayers(mockArena);

            verify(mockArena, times(2)).addPlayer(any(Player.class));
        }
    }

    @Test
    public void testCreatePlayer() {
        try (MockedStatic<Scanner> mockedScanner = mockStatic(Scanner.class)) {
            when(mockScanner.nextLine()).thenReturn("Player1");
            when(mockScanner.nextInt()).thenReturn(100, 50, 75);

            Player player = gameImpl.createPlayer();

            assertNotNull(player, "The created player should not be null");
            assertEquals("Player1", player.getName(), "The player's name should be Player1");
            assertEquals(100, player.getHealth(), "The player's health should be 100");
        }
    }

    @Test
    public void testStartTournament() {
        try (MockedStatic<Scanner> mockedScanner = mockStatic(Scanner.class)) {
            when(mockArena.getTotalNumberOfAlivePlayers()).thenReturn(2).thenReturn(1);
            when(mockScanner.nextLine()).thenReturn("y").thenReturn("n");
            when(mockScanner.nextInt()).thenReturn(1, 2);

            when(mockArena.getPlayer(1)).thenReturn(mockPlayer1);
            when(mockArena.getPlayer(2)).thenReturn(mockPlayer2);
            when(mockPlayer1.isAlive()).thenReturn(true);
            when(mockPlayer2.isAlive()).thenReturn(true);
            when(mockPlayer1.getHealth()).thenReturn(100);
            when(mockPlayer2.getHealth()).thenReturn(100);

            gameImpl.startTournament(mockArena);

            verify(mockArena, atLeastOnce()).displayAlivePlayers();
        }
    }

    @Test
    public void testGetWinner() {
        when(mockArena.getWinner()).thenReturn(mockPlayer1);
        when(mockPlayer1.getName()).thenReturn("Player1");

        gameImpl.getWinner(mockArena);

        verify(mockArena, times(1)).getWinner();
    }
}
