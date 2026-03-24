package game;

import board.Board;
import board.Position;
import pieces.Piece;
import utils.Utils;
import java.util.Scanner;
import java.util.List;

// Controller for chess match
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

            // Checks for proper formatting
            if (input.length() >= 5 && input.charAt(2) == ' ') {
                String fromStr = input.substring(0, 2);
                String toStr = input.substring(3, 5);

                Position from = Utils.parsePosition(fromStr);
                Position to = Utils.parsePosition(toStr);

                if (from != null && to != null) {
                    Piece piece = board.getPiece(from);
                    
                    if (piece != null && piece.getColor().equals(currentTurn.getColor())) {
                        List<Position> legalMoves = piece.possibleMoves();
                        boolean moveIsLegal = false;
                        
                        for (Position pos : legalMoves) {
                            if (pos.getRow() == to.getRow() && pos.getColumn() == to.getColumn()) {
                                moveIsLegal = true;
                                break;
                            }
                        }

                        if (moveIsLegal) {
                            board.movePiece(from, to);
                            currentTurn = (currentTurn == whitePlayer) ? blackPlayer : whitePlayer;
                        } else {
                            System.out.println("Invalid move for that piece");
                        }
                    } else {
                        System.out.println("No piece of your color there.");
                    }
                } else {
                    System.out.println("Invalid coordinates.");
                }
            } else {
                System.out.println("Invalid format. Use 'E2 E4'.");
            }
        }
        scanner.close();
    }

    public void end() {
        System.out.println("Game end");
    }

    // Runs game from terminal
    public static void main(String[] args) {
        Game chessGame = new Game();
        chessGame.start();
    }
}