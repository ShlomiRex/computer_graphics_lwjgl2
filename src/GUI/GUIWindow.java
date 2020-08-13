package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIWindow extends JFrame {

    //Camera panel
    private JPanel jpanel_cameraSelect;
    private JRadioButton radioBtn_cameraSelect_external;
    private JRadioButton radioBtn_cameraSelect_dog;
    public static Runnable runnable_camera_external;
    public static Runnable runnable_camera_dog;

    //Ambient panel
    private AmbientPanel jpanel_ambientLight;

    //Bottom panel
    private JPanel jpanel_bottomControl;

    //Point light panel
    private JPanel jpanel_pointLight;

    //Spotlight
    private JPanel jpanel_spotlight;

    public GUIWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        initPanel_CameraSelect();
        jpanel_ambientLight = new AmbientPanel();
        add(jpanel_ambientLight);

        jpanel_pointLight = new PointLightPanel(this);
        add(jpanel_pointLight);

        jpanel_spotlight = new SpotlightPanel(this);
        add(jpanel_spotlight);

        jpanel_bottomControl = new BottomPanel(this);
        add(jpanel_bottomControl);

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

        add(jpanel_cameraSelect);

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
        pack();
        setVisible(true);
    }

    public void exit() {
        //nothing to do
        System.out.println("GUI is closing...");
    }
}
