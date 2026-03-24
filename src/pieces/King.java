package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;


// Class for King chess piece
public class King extends Piece {

    public King(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getColumn();

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] d : directions) {
            int r = row + d[0];
            int c = col + d[1];

            // Boundary
            if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                moves.add(new Position(r, c));
            }
        }

        return moves;
    }
}