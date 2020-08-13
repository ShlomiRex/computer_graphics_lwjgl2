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

    public SpotlightPanel() {
        setBorder(BorderFactory.createTitledBorder("Spotlight"));
        spotlight_direction_panel = new SliderControlPanel(true);
        spotlight_direction_panel.jSlider1.setValue(0); //0*50
        spotlight_direction_panel.jSlider2.setValue(0); //0*50
        spotlight_direction_panel.jSlider3.setValue(-50); //-1*50
        spotlight_direction_panel.jSlider4.setValue(50); //1*50

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
                jFrame.add(spotlight_direction_panel);
                jFrame.setVisible(true);
                jFrame.pack();
            }
        });
        add(jButton);


    }
}
