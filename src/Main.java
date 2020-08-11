import Engine.Camera;
import GUI.GUIWindow;
import Scene.Dog.Dog;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    private GUIWindow guiWindow;
    private GameWindow gameWindow;
    private Dog dog;
    private Camera camera;

    public Main() {
        guiWindow = new GUIWindow("Controls");
        gameWindow = new GameWindow("My Game", 800, 600);
        dog = new Dog();
        camera = new Camera();
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

        Keyboard.init(window, move_forward, move_backward, move_left, move_right, move_up, move_down);
    }

    //Exit gracefully.
    private void exit() {
        System.out.println("Exiting...");
        guiWindow.exit();
        Display.destroy();
        System.exit(0);
    }

    private void gameLoop() {
        long startTime = System.currentTimeMillis() + 5000;
        long fps = 0;

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


            render();

            //Read keyboard
            Keyboard.pollKeys();

            //Read mouse
            Mouse.poll();



            Display.update();
            if (startTime > System.currentTimeMillis()) {
                fps++;
            } else {
                long timeUsed = 5000 + (startTime - System.currentTimeMillis());
                startTime = System.currentTimeMillis() + 5000;
                System.out.println(fps + " frames in " + timeUsed / 1000f + " seconds = "
                        + (fps / (timeUsed / 1000f)));
                fps = 0;
            }

            glFlush();
        }
    }

    //Called each frame.
    private void render() {
        glTranslatef(0, 0, -40f);


        dog.render();

    }

    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}
