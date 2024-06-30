# Magical Arena Game

## Features
  - Person Creation: Creation of person replicating a person in real life.
  - Player Creation: Creation of customized players with attributes health, strength and attack.
  - Arena Configuration: Configuring an arena with customized number of players.
  - Dynamic Battles: Turn-based battles where players attack and defend using dice rolls.
  - Real-time Match Organizing: Organizing 2 players match at a time, and continuing till a winner is found
  - Automated Winner Determination: Automatically determines the winner based on player health.

## Folder Structure
  - Main: Contains the main Java files responsible for running the game.
  - Game: Houses the game logic and functionality, including player creation, arena setup, and gameplay mechanics.
  - Utility: Contains utility classes like dice rolling for game mechanics.
  - Implementation: Implements the Game interface and provides concrete implementations for game operations.
  - Test: Reserved for test files to validate the functionality of the game code.

## Classes and Packages
  - Main.java: Entry point of the application.
  - Person.java: Represents a basic person with a name.
  - Player.java: Represents a player in the game, handling attributes and dice rolling for attacks and defenses.
  - Arena.java: Manages players, displays alive players, tracks the winner, and facilitates battles between players.
  - RollDice.java: Utility class for rolling dice to simulate attacks and defenses.

## Tests
  - Unit tests are written in the Test folder to validate the functionality of game components.

## Installation

To play the Magical Arena game on your local machine, follow these steps:

```bash
    Extract the Zip File
```

```
    cd src/main/java
```

```
    javac Main.java 
```

```
    java Main 
```

For Running Test Cases


```bash
    cd src/test/java
```
```bash
    Run the ArenaTest.java File 
    Run the GameImpl.java File
    Run the Person.java File
    Run the Player.java File
    Run the RollDice.java File
```

## Commit History
https://drive.google.com/file/d/17B7ltQpzKThoKIjq86WbKPvQ9GkQZk02/view?usp=sharing