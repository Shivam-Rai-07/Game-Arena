import Game.implementation.GameImpl;

public class Main {
    public static void main(String[]args){
        System.out.println("\n***Welcome to Magical Game Arena***\n");
        GameImpl gameImpl = new GameImpl();
        gameImpl.organizeGame();
    }
}
