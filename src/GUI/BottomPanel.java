package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {
    public BottomPanel() {
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton credits = new JButton("Credits");
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Shlomi & Shlomi");
            }
        });

        JButton btn_help = new JButton("Help");
        btn_help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += "Controls\n\n1)W - Move forward\n2)S - Move backward\n3)A - Move left\n4)D - Move right";
                message += "\n5)Z - Move down\n6)X - Move up";
                message += "\n\nTo rotate, press Right and drag";
                JOptionPane.showMessageDialog(null, message);
            }
        });

        add(btn_help);
        add(credits);
        add(quit);
    }
}
