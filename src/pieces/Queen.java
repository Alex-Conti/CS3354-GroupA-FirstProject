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
        // Combines Rook and Bishop movement
        moves.addAll(new Rook(color, position).possibleMoves());
        moves.addAll(new Bishop(color, position).possibleMoves());
        return moves;
    }
}