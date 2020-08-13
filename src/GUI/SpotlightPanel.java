package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

    public static float spotlight_intensity;
    public static Runnable runnable_intensity_changed;

    public SpotlightPanel(JFrame parent) {
        setBorder(BorderFactory.createTitledBorder("Spotlight"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Direction
        int min = -50;
        int max = 50;
        spotlight_direction_panel = new SliderControlPanel(true, min, max);
        spotlight_direction_panel.jSlider1.setValue(0); //0*50
        spotlight_direction_panel.jSlider2.setValue(0); //0*50
        spotlight_direction_panel.jSlider3.setValue(min); //-1*50

        positionControlPanel = new PositionControlPanel();

        //Enable checkbox
        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spotlight_enabled = checkBox_enable.isSelected();
                runnable_spotLight_enabled.run();
            }
        });
        checkBox_enable.setSelected(true);

        //Slider
        int min2 = 0;
        int max2 = 100;
        int value = max2/2;
        float abs = Math.abs(min2) + Math.abs(max2);
        JSlider jSlider = new JSlider(min2, max2, value);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spotlight_intensity = jSlider.getValue() / abs;
                runnable_intensity_changed.run();
            }
        });
        JPanel inner_panel_enableAndJSlider = new JPanel();
        inner_panel_enableAndJSlider.add(checkBox_enable);
        inner_panel_enableAndJSlider.add(jSlider);
        add(inner_panel_enableAndJSlider);
        //Turn on labels at major tick marks.
        jSlider.setMajorTickSpacing(100);
        jSlider.setMinorTickSpacing(10);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        
        //Color button
        JButton jButton_color = new JButton("Color");
        jButton_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose spotlight color", Color.WHITE);
                if(newColor != null) {
                    spotlightColor = newColor;
                    runnable_spotLight_color.run();
                }
            }
        });


        //Direction button
        JButton jButton_direction = new JButton("Direction");
        jButton_direction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Direction control");
                jFrame.setLocationRelativeTo(parent);
                jFrame.add(spotlight_direction_panel);
                jFrame.setVisible(true);
                jFrame.pack();
            }
        });

        //Position button
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

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(jButton_color);
        buttonsPanel.add(jButton_direction);
        buttonsPanel.add(jButton_position);

        add(buttonsPanel);
    }
}
