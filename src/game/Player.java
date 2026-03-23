package game;

import pieces.Piece;
import java.util.ArrayList;
import java.util.List;

// Class to represent player
public class Player {
    private String color;
    private List<Piece> availablePieces;

    public Player(String color) {
        this.color = color;
        this.availablePieces = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }
}