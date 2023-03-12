/**

 Represents a player in the game.
 */
package org.example;
import java.util.Scanner;

class Player {
    private String name; // the name of the player
    private Symbol symbol; // the symbol used by the player (X or O)

    /**
     * Constructor for creating a new player object.
     *
     * @param name   the name of the player
     * @param symbol the symbol used by the player (X or O)
     */
    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the symbol used by the player.
     *
     * @return the symbol used by the player
     */
    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Asks the player to make a move by inputting the row and column numbers,
     * and then updates the board with the player's move.
     *
     * @param board the board object representing the game board
     */
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print(name + ", enter row and column (1-" + board.getSize() + "): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!board.isValidMove(row, col));
        board.makeMove(row, col, symbol);
    }
}