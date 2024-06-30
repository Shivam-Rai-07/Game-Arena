package Game.Utility;

import java.util.Random;

public class RollDice {
    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
