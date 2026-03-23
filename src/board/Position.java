package board;


// Finds position on chessboard
public class Position {
    private int row;
    private int column;

    // constructs position instance
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // returns position index
    public int getRow() {
        return row;
    }

    // returns position column
    public int getColumn() {
        return column;
    }
}