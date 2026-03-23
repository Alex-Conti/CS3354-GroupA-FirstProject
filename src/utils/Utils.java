package utils;

import board.Position;

// Holds helper functions for player movement
public class Utils {

    // Changes notation of chess piece to board position
    public static Position parsePosition(String notation) {
        if (notation == null || notation.length() != 2) return null;
        
        char file = notation.toUpperCase().charAt(0);
        char rank = notation.charAt(1);

        int column = file - 'A';
        int row = 8 - (rank - '0');

        if (column < 0 || column > 7 || row < 0 || row > 7) {
            return null; // Out of bounds
        }
        
        return new Position(row, column);
    }
}