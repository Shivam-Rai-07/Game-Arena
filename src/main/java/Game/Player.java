package Game;

import java.util.Random;

import static Utility.RollDice.rollDice;

public class Player extends Person {
    private int health;
    private final int strength;
    private final int attack;
    Player(String name, int health, int attack, int strength) {
        super(name);
        this.health = health;
        this.attack = attack;
        this.strength = strength;
    }

    int getHealth() {
        return this.health;
    }

    int attack() {
        return this.attack*rollDice();
    }

    int defend() {
        return this.strength*rollDice();
    }

    boolean isAlive() {
        return this.health > 0;
    }
}
