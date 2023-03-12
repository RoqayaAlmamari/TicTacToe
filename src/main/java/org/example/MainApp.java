package org.example;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the game
        int size = 3;
        Board board = new Board(size);

        // Prompt the user to choose between playing against another player or against the bot
        System.out.println("Choose an opponent:");
        System.out.println("1. Another player");
        System.out.println("2. Bot");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please choose again.");
            choice = scanner.nextInt();
        }

        // Initialize the players
        Player player1 = new Player("Player 1", new Symbol('X'));
        Player player2;
        if (choice == 1) {
            player2 = new Player("Player 2", new Symbol('O'));
        } else {
            player2 = new Bot(new Symbol('O'));
        }

        // Start the game
        Player currentPlayer = player1;
        while (!board.isFull() && !board.hasWon(player1.getSymbol()) && !board.hasWon(player2.getSymbol())) {
            // Display the board
           // System.out.println(board);
            board.display();

            // Prompt the current player to make a move
            System.out.println(currentPlayer.getName() + "'s turn.");
            currentPlayer.makeMove(board);

            // Switch to the other player
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        // Display the final state of the board
        //System.out.println(board);
        board.display();

        // Display the result of the game
        if (board.hasWon(player1.getSymbol())) {
            System.out.println(player1.getName() + " has won the game!");
        } else if (board.hasWon(player2.getSymbol())) {
            if (choice == 1) {
                System.out.println(player2.getName() + " has won the game!");
            } else {
                System.out.println("The bot has won the game!");
            }
        } else {
            System.out.println("The game is a tie!");
        }
    }
}
