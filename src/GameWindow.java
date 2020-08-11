import Engine.Light.Light;
import Engine.Light.SpatialLight;
import GUI.GUIWindow;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class GameWindow {

    public int width, height;
    public String title;

    private final float fovy = 60f; //Perspective fovy in degrees
    private final float zNear = 0.1f; //Near plane
    private final float zFar = 1000.0f; //Far plane



    public GameWindow(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init() throws LWJGLException {
        // create Window and center it.
        Display.setLocation((Display.getDisplayMode().getWidth() - width) / 2,
                (Display.getDisplayMode().getHeight() - height) / 2);
        Display.setDisplayMode(new DisplayMode(width, height));
        Display.setTitle(title);
        Display.create();

        initGUIEvents();
        initOpenGL();
    }

    private void initGUIEvents() {
        GUIWindow.runnable_ambientLight_color = () -> {

        };
    }

    private void initOpenGL() {
        glEnable(GL_CULL_FACE);
        glEnable(GL_LIGHTING);
        glEnable(GL_LIGHT0);
        glShadeModel(GL_SMOOTH);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_NORMALIZE);


        //glMaterial(GL_FRONT_AND_BACK, GL_AMBIENT_AND_DIFFUSE, new FloatBuffer());
        //glLightModelf(GL_LIGHT_MODEL_LOCAL_VIEWER, GL_TRUE);
        //FloatBuffer ambientLightColor = BufferUtils.createFloatBuffer(4).put(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        //glLightModelf(GL_LIGHT_MODEL_AMBIENT, ambientLightColor);

        // Set the viewport to cover the new window
        glViewport(0, 0, width, height);

        // Set the aspect ratio of the clipping volume to match the viewport
        glMatrixMode(GL_PROJECTION);  // To operate on the Projection matrix
        glLoadIdentity();             // Reset
        // Enable perspective projection with fovy, aspect, zNear and zFar
        GLU.gluPerspective(fovy, (float) width / (float) height, zNear, zFar);
    }
}
