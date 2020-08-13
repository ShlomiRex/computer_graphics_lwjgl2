package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueControlPanel extends JPanel {

    protected float value;
    private final float interval = 2f;
    private JTextField valueTextField;

    public ValueControlPanel(String value_label, float initial_value, Runnable runnable_value_changed) {
        this.value = initial_value;
        add(new JLabel(value_label + ": "));

        JButton less = new JButton("-");
        less.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value -= interval;
                setValue(value);
            }
        });

        JButton more = new JButton("+");
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value += interval;
                setValue(value);
            }
        });

        valueTextField = new JTextField();
        valueTextField.setColumns(4);
        valueTextField.setText(""+ value);
        valueTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    try {
                        value = Float.valueOf(valueTextField.getText());
                    } catch (NumberFormatException numberFormatException) {
                        System.err.println("Couldn't convert text to number");
                    }
                    runnable_value_changed.run();
                } catch (NullPointerException ex) {

                }
            }
        });

        JPanel control_panel = new JPanel();

        control_panel.add(less);
        control_panel.add(valueTextField);
        control_panel.add(more);

        add(control_panel);
    }

    public void setValue(float value) {
        this.value = value;
        valueTextField.setText(""+value);
        valueTextField.postActionEvent(); //Trigger action event.
    }

    public float getValue() {
        return value;
    }
}
