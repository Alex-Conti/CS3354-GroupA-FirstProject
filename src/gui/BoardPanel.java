package gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private final Color lightColor = new Color(240, 217, 181);
    private final Color darkColor = new Color(181, 136, 99);

    private final String[] blackPieces = {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"};
    private final String[] whitePieces = {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"};

    public BoardPanel() {
        setLayout(new GridLayout(8, 8));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel(new BorderLayout()); 
                
                if ((row + col) % 2 == 0) {
                    square.setBackground(lightColor);
                } else {
                    square.setBackground(darkColor);
                }
                
                JLabel pieceLabel = new JLabel("", SwingConstants.CENTER);
                pieceLabel.setFont(new Font("Arial", Font.BOLD, 24)); 

                if (row == 0) {
                    pieceLabel.setText(blackPieces[col]);
                } else if (row == 1) {
                    pieceLabel.setText("bP"); 
                } else if (row == 6) {
                    pieceLabel.setText("wP"); 
                } else if (row == 7) {
                    pieceLabel.setText(whitePieces[col]);
                }

                square.add(pieceLabel);
                add(square);
            }
        }
    }
}