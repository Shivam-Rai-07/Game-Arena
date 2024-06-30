package Game.implementation;

import Game.Arena.Arena;
import Game.Arena.Player;
import Game.interfaces.GameInterface;
import java.util.Scanner;

public class GameImpl implements GameInterface {
    public void organizeGame() {
        try {
            GameImpl game = new GameImpl();
            Arena arena = game.createArena();
            game.addPlayers(arena);
            game.startTournament(arena);
            game.getWinner(arena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Arena createArena() {
        return new Arena();
    }

    public void addPlayers(Arena arena) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of participants: ");
        int num = scanner.nextInt();

        while(num <= 1) {
            System.out.println("\nNot enough players to start the tournament");
            System.out.println("\nPlease re-enter number of players:");;
            num = scanner.nextInt();
        }

        for(int i=1; i<=num; i++) {
            System.out.printf("\nPlease Enter Details of Player %d\n", i);
            arena.addPlayer(createPlayer());
        }
    }


    public Player createPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Please Enter Health: ");
        int health = getValidIntegerInput(scanner, 0, 100);
        System.out.println("Please Enter Attack: ");
        int attack = getValidIntegerInput(scanner, 0, 100);
        System.out.println("Please Enter Strength: ");
        int strength = getValidIntegerInput(scanner, 0, 100);
        return new Player(name, health, attack, strength);
    }

    public void startTournament(Arena arena) {
        Player player1 = null, player2 = null;
        Scanner scanner = new Scanner(System.in);
        String userInput = "y";
        do {
            System.out.println("\nBelow players are still part of the tournament");
            arena.displayAlivePlayers();

            System.out.println("\nChoose 2 players to start the battle out of the below players");
            System.out.println("\nEnter Player 1 number: ");
            int playerOneIdx = scanner.nextInt();
            scanner.nextLine();
            player1 = arena.getPlayer(playerOneIdx);
            if(player1 == null || !player1.isAlive()) {
                System.out.println("\nPlayer 1 not present or already eliminated");
                continue;
            }

            System.out.println("\nEnter Player 2 number: ");
            int playerTwoIdx = scanner.nextInt();
            scanner.nextLine();
            player2 = arena.getPlayer(playerTwoIdx);
            if(player2 == null || !player2.isAlive()) {
                System.out.println("\nPlayer 2 not present or already eliminated");
                continue;
            }

            Player winner = battle(player1, player2);

            if(arena.getTotalNumberOfAlivePlayers() < 2) {
                arena.setWinner(winner);
                break;
            }

            System.out.println("\nDo you want to start another match? (Y/N): ");
            userInput = scanner.nextLine();
        } while(userInput.equalsIgnoreCase("y"));
    }

    private Player battle(Player player1, Player player2) {
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

            Player temp = currentAttacker;
            currentAttacker = defender;
            defender = temp;
        }

        if(player1.isAlive()) {
            System.out.println("\nPlayer 1 wins");
            return player1;
        } else {
            System.out.println("\nPlayer 2 wins");
            return player2;
        }
    }

    public void getWinner(Arena arena) {
        Player winner = arena.getWinner();
        if(winner != null)
            System.out.printf("\nWinner of the tournament is: %s", arena.getWinner().getName());
        else
            System.out.printf("\nTournament not completed, therefore no winner");
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
