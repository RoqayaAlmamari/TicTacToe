package org.example;

public class Board {
    private Symbol[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new Symbol[size][size];
    }

    public int getSize() {
        return size;
    }

    public void display() {
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
        // Check rows
        for (int i = 0; i < size; i++) {
            int j = 0;
            while (j < size && board[i][j] == symbol) {
                j++;
            }
            if (j == size) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            int i = 0;
            while (i < size && board[i][j] == symbol) {
                i++;
            }
            if (i == size) {
                return true;
            }
        }

        // Check diagonals
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
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == null;
    }

    public void makeMove(int row, int col, Symbol symbol) {
        board[row][col] = symbol;
    }
}

