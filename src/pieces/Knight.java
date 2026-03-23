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
        // TODO: Implement 'L' shape movement logic
        return moves;
    }
}