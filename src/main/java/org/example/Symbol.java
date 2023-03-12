package org.example;

// Represents a symbol (X or O) used on the board
class Symbol {
    private char symbol;

    // Constructs a symbol with the specified character
    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    // Returns the character representing the symbol
    public char getSymbol() {
        return symbol;
    }
}
