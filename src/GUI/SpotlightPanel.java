package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpotlightPanel extends JPanel {

    public static boolean spotlight_enabled;
    public static Color spotlightColor = Color.WHITE;
    public static Runnable runnable_spotLight_color; //When user changes spotlight color
    public static SliderControlPanel spotlight_direction_panel;

    public SpotlightPanel() {
        setBorder(BorderFactory.createTitledBorder("Spotlight"));

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spotlight_enabled = checkBox_enable.isEnabled();
                runnable_spotLight_color.run();
            }
        });
        add(checkBox_enable);

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose spotlight color", Color.WHITE);
                spotlightColor = newColor;
                runnable_spotLight_color.run();
            }
        });
        add(btnColor);


        JButton jButton = new JButton("Direction");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Direction control");
                spotlight_direction_panel = new SliderControlPanel(); //We create each time because to reset x,y,z,w
                jFrame.add(spotlight_direction_panel);
                jFrame.setVisible(true);
                jFrame.pack();
            }
        });
        add(jButton);


    }
}
