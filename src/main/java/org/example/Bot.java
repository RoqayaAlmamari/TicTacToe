package org.example;

class Bot extends Player {

    //constructor

    public Bot(Symbol symbol) {
        super("Bot", symbol);
    }

    @Override
    public void makeMove(Board board) {
        int size = board.getSize();

        // Check if bot can win in next move
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    board.makeMove(i, j, getSymbol());
                    if (board.hasWon(getSymbol())) {
                        return;
                    }
                    board.makeMove(i, j, null);
                }
            }
        }

        // Check if opponent can win in next move
        Symbol opponentSymbol = getSymbol().getSymbol() == 'X' ? new Symbol('O') : new Symbol('X');
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    board.makeMove(i, j, opponentSymbol);
                    if (board.hasWon(opponentSymbol)) {
                        board.makeMove(i, j, getSymbol());
                        return;
                    }
                    board.makeMove(i, j, null);
                }
            }
        }

        // Choose random move
        int row, col;
        do {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        } while (!board.isValidMove(row, col));
        board.makeMove(row, col, getSymbol());
    }
}
