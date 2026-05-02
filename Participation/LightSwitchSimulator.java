package Participation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightSwitchSimulator {

    private boolean isLightOn = false;
    private JLabel lightLabel;

    public LightSwitchSimulator() {
        JFrame frame = new JFrame("Light Switch Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        lightLabel = new JLabel("Light is OFF");
        lightLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton switchButton = new JButton("Toggle Light");

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLightOn = !isLightOn;
                if (isLightOn) {
                    lightLabel.setText("Light is ON");
                } else {
                    lightLabel.setText("Light is OFF");
                }
            }
        });

        frame.add(lightLabel);
        frame.add(switchButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LightSwitchSimulator();
            }
        });
    }
}