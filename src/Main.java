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

        light0_pointLight.intensity = 0.5f;
        light0_pointLight.color = Color.BLUE;

        light2_pointLight.intensity =  0.5f;
        light2_pointLight.color = Color.RED;
    }

    private void run() throws LWJGLException {
        //show gui
        guiWindow.run();

        //init
        gameWindow.init();
        initKeyboard(gameWindow);
        initMouse();
        initGUIRunnables();

        //run game
        gameLoop();

        //game loop finishes, exit
        exit();
    }

    private void initGUIRunnables() {
        AmbientPanel.runnable_ambientLight_color = () -> {
            light0_pointLight.color = AmbientPanel.ambientLightColor;
        };

        AmbientPanel.runnable_ambientLight_intensity = () -> {
            light0_pointLight.intensity = AmbientPanel.ambientLightIntensity / 100f; //[0, 100] range to [0, 1] for float.
        };

        PointLightPanel.runnable_pointLight_enable = () -> {
            light2_pointLight.toRender = PointLightPanel.pointLight_enabled;
        };


    }

    private void initMouse() {
        Mouse.init(camera);
    }

    private void initKeyboard(GameWindow window) {

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

            updateLights();

            render();
            Display.update();
            glFlush();
        }
    }

    /**
     * Update position for each light in OpenGL context.
     */
    private void updateLights() {
        updateLight(light0_pointLight);
        updateLight(light1_spotlight);

        if(SpotlightPanel.spotlight_direction_panel != null) {
            light1_spotlight.direction.x = SpotlightPanel.spotlight_direction_panel.slider1_value;
            light1_spotlight.direction.y = SpotlightPanel.spotlight_direction_panel.slider2_value;
            light1_spotlight.direction.z = SpotlightPanel.spotlight_direction_panel.slider3_value;
        }
        glLight(GL_LIGHT1, GL_SPOT_DIRECTION, light1_spotlight.getDirectionFloatBuffer());

        updateLight(light2_pointLight);
    }

    private void updateLight(SpatialLight light) {
        glLight(light.LIGHT_X, GL_POSITION, light.getPositionFloatBuffer());

        FloatBuffer floatBuffer = light.getColorFloatBuffer();

        glLight(light.LIGHT_X, GL_AMBIENT, floatBuffer);
        glLight(light.LIGHT_X, GL_DIFFUSE, floatBuffer);
        glLight(light.LIGHT_X, GL_SPECULAR, floatBuffer);
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
