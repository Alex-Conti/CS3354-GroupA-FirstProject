package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ChessGUI extends JFrame {

    public ChessGUI() {
        setTitle("Java Chess Engine - Phase 2");
        setSize(1000, 800); // Widened to fit the side panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the History Side Panel
        JTextArea historyArea = new JTextArea(10, 15);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Move History"));
        add(scrollPane, BorderLayout.EAST);

        BoardPanel boardPanel = new BoardPanel(historyArea);
        add(boardPanel, BorderLayout.CENTER);

        setJMenuBar(createMenuBar(boardPanel));
    }

    private JMenuBar createMenuBar(BoardPanel board) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New Game");
        JMenuItem saveItem = new JMenuItem("Save Game");
        JMenuItem loadItem = new JMenuItem("Load Game");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(e -> {
            dispose();
            main(new String[0]);
        });

        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (PrintWriter out = new PrintWriter(fileChooser.getSelectedFile())) {
                    for (String s : board.getBoardData()) {
                        out.println(s.isEmpty() ? "EMPTY" : s);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        loadItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader in = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                    List<String> data = new ArrayList<>();
                    String line;
                    while ((line = in.readLine()) != null) {
                        data.add(line.equals("EMPTY") ? "" : line);
                    }
                    board.loadBoardData(data);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        
        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gameWindow = new ChessGUI();
            gameWindow.setVisible(true);
        });
    }
}