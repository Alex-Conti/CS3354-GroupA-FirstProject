package pieces;

import board.Position;
import java.util.List;


 // Chess pieces foundation
 
public abstract class Piece {
    protected String color;
    protected Position position;

    // Sets foundation for piece with color and starting position
    public Piece(String color, Position position) {
        this.color = color;
        this.position = position;
    }

    // Calculates possible moves of piece
    public abstract List<Position> possibleMoves();

    // Changes piece's current position
    public void move(Position newPosition) {
        this.position = newPosition;
    }

    // color of piece
    public String getColor() {
        return color;
    }

    // returns position of piece
    public Position getPosition() {
        return position;
    }
}