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
    private JPanel jpanel_ambientLight;
    public static Runnable runnable_ambientLight_color; //When user changes ambient color
    public static Color ambientLightColor = Color.WHITE;

    //Bottom panel
    private JPanel jpanel_bottomControl;

    //Point light panel
    private JPanel jpanel_pointLight;
    public static boolean pointLight_enabled;
    public static Color pointLightColor = Color.WHITE;
    public static Runnable runnable_pointLight_enable; //When user changes point light enable/disable
    public static Runnable runnable_pointLight_color; //When user changes point light color

    //Spotlight
    private JPanel jpanel_spotlight;
    public static boolean spotlight_enabled;
    public static Color spotlightColor = Color.WHITE;
    public static Runnable runnable_spotLight_color; //When user changes spotlight color
    public static float jSlider1Value, jSlider2Value, jSlider3Value;
    public static SliderControlPanel spotlight_direction_panel;

    //Ambient light
    public static Runnable runnable_ambientLight_intensity;
    public static int ambientLightIntensity; //Value is between 0 and 100. You can do mod math to get between 0 and 1.

    public GUIWindow(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        window.add(panel);

        initPanel_CameraSelect();
        initPanel_Help();
        initPanel_AmbientLight();
        initPanel_PointLight();
        initPanel_Spotlight();
        initPanel_buttomControls();
    }

    private void initPanel_Spotlight() {
        jpanel_spotlight = new JPanel();
        jpanel_spotlight.setBorder(BorderFactory.createTitledBorder("Spotlight"));

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spotlight_enabled = checkBox_enable.isEnabled();
                runnable_spotLight_color.run();
            }
        });
        jpanel_spotlight.add(checkBox_enable);

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose spotlight color", Color.WHITE);
                spotlightColor = newColor;
                runnable_spotLight_color.run();
            }
        });
        jpanel_spotlight.add(btnColor);


        JButton jButton = new JButton("Direction");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Direction control");
                spotlight_direction_panel = new SliderControlPanel(); //We create each time because to reset x,y,z,w
                jFrame.add(spotlight_direction_panel);
                jFrame.setVisible(true);
                jFrame.pack();
            }
        });
        jpanel_spotlight.add(jButton);

        panel.add(jpanel_spotlight);
    }

    private void initPanel_PointLight() {
        jpanel_pointLight = new JPanel();
        jpanel_pointLight.setBorder(BorderFactory.createTitledBorder("Point Engine.Light"));

        JCheckBox checkBox_enable = new JCheckBox("Enable");
        checkBox_enable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointLight_enabled = checkBox_enable.isEnabled();
                runnable_pointLight_enable.run();
            }
        });
        jpanel_pointLight.add(checkBox_enable);

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose point light color", Color.WHITE);
                pointLightColor = newColor;
                runnable_pointLight_color.run();
            }
        });
        jpanel_pointLight.add(btnColor);

        panel.add(jpanel_pointLight);
    }

    private void initPanel_buttomControls() {
        jpanel_bottomControl = new JPanel();

        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton credits = new JButton("Credits");
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Shlomi & Shlomi");
            }
        });

        jpanel_bottomControl.add(credits);
        jpanel_bottomControl.add(quit);

        panel.add(jpanel_bottomControl);
    }

    private void initPanel_AmbientLight() {
        jpanel_ambientLight = new JPanel();
        jpanel_ambientLight.setBorder(BorderFactory.createTitledBorder("Ambient Engine.Light"));

        //Slider
        int min = 0;
        int max = 100;
        int value = max/2;
        JSlider jSlider = new JSlider(min, max, value);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ambientLightIntensity = jSlider.getValue();
                runnable_ambientLight_intensity.run();
            }
        });
        jpanel_ambientLight.add(jSlider);
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
                ambientLightColor = newColor;
                runnable_ambientLight_color.run();
            }
        });
        jpanel_ambientLight.add(btnColor);


        panel.add(jpanel_ambientLight);
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

    public GUIWindow() {
        this("GUI");
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
