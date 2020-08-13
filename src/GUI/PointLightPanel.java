package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointLightPanel extends JPanel {

    public static boolean pointLight_enabled;
    public static Color pointLightColor = Color.WHITE;
    public static Runnable runnable_pointLight_enable; //When user changes point light enable/disable
    public static Runnable runnable_pointLight_color; //When user changes point light color
    public static PositionControlPanel positionControlPanel;
    public static Runnable runnable_intensity_changed;
    public static float pointLight_intensity;

    public PointLightPanel(JFrame parent) {
        positionControlPanel = new PositionControlPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Point Light"));

        //Enable checkbox
        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointLight_enabled = checkBox_enable.isSelected();
                runnable_pointLight_enable.run();
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
                pointLight_intensity = jSlider.getValue() / abs;
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
        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose point light color", Color.WHITE);
                if(newColor != null) {
                    pointLightColor = newColor;
                    runnable_pointLight_color.run();
                }
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

        JPanel inner_button_panel = new JPanel();
        inner_button_panel.add(btnColor);
        inner_button_panel.add(jButton_position);

        add(inner_button_panel);
    }
}
