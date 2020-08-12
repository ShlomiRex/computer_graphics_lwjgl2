package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderControlPanel extends JPanel {
    public float slider1_value, slider2_value, slider3_value, slider4_value;

    public SliderControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        int min = 0;
        int max = 100;
        int value = max/2;

        JSlider jSlider1 = new JSlider(min, max, value);
        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider1_value = jSlider1.getValue() / 100f;
            }
        });

        JSlider jSlider2 = new JSlider(min, max, value);
        jSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider2_value = jSlider2.getValue() / 100f;
            }
        });

        JSlider jSlider3 = new JSlider(min, max, value);
        jSlider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider3_value = jSlider3.getValue() / 100f;
            }
        });

        JSlider jSlider4 = new JSlider(min, max, value);
        jSlider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider4_value = jSlider4.getValue() / 100f;
            }
        });

        JPanel xPanel = new JPanel();
        xPanel.add(new JLabel("x: "));
        xPanel.add(jSlider1);

        JPanel yPanel = new JPanel();
        yPanel.add(new JLabel("y: "));
        yPanel.add(jSlider2);

        JPanel zPanel = new JPanel();
        zPanel.add(new JLabel("z: "));
        zPanel.add(jSlider3);

        JPanel wPanel = new JPanel();
        wPanel.add(new JLabel("w: "));
        wPanel.add(jSlider4);

        add(xPanel);
        add(yPanel);
        add(zPanel);
        add(wPanel);
    }
}
