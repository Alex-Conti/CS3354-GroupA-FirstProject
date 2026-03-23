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
        // TODO: Implement horizontal and vertical movement logic
        return moves;
    }
}