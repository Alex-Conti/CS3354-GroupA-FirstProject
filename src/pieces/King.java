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
        // TODO: Implement single-square movement logic in all directions
        return moves;
    }
}