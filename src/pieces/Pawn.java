package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;

//Class for pawn chess piece
public class Pawn extends Piece {

    public Pawn(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        // TODO: Implement forward movement and diagonal capture logic
        return moves;
    }
}