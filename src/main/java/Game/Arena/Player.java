package Game.Arena;

import static Game.Utility.RollDice.rollDice;

public class Player extends Person {
    private int health;
    private final int strength;
    private final int attack;

    public Player(String name, int health, int attack, int strength) {
        super(name);
        this.health = health;
        this.attack = attack;
        this.strength = strength;
    }

    public int getHealth() {
        return this.health;
    }


    public int attack() {
        return this.attack*rollDice();
    }

    public int defend() {
        return this.strength*rollDice();
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
