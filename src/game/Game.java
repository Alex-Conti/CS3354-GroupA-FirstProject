package game;

import board.Board;
import board.Position;
import utils.Utils;
import java.util.Scanner;

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
        currentTurn = whitePlayer; // White always moves first
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
                    System.out.println("Valid format! (Moving from " + fromStr.toUpperCase() + " to " + toStr.toUpperCase() + ")");
                    
                    // Updates the visual board state
                    board.movePiece(from, to);
                    
                    // Switch turns
                    currentTurn = (currentTurn == whitePlayer) ? blackPlayer : whitePlayer;
                } else {
                    System.out.println("Invalid coordinates. Please stay within A1 to H8.");
                }
            } else {
                System.out.println("Invalid format. Please use [FROM] [TO] format, like 'E2 E4'.");
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