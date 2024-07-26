# Othello Game

## Overview

Othello (also known as Reversi) is a two-player strategy board game played on an 8x8 board. The game is characterized by its simple rules but deep strategy. This project implements the Othello game using Java and provides a graphical user interface (GUI) with Swing.

The game allows two players to take turns placing their pieces on the board. Each move potentially flips the opponent's pieces, and the player with the most pieces on the board at the end of the game wins.

## Features

- **Graphical User Interface (GUI)**: A Swing-based interface displaying the Othello board.
- **Game Logic**: Handles piece placement, flipping opponent pieces, and turn management.
- **Game Status**: Displays messages when the game ends with a winner or a tie.
- **Error Handling**: Shows error messages for invalid moves.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE like IntelliJ IDEA, Eclipse, or any text editor

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/othello-game.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd othello-game
   ```

3. **Compile the Java Files**:
   ```bash
   javac -d bin src/OOP4/OthelloBoard/*.java
   ```

4. **Run the Application**:
   ```bash
   java -cp bin OOP4.OthelloBoard.OthelloBoardGUI
   ```

## Usage

1. **Starting the Game**: Run the application using the command above.
2. **Playing the Game**: Click on the board cells to place your pieces. Player 1 uses "X" and Player 2 uses "O".
3. **End of Game**: The game will automatically display a message box when it ends, indicating the result.

## Screenshot

Here's a screenshot of the game in action:

![Othello Game at Start](https://github.com/uniquesp/OthelloBoard/blob/main/Screenshot%20(158).png)
![Othello Game](https://github.com/uniquesp/OthelloBoard/blob/main/Screenshot%20(159).png)


## How It Works

### `OthelloBoardLogic.java`
Contains the game logic for managing the board, making moves, and checking the game status. This class handles the rules of Othello, including piece flipping and move validation.

### `OthelloBoardGUI.java`
Provides the graphical interface for the game. It initializes the board, updates the display after each move, and handles user interactions. It also shows messages for invalid moves and game-over conditions.

## Contributing

If you have suggestions or improvements, feel free to fork the repository and submit a pull request. Please make sure to follow the project's coding style and guidelines.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy gaming!
