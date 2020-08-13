package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PositionControlPanel extends JPanel {

    public ValueControlPanel xAxis, yAxis, zAxis;
    public Runnable runnable_when_position_value_changed_in_gui;

    public PositionControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Pointer to runnable which is initialized only after this.
        Runnable position_changed = () -> {
            runnable_when_position_value_changed_in_gui.run();
        };

        xAxis = new ValueControlPanel("x", 0, position_changed);
        yAxis = new ValueControlPanel("y", 0, position_changed);
        zAxis = new ValueControlPanel("z", 0, position_changed);

        add(xAxis);
        add(yAxis);
        add(zAxis);
    }
}
