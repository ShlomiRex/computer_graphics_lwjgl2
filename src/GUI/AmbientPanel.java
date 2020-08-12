package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmbientPanel extends JPanel {
    public static Runnable runnable_ambientLight_intensity;
    public static int ambientLightIntensity; //Value is between 0 and 100. You can do mod math to get between 0 and 1.
    public static Runnable runnable_ambientLight_color; //When user changes ambient color
    public static Color ambientLightColor = Color.WHITE;

    public AmbientPanel() {
        setBorder(BorderFactory.createTitledBorder("Ambient Engine.Light"));

        //Slider
        int min = 0;
        int max = 100;
        int value = max/2;
        JSlider jSlider = new JSlider(min, max, value);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AmbientPanel.ambientLightIntensity = jSlider.getValue();
                AmbientPanel.runnable_ambientLight_intensity.run();
            }
        });
        add(jSlider);
        //Turn on labels at major tick marks.
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(1);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);

        //Color
        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose ambient light color", Color.WHITE);
                AmbientPanel.ambientLightColor = newColor;
                AmbientPanel.runnable_ambientLight_color.run();
            }
        });
        add(btnColor);
    }
}
