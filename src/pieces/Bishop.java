package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;


//Class for bishop chess piece
public class Bishop extends Piece {

    public Bishop(String color, Position position) {
        super(color, position);
    }

@Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getColumn();

        // Directions: Top-Left, Top-Right, Bottom-Left, Bottom-Right
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

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