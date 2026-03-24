package board;

import pieces.*;

/**
 * Represents the 8x8 chessboard and manages the state of all pieces.
 */
public class Board {
    // 2D array representing the 8x8 grid. Null means the square is empty.
    private Piece[][] grid;

// Board initalization and piece set up
    public Board() {
        grid = new Piece[8][8];
        initialize();
    }

public Piece getPiece(Position pos) {
        return grid[pos.getRow()][pos.getColumn()];
    }

    // Sets all chess pieces into initial array
    private void initialize() {
        // Initialize Black pieces (Top of the board: Row 0 and 1)
        grid[0][0] = new Rook("black", new Position(0, 0));
        grid[0][1] = new Knight("black", new Position(0, 1));
        grid[0][2] = new Bishop("black", new Position(0, 2));
        grid[0][3] = new Queen("black", new Position(0, 3));
        grid[0][4] = new King("black", new Position(0, 4));
        grid[0][5] = new Bishop("black", new Position(0, 5));
        grid[0][6] = new Knight("black", new Position(0, 6));
        grid[0][7] = new Rook("black", new Position(0, 7));

        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn("black", new Position(1, i));
        }

        // Initializes White pieces 
        for (int i = 0; i < 8; i++) {
            grid[6][i] = new Pawn("white", new Position(6, i));
        }

        grid[7][0] = new Rook("white", new Position(7, 0));
        grid[7][1] = new Knight("white", new Position(7, 1));
        grid[7][2] = new Bishop("white", new Position(7, 2));
        grid[7][3] = new Queen("white", new Position(7, 3));
        grid[7][4] = new King("white", new Position(7, 4));
        grid[7][5] = new Bishop("white", new Position(7, 5));
        grid[7][6] = new Knight("white", new Position(7, 6));
        grid[7][7] = new Rook("white", new Position(7, 7));
    }

     //Prints the current state of the board to the console including coordinates
    public void display() {
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int r = 0; r < 8; r++) {
            // Print the rank number (8 down to 1)
            System.out.print((8 - r) + " ");
            
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p != null) {
                    System.out.print(getPieceSymbol(p) + " ");
                } else {
                    // Create the alternating pattern for empty squares
                    if ((r + c) % 2 == 1) {
                        System.out.print("## ");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }

    // Checks for potential collision errors
    public boolean isPathClear(Position from, Position to) {
        int r1 = from.getRow();
        int c1 = from.getColumn();
        int r2 = to.getRow();
        int c2 = to.getColumn();

        int rowStep = Integer.compare(r2, r1);
        int colStep = Integer.compare(c2, c1);

        int currR = r1 + rowStep;
        int currC = c1 + colStep;

        while (currR != r2 || currC != c2) {
            if (grid[currR][currC] != null) {
                return false;
            }
            currR += rowStep;
            currC += colStep;
        }
        return true;
    }

// Updates piece position on board
    public void movePiece(Position from, Position to) {
        // Get pieces at start
        Piece pieceToMove = grid[from.getRow()][from.getColumn()];

        if (pieceToMove != null) {
            // Moves piece to new position
            grid[to.getRow()][to.getColumn()] = pieceToMove;
            
            // Empty old position
            grid[from.getRow()][from.getColumn()] = null;
            
            // Update piece's new position
            pieceToMove.move(to);
        }
    }

    // Converts object to string
    private String getPieceSymbol(Piece piece) {
        String prefix = piece.getColor().equals("white") ? "w" : "b";
        if (piece instanceof Pawn) return prefix + "p";
        if (piece instanceof Rook) return prefix + "R";
        if (piece instanceof Knight) return prefix + "N";
        if (piece instanceof Bishop) return prefix + "B";
        if (piece instanceof Queen) return prefix + "Q";
        if (piece instanceof King) return prefix + "K";
        return "??";
    }
}
