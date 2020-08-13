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
    public static Runnable runnable_spotLight_enabled;
    public static PositionControlPanel positionControlPanel;

    public SpotlightPanel(JFrame parent) {
        setBorder(BorderFactory.createTitledBorder("Spotlight"));
        int min = -50;
        int max = 50;
        spotlight_direction_panel = new SliderControlPanel(true, min, max);
        spotlight_direction_panel.jSlider1.setValue(0); //0*50
        spotlight_direction_panel.jSlider2.setValue(0); //0*50
        spotlight_direction_panel.jSlider3.setValue(min); //-1*50

        positionControlPanel = new PositionControlPanel();

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spotlight_enabled = checkBox_enable.isSelected();
                runnable_spotLight_enabled.run();
            }
        });
        checkBox_enable.setSelected(true);
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
                jFrame.setLocationRelativeTo(parent);
                jFrame.add(spotlight_direction_panel);
                jFrame.setVisible(true);
                jFrame.pack();
            }
        });
        add(jButton);


        JButton jButton_position = new JButton("Position");
        jButton_position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Position");
                jFrame.setLocationRelativeTo(parent);
                jFrame.add(positionControlPanel);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
        add(jButton_position);
    }
}
