package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BottomPanel extends JPanel {
    private Map<Character, String> instructions = new HashMap<Character, String>();

    public BottomPanel(JFrame parent) {
        instructions.put('W', "Move forward ");
        instructions.put('S', "Move backward ");
        instructions.put('A', "Move left ");
        instructions.put('D', "Move right ");
        instructions.put('Z', "Move down ");
        instructions.put('X', "Move up ");
        instructions.put('T', "Head left");
        instructions.put('Y', "Head right");
        instructions.put('U', "Head up");
        instructions.put('I', "Head down");
        instructions.put('7', "Tail left");
        instructions.put('8', "Tail right");
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
                JOptionPane.showMessageDialog(parent, "Shlomi & Shlomi");
            }
        });

        JButton btn_help = new JButton("Help");
        btn_help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += "Controls\n\n";
                int i = 1;
                for (char c : instructions.keySet()) {
                    message += String.format("%d) %s - %s \n", i, c, instructions.get(c));
                    i++;
                }
                message += "\n\nTo rotate, press Left mouse and drag";
                JOptionPane.showMessageDialog(parent, message);
            }
        });

        add(btn_help);
        add(credits);
        add(quit);
    }
}
