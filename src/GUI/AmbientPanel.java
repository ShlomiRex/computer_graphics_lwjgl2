package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmbientPanel extends JPanel {
    public static Runnable runnable_ambientLight_intensity;
    public static float ambientLightIntensity; //Value is between 0 and 1.
    public static Runnable runnable_ambientLight_color; //When user changes ambient color
    public static Color ambientLightColor = Color.WHITE;

    public static Runnable runnable_light_enable; //When user changes point light enable/disable
    public static boolean pointLight_enabled;

    public AmbientPanel() {
        setBorder(BorderFactory.createTitledBorder("Ambient Intensity"));

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointLight_enabled = checkBox_enable.isSelected();
                runnable_light_enable.run();
            }
        });
        checkBox_enable.setSelected(true);
        add(checkBox_enable);

        //Slider
        int min = 0;
        int max = 100;
        int value = max/2;
        JSlider jSlider = new JSlider(min, max, value);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ambientLightIntensity = jSlider.getValue() / 100f;
                runnable_ambientLight_intensity.run();
            }
        });
        add(jSlider);
        //Turn on labels at major tick marks.
        jSlider.setMajorTickSpacing(100);
        jSlider.setMinorTickSpacing(10);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);

        //Color
        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose ambient light color", Color.WHITE);
                //If user didn't pick color.
                if(newColor != null) {
                    ambientLightColor = newColor;
                    runnable_ambientLight_color.run();
                }
            }
        });
        add(btnColor);
    }
}
