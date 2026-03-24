package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;

//Class for knight chess piece
public class Knight extends Piece {

    public Knight(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getColumn();

        // Possible moves
        int[][] knightMoves = {
            {row - 2, col - 1}, {row - 2, col + 1},
            {row + 2, col - 1}, {row + 2, col + 1},
            {row - 1, col - 2}, {row - 1, col + 2},
            {row + 1, col - 2}, {row + 1, col + 2}
        };

        for (int[] move : knightMoves) {
            int r = move[0];
            int c = move[1];

            // Checks boundaries
            if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                moves.add(new Position(r, c));
            }
        }

        return moves;
    }
}