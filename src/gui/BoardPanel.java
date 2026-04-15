package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {

    private final Color lightColor = new Color(240, 217, 181);
    private final Color darkColor = new Color(181, 136, 99);
    private JPanel selectedSquare = null;

    public BoardPanel() {
        setLayout(new GridLayout(8, 8));
        setupInitialBoard();
    }

    private void setupInitialBoard() {
        String[] blackPieces = {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"};
        String[] whitePieces = {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"};

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel(new BorderLayout());
                square.setBackground((row + col) % 2 == 0 ? lightColor : darkColor);
                
                JLabel pieceLabel = new JLabel("", SwingConstants.CENTER);
                pieceLabel.setFont(new Font("Arial", Font.BOLD, 24)); 

                if (row == 0) pieceLabel.setText(blackPieces[col]);
                else if (row == 1) pieceLabel.setText("bP"); 
                else if (row == 6) pieceLabel.setText("wP"); 
                else if (row == 7) pieceLabel.setText(whitePieces[col]);

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