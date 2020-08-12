package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointLightPanel extends JPanel {

    public static boolean pointLight_enabled;
    public static Color pointLightColor = Color.WHITE;
    public static Runnable runnable_pointLight_enable; //When user changes point light enable/disable
    public static Runnable runnable_pointLight_color; //When user changes point light color

    public PointLightPanel() {
        setBorder(BorderFactory.createTitledBorder("Point Engine.Light"));

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointLight_enabled = checkBox_enable.isSelected();
                runnable_pointLight_enable.run();
            }
        });
        add(checkBox_enable);

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose point light color", Color.WHITE);
                pointLightColor = newColor;
                runnable_pointLight_color.run();
            }
        });
        add(btnColor);


    }
}
