import Engine.Camera;
import Engine.Input.Keyboard;
import Engine.Input.Mouse;
import Engine.Light.SpatialLight;
import GUI.GUIWindow;
import Scene.Dog.Dog;
import Scene.House;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    private GUIWindow guiWindow;
    private GameWindow gameWindow;
    private Dog dog;
    private House house;
    private Camera camera;
    private SpatialLight light0;

    public Main() {
        guiWindow = new GUIWindow("Controls");
        gameWindow = new GameWindow("My Game", 1280, 720);
        camera = new Camera();

        dog = new Dog();
        house = new House();
        light0 = new SpatialLight(GL_LIGHT0, false);
    }

    private void run() throws LWJGLException {
        guiWindow.run();

        init();
        gameLoop();
        exit();
    }

    private void init() throws LWJGLException {
        gameWindow.init();
        initKeyboard(gameWindow);
        initMouse();

        initGUIRunnables();
    }

    private void initGUIRunnables() {
        GUIWindow.runnable_ambientLight_color = () -> {
            light0.color = GUIWindow.ambientLightColor;
        };

        GUIWindow.runnable_ambientLight_intensity = () -> {
            light0.intensity = GUIWindow.ambientLightIntensity / 100f; //[0, 100] range to [0, 1] for float.
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
            light0.position.x -= 0.01f;
        };

        Keyboard.key_m = () -> {
            light0.position.x += 0.01f;
        };

        Keyboard.key_h = () -> {
            light0.position.y -= 0.01f;
        };

        Keyboard.key_j = () -> {
            light0.position.y += 0.01f;
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

            updateLight(light0);

            render();
            Display.update();
            glFlush();
        }
    }

    private void updateLight(SpatialLight light) {
        glLight(light.LIGHT_X, GL_POSITION, light.getPositionFloatBuffer());
        glLight(light.LIGHT_X, GL_AMBIENT, light.getColorFloatBuffer());
        glLight(light.LIGHT_X, GL_DIFFUSE, light.getColorFloatBuffer());
        glLight(light.LIGHT_X, GL_SPECULAR, light.getColorFloatBuffer());
    }

    //Called each frame.
    private void render() {
        //To bring everything in front of camera.
        //Also bring camera up so we can see below us.
        glTranslatef(0, -5f, -20f);

        dog.render();
        house.render();
        light0.render();
    }

    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

}
