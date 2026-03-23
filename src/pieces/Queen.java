package pieces;

import board.Position;
import java.util.ArrayList;
import java.util.List;

//Class for Queen chess piece
public class Queen extends Piece {

    public Queen(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> moves = new ArrayList<>();
        // TODO: Implement combined straight and diagonal movement logic
        return moves;
    }
}