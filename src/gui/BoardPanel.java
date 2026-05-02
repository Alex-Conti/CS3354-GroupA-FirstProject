package gui;

import game.Game;
import game.Player;
import board.Board;
import board.Position;
import pieces.*; 
import utils.Utils; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class BoardPanel extends JPanel {

    private final Color lightColor = new Color(240, 217, 181);
    private final Color darkColor = new Color(181, 136, 99);
    private JPanel selectedSquare = null;
    private JTextArea historyArea;
    private Game backendGame;
    private JLabel[][] guiLabels = new JLabel[8][8];

    public BoardPanel(JTextArea historyArea) {
        this.historyArea = historyArea;
        this.backendGame = new Game();
        setLayout(new GridLayout(8, 8));
        setupInitialBoard();
        updateBoardDisplay();
    }

    private void setupInitialBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel(new BorderLayout());
                square.setBackground((row + col) % 2 == 0 ? lightColor : darkColor);
                
                JLabel pieceLabel = new JLabel("", SwingConstants.CENTER);
                pieceLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
                guiLabels[row][col] = pieceLabel;

                square.add(pieceLabel);
                square.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleSquareClick(square);
                    }
                });
                add(square);
            }
        }
    }

    public void updateBoardDisplay() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                guiLabels[row][col].setText("");
                Piece currentPiece = backendGame.getBoard().getPiece(new Position(row, col));
                
                if (currentPiece != null) {
                    guiLabels[row][col].setText(getPieceAbbreviation(currentPiece));
                }
            }
        }
    }

    private String getPieceAbbreviation(Piece piece) {
        String colorPrefix = piece.getColor().equalsIgnoreCase("white") ? "w" : "b";
        String pieceType = piece.getClass().getSimpleName().substring(0, 1);
        
        if (piece.getClass().getSimpleName().equals("Knight")) {
            pieceType = "N";
        }
        
        return colorPrefix + pieceType;
    }

    private void handleSquareClick(JPanel clickedSquare) {
        JLabel clickedLabel = (JLabel) clickedSquare.getComponent(0);
        if (selectedSquare == null) {
            if (!clickedLabel.getText().isEmpty()) {
                selectedSquare = clickedSquare;
                selectedSquare.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
            }
        } else {
            JLabel selectedLabel = (JLabel) selectedSquare.getComponent(0);
            String pieceToMove = selectedLabel.getText();
            String targetPiece = clickedLabel.getText();

            historyArea.append(pieceToMove + " moved.\n");

            if (targetPiece.equals("bK") || targetPiece.equals("wK")) {
                clickedLabel.setText(pieceToMove);
                selectedLabel.setText("");
                String winner = pieceToMove.startsWith("w") ? "White" : "Black";
                JOptionPane.showMessageDialog(this, winner + " wins!");
                System.exit(0);
            }

            clickedLabel.setText(pieceToMove);
            selectedLabel.setText("");
            selectedSquare.setBorder(null);
            selectedSquare = null;
        }
    }

    public List<String> getBoardData() {
        List<String> data = new ArrayList<>();
        for (Component c : getComponents()) {
            if (c instanceof JPanel) {
                data.add(((JLabel) ((JPanel) c).getComponent(0)).getText());
            }
        }
        return data;
    }

    public void loadBoardData(List<String> data) {
        Component[] components = getComponents();
        for (int i = 0; i < data.size(); i++) {
            ((JLabel) ((JPanel) components[i]).getComponent(0)).setText(data.get(i));
        }
    }
}