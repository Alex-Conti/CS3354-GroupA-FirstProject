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
        // TODO: Implement diagonal movement logic
        return moves;
    }
}