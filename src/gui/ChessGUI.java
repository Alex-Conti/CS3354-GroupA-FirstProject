package gui;

import javax.swing.*;
import java.awt.*;

public class ChessGUI extends JFrame {

    public ChessGUI() {
        setTitle("Java Chess Engine - Phase 2");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // TODO: Initialize and add the BoardPanel here
        // TODO: Initialize and add the MenuBar here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gameWindow = new ChessGUI();
            gameWindow.setVisible(true);
        });
    }
}