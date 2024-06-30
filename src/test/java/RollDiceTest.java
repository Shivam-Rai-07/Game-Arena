import static org.junit.jupiter.api.Assertions.assertTrue;

import Game.Utility.RollDice;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RollDiceTest {

    @Test
    public void testRollDiceRange() {
        int result = RollDice.rollDice();
        assertTrue(result >= 1 && result <= 6, "The rollDice method should return a value between 1 and 6");
    }

    @RepeatedTest(100)
    public void testRollDiceMultipleRolls() {
        for (int i = 0; i < 100; i++) {
            int result = RollDice.rollDice();
            assertTrue(result >= 1 && result <= 6, "Each rollDice result should be between 1 and 6");
        }
    }
}
