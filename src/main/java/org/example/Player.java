package org.example;

import java.util.Scanner;

class Player {
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

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