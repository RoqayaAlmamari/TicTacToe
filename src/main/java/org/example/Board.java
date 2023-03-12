package org.example;

public class Board {
    private Symbol[][] board; // 2D array to represent the board
    private int size; // the size of the board

    public Board(int size) {
        this.size = size;
        board = new Symbol[size][size]; // initialize the board with null symbols
    }

    public int getSize() {
        return size;
    }

    public void display() {
        // print out the board with '-' for empty cells and the player's symbol for occupied cells
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        // check if the board is full (all cells are occupied)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Symbol symbol) {
        // check if the specified symbol has won
        // by checking rows, columns, and diagonals
        for (int i = 0; i < size; i++) {
            int j = 0;
            while (j < size && board[i][j] == symbol) {
                j++;
            }
            if (j == size) {
                return true;
            }
        }
        for (int j = 0; j < size; j++) {
            int i = 0;
            while (i < size && board[i][j] == symbol) {
                i++;
            }
            if (i == size) {
                return true;
            }
        }
        int i = 0;
        while (i < size && board[i][i] == symbol) {
            i++;
        }
        if (i == size) {
            return true;
        }
        i = 0;
        while (i < size && board[i][size - i - 1] == symbol) {
            i++;
        }
        if (i == size) {
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        // check if the specified cell is valid (inside the board and unoccupied)
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == null;
    }

    public void makeMove(int row, int col, Symbol symbol) {
        // occupy the specified cell with the specified symbol
        board[row][col] = symbol;
    }
}
