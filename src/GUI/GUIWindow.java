package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIWindow {
    private JFrame window;
    private JPanel panel;

    //Camera panel
    private JPanel jpanel_cameraSelect;
    private JRadioButton radioBtn_cameraSelect_external;
    private JRadioButton radioBtn_cameraSelect_dog;
    public static Runnable runnable_camera_external;
    public static Runnable runnable_camera_dog;

    //Help panel
    private JPanel jpanel_help;

    //Ambient panel
    private AmbientPanel jpanel_ambientLight;

    //Bottom panel
    private JPanel jpanel_bottomControl;

    //Point light panel
    private JPanel jpanel_pointLight;

    //Spotlight
    private JPanel jpanel_spotlight;

    public GUIWindow(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        window.add(panel);

        initPanel_CameraSelect();
        initPanel_Help();

        jpanel_ambientLight = new AmbientPanel();
        panel.add(jpanel_ambientLight);

        jpanel_pointLight = new PointLightPanel();
        panel.add(jpanel_pointLight);

        jpanel_spotlight = new SpotlightPanel();
        panel.add(jpanel_spotlight);

        jpanel_bottomControl = new BottomPanel();
        panel.add(jpanel_bottomControl);
    }

    private void initPanel_Help() {
        jpanel_help = new JPanel();
        JButton btn_help = new JButton("Help");
        btn_help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += "Controls\n\n1)W - Move forward\n2)S - Move backward\n3)A - Move left\n4)D - Move right";
                message += "\n5)Z - Move down\n6)X - Move up";
                message += "\n\nTo rotate, press Right Engine.Input.Mouse and drag";
                JOptionPane.showMessageDialog(null, message);
            }
        });
        jpanel_help.add(btn_help);

        panel.add(jpanel_help);
    }

    //Camera: External or Dog view
    private void initPanel_CameraSelect() {
        jpanel_cameraSelect = new JPanel();

        radioBtn_cameraSelect_external = new JRadioButton("External");
        radioBtn_cameraSelect_dog = new JRadioButton("Dog");

        ButtonGroup radioBtn_group = new ButtonGroup();
        radioBtn_group.add(radioBtn_cameraSelect_dog);
        radioBtn_group.add(radioBtn_cameraSelect_external);
        radioBtn_cameraSelect_external.setSelected(true);

        jpanel_cameraSelect.add(radioBtn_cameraSelect_external);
        jpanel_cameraSelect.add(radioBtn_cameraSelect_dog);

        panel.add(jpanel_cameraSelect);

        radioBtn_cameraSelect_external.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Run only when user selects 'External' camera
                runnable_camera_external.run();
            }
        });

        radioBtn_cameraSelect_dog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Run only when user selects 'Dog' camera
                runnable_camera_dog.run();
            }
        });
    }

    public void run() {
        window.pack();
        window.setVisible(true);
    }

    public void exit() {
        //nothing to do
        System.out.println("GUI is closing...");
    }
}
