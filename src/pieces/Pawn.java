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
        int row = position.getRow();
        int col = position.getColumn();
        int direction = color.equals("white") ? -1 : 1;

        // one space forward
        if (isValidPos(row + direction, col)) {
            moves.add(new Position(row + direction, col));
        }

        // two spaces forward
        boolean isStartingRank = (color.equals("white") && row == 6) || (color.equals("black") && row == 1);
        if (isStartingRank && isValidPos(row + (2 * direction), col)) {
            moves.add(new Position(row + (2 * direction), col));
        }

        // captures diagonally
        if (isValidPos(row + direction, col - 1)) moves.add(new Position(row + direction, col - 1));
        if (isValidPos(row + direction, col + 1)) moves.add(new Position(row + direction, col + 1));

        return moves;
    }

    private boolean isValidPos(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }
}