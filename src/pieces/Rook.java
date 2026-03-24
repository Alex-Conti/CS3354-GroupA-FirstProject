package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;


// Class for rook chess piece
public class Rook extends Piece {

    public Rook(String color, Position position) {
        super(color, position);
    }

@Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getColumn();

        // Directions: {rowOffset, colOffset}
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : directions) {
            for (int i = 1; i < 8; i++) {
                int r = row + (d[0] * i);
                int c = col + (d[1] * i);

                if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    moves.add(new Position(r, c));
                } else {
                    break; // Edge of board
                }
            }
        }
        return moves;
    }
}