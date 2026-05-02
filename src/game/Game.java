package game;

import board.Board;
import board.Position;
import pieces.Piece;
import utils.Utils;
import java.util.Scanner;
import java.util.List;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentTurn;

    public Game() {
        board = new Board();
        whitePlayer = new Player("white");
        blackPlayer = new Player("black");
        currentTurn = whitePlayer;
    }

    public Board getBoard() {
        return this.board;
    }
    
    // NEW: Getter for the turn indicator
    public String getCurrentTurn() {
        return currentTurn.getColor().substring(0, 1).toUpperCase() + currentTurn.getColor().substring(1);
    }

    public boolean isKingAlive(String color) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = board.getPiece(new Position(r, c));
                if (p != null && p.getClass().getSimpleName().equals("King") && p.getColor().equalsIgnoreCase(color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean makeMove(Position from, Position to) {
        Piece piece = board.getPiece(from);
        
        if (piece != null && piece.getColor().equalsIgnoreCase(currentTurn.getColor())) {
            List<Position> legalMoves = piece.possibleMoves();
            boolean moveIsLegal = false;
            
            for (Position pos : legalMoves) {
                if (pos.getRow() == to.getRow() && pos.getColumn() == to.getColumn()) {
                    moveIsLegal = true;
                    break;
                }
            }

            if (moveIsLegal) {
                Piece destinationPiece = board.getPiece(to);
                if (destinationPiece != null && destinationPiece.getColor().equalsIgnoreCase(currentTurn.getColor())) {
                    return false; 
                }

                boolean pathBlocked = false;
                if (!(piece instanceof pieces.Knight)) {
                    if (!board.isPathClear(from, to)) {
                        pathBlocked = true;
                    }
                }

                if (!pathBlocked) {
                    board.movePiece(from, to);
                    currentTurn = (currentTurn == whitePlayer) ? blackPlayer : whitePlayer;
                    return true;
                }
            }
        }
        return false; 
    }

    public void start() {
        System.out.println("Welcome to Java Console Chess!");
        play();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("\n---------------------------------");
            board.display();
            System.out.println("\n" + currentTurn.getColor().toUpperCase() + "'s turn.");
            System.out.print("Enter move (e.g., 'E2 E4') or type 'quit' to exit: ");
            
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                end();
                break;
            }

            if (input.length() >= 5 && input.charAt(2) == ' ') {
                String fromStr = input.substring(0, 2);
                String toStr = input.substring(3, 5);

                Position from = Utils.parsePosition(fromStr);
                Position to = Utils.parsePosition(toStr);

                if (from != null && to != null) {
                    boolean success = makeMove(from, to);
                    if (!success) {
                        System.out.println("Invalid move. Try again.");
                    } else {
                        if (!isKingAlive("black")) {
                            System.out.println("White wins!");
                            gameRunning = false;
                        } else if (!isKingAlive("white")) {
                            System.out.println("Black wins!");
                            gameRunning = false;
                        }
                    }
                } else {
                    System.out.println("Invalid coordinates.");
                }
           }
        }
        scanner.close();
    }

    public void end() {
        System.out.println("Game end");
    }

    public static void main(String[] args) {
        Game chessGame = new Game();
        chessGame.start();
    }
}