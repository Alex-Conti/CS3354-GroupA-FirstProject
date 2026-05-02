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
                            Piece destinationPiece = board.getPiece(to);
                            if (destinationPiece != null && destinationPiece.getColor().equals(currentTurn.getColor())) {
                                System.out.println("You cannot capture your own piece!");
                                continue;
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
                            } else {
                                System.out.println("Path is blocked by another piece!");
                            }
                        } else {
                            System.out.println("Invalid move for that piece!");
                        }
                    } else {
                        System.out.println("No piece of your color there.");
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