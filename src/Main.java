import Engine.Camera;
import Engine.EngineObject.Pointlight;
import Engine.Input.Keyboard;
import Engine.Input.Mouse;
import Engine.Light.SpatialLight;
import Engine.Light.Spotlight;
import GUI.AmbientPanel;
import GUI.GUIWindow;
import GUI.PointLightPanel;
import GUI.SpotlightPanel;
import Scene.Dog.Dog;
import Scene.House;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import java.awt.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    private GUIWindow guiWindow;
    private GameWindow gameWindow;
    private Dog dog;
    private House house;
    private Camera camera;
    private Pointlight light0_pointLight; //Main scene light (global)
    private Spotlight light1_spotlight;
    private Pointlight light2_pointLight; //Secondary light

    public Main() {
        guiWindow = new GUIWindow("Controls");
        gameWindow = new GameWindow("My Game", 1280, 720);
        camera = new Camera();

        dog = new Dog();
        house = new House();

        light0_pointLight = new Pointlight(GL_LIGHT0);
        light1_spotlight = new Spotlight(GL_LIGHT1);
        light2_pointLight = new Pointlight(GL_LIGHT2);
    }

    private void run() throws LWJGLException {
        //show gui
        guiWindow.run();

        //init
        gameWindow.init();
        initKeyboard();
        initMouse();
        initGUIRunnables();
        initLights();

        //run game
        gameLoop();

        //game loop finishes, exit
        exit();
    }

    private void initLights() {
        //TODO: Enable / disable lights for testing
        //glEnable(GL_LIGHT0);
        glEnable(GL_LIGHT1);
        //glEnable(GL_LIGHT2);

        //Light 0 init
        light0_pointLight.intensity = 0.2f;

        //Light 1 init
        light1_spotlight.intensity = 1f;
        light1_spotlight.color = Color.WHITE;

        light1_spotlight.position.x = 0;
        light1_spotlight.position.y = 15;
        light1_spotlight.position.z = 20;
        //light1_spotlight.position.w = 1.0f; //It is already setup as NON DIRECTIONAL

        light1_spotlight.direction.x = 0;
        light1_spotlight.direction.y = 0;
        light1_spotlight.direction.z = -1;

        light1_spotlight.exponent = 0f;
        light1_spotlight.cutoff = 22.5f;
        light1_spotlight.constant_attenuation = 1.0f;
        light1_spotlight.linear_attenuation = 0f;
        light1_spotlight.quadratic_attenuation = 0f;

        //Light 2 init
        light2_pointLight.intensity =  0.5f;
        light2_pointLight.color = Color.RED;


        //Execute OpenGL context for the first time for the lights.
        light0_pointLight.updateNeeded = true;
        light1_spotlight.updateNeeded = true;
        //light2_pointLight.updateNeeded = true;
    }

    private void initGUIRunnables() {
        //Light 0
        AmbientPanel.runnable_ambientLight_color = () -> {
            light0_pointLight.color = AmbientPanel.ambientLightColor;
            light0_pointLight.updateNeeded = true;
        };

        AmbientPanel.runnable_ambientLight_intensity = () -> {
            light0_pointLight.intensity = AmbientPanel.ambientLightIntensity / 100f; //[0, 100] range to [0, 1] for float.
            light0_pointLight.updateNeeded = true;
        };

        //Light 1
        SpotlightPanel.runnable_spotLight_color = () -> {
            light1_spotlight.color = SpotlightPanel.spotlightColor;
            light1_spotlight.updateNeeded = true;
        };

        SpotlightPanel.runnable_spotLight_enabled = () -> {
            light1_spotlight.toRender = SpotlightPanel.spotlight_enabled;
            light1_spotlight.updateNeeded = true;
        };

        SpotlightPanel.spotlight_direction_panel.runnable_valueChanged = () -> {
            light1_spotlight.direction.x = SpotlightPanel.spotlight_direction_panel.slider1_value;
            light1_spotlight.direction.y = SpotlightPanel.spotlight_direction_panel.slider2_value;
            light1_spotlight.direction.z = SpotlightPanel.spotlight_direction_panel.slider3_value;

            light1_spotlight.updateNeeded = true;
        };

        //Light 2
        PointLightPanel.runnable_pointLight_enable = () -> {
            light2_pointLight.toRender = PointLightPanel.pointLight_enabled;
            light2_pointLight.updateNeeded = true;
        };

        PointLightPanel.runnable_pointLight_color = () -> {
            light2_pointLight.color = PointLightPanel.pointLightColor;
            light2_pointLight.updateNeeded = true;
        };
    }

    private void initMouse() {
        Mouse.init(camera);
    }

    private void initKeyboard() {

        Runnable move_forward = () -> {
            camera.moveForward();
        };

        Runnable move_backward = () -> {
            camera.moveBackward();
        };

        Runnable move_left = () -> {
            camera.moveLeft();
        };

        Runnable  move_right = () -> {
            camera.moveRight();
        };

        Runnable move_up = () -> {
            camera.moveUp();
        };

        Runnable move_down = () -> {
            camera.moveDown();
        };

        Keyboard.init(move_forward, move_backward, move_left, move_right, move_up, move_down);

        Keyboard.key_n = () -> {
            light0_pointLight.position.x -= 0.01f;
        };

        Keyboard.key_m = () -> {
            light0_pointLight.position.x += 0.01f;
        };

        Keyboard.key_h = () -> {
            light0_pointLight.position.y -= 0.01f;
        };

        Keyboard.key_j = () -> {
            light0_pointLight.position.y += 0.01f;
        };

        Keyboard.key_o = () -> {
            light1_spotlight.position.y += 0.01f;
        };

        Keyboard.key_p = () -> {
            light1_spotlight.position.y -= 0.01f;
        };
    }

    //Exit gracefully.
    private void exit() {
        System.out.println("Exiting...");
        guiWindow.exit();
        Display.destroy();
        System.exit(0);
    }

    //Main game loop (Render, Input, Update)
    private void gameLoop() {
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //Clear background color, Clear depth buffer
            glColor3f(0f, 0f, 0f); //Background color

            glMatrixMode(GL_MODELVIEW);//Convert model matrix to view matrix (lookat next lines)
            glLoadIdentity(); // Reset the model-view matrix (view matrix multiplied by model = model is viewed)

            //direction vector default is 0,0,-1 and up vector default is 0,1,0
            GLU.gluLookAt(
                    camera.position.x, camera.position.y, camera.position.z,
                    camera.direction.x, camera.direction.y, camera.direction.z,
                    camera.up.x, camera.up.y, camera.up.z
            );

            //Read keyboard
            Keyboard.pollKeys();

            //Read mouse
            Mouse.poll();

            //This updates the game states.
            light0_pointLight.update();
            light1_spotlight.update();
            light2_pointLight.update();

            render();
            Display.update();
            glFlush();
        }
    }

    //Called each frame.
    private void render() {
        //To bring everything in front of camera.
        //Also bring camera up so we can see below us.
        glTranslatef(0, -5f, -20f);

        dog.render();
        house.render();
        light0_pointLight.render();
        light1_spotlight.render();
        light2_pointLight.render();
    }

    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

}
