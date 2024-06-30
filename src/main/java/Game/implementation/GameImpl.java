package Game.implementation;

import Game.Arena.Arena;
import Game.Arena.Player;
import Game.interfaces.GameInterface;

import java.util.Scanner;

public class GameImpl implements GameInterface {
    public static void organizeGame() {
        GameImpl game = new GameImpl();
        Arena arena = game.createArena();
        game.addPlayers(arena);
        game.startMatch(arena);
    }

    public Arena createArena() {
        return new Arena();
    }

    public void addPlayers(Arena arena) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the total number of participants: ");
        int num = scn.nextInt();

        if (num <= 1)
            System.out.println("Not enough players to start the tournament:"); // Need to implement

        for(int i=1; i<=num; i++) {
            System.out.printf("Please Enter Details of Player %d", i);
            arena.addPlayer(createPlayer());
        }
    }

    public Player createPlayer() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please Enter Name: ");
        String name = scn.nextLine();
        System.out.println("Please Enter Health: ");
        int health = getValidIntegerInput(scn, 0, 100);
        System.out.println("Please Enter Attack: ");
        int attack = getValidIntegerInput(scn, 0, 100);
        System.out.println("Please Enter Strength: ");
        int strength = getValidIntegerInput(scn, 0, 100);
        return new Player(name, health, attack, strength);
    }

    public void startMatch(Arena arena) {
        Player player1 = null, player2 = null;
        Scanner scanner = new Scanner(System.in);
        String userInput = "y";
        do {
            System.out.println("Below players are part of the tournament\n");
            arena.displayPlayers();
            System.out.println("\nChoose 2 players to start the battle out of the below players");

            System.out.println("\nEnter Player 1 number: ");
            int playerOneIdx = scanner.nextInt();
            System.out.println("\nEnter Player 2 number: ");
            int playerTwoidx = scanner.nextInt();
            player1 = arena.getPlayer(playerOneIdx);
            player2 = arena.getPlayer(playerTwoidx);

            if(player1 == null || player2 == null || player1.isAlive() || player2.isAlive()) {
                System.out.println("Wrong players selected, choose alive correct players");
                continue;
            }

            battle(player1, player2);

            if(arena.getTotalNumberOfAlivePlayers() < 1)
                break;

            System.out.println("Do you want to start another match? (Y/N): ");
            userInput = scanner.nextLine();
        } while(userInput.equalsIgnoreCase("y"));
    }

    private void battle(Player player1, Player player2) {
        Player currentAttacker = player1.getHealth() > player2.getHealth() ? player2 : player1;
        Player defender = currentAttacker == player1 ? player2 : player1;

        while(player1.isAlive() && player2.isAlive()){
            int attackValue = currentAttacker.attack();
            int defenceValue = defender.defend();
            int damage = Math.max(0, attackValue - defenceValue);
            defender.takeDamage(damage);
            System.out.println(currentAttacker.getName() + " attacks " + defender.getName() +
                    " with damage " + attackValue + ", defended " + defenceValue +
                    ", " + defender.getName() + "'s health now " + defender.getHealth());
            currentAttacker = defender;
        }

        if(player1.isAlive()) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 winds");
        }
    }

    private int getValidIntegerInput(Scanner scanner, int min, int max){
        int input;
        while(true){
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Input out of range. Please enter a value between " + min + " and " + max + ":");
            }
        }
        return input;
    }
}
