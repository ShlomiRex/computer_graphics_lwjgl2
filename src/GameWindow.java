import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

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

        initOpenGL();
    }

    private void initOpenGL() {
        glEnable(GL_CULL_FACE);
        glEnable(GL_LIGHTING);
        glShadeModel(GL_SMOOTH);
        glEnable(GL_DEPTH_TEST);

        //TODO: We can play with this. I didn't notice anything significant or cool.
// glEnable(GL_NORMALIZE);
//        glEnable(GL_POINT_SMOOTH);
//        glEnable(GL_BLEND);
//        glEnable(GL_DITHER);
//        glEnable(GL_LINE_SMOOTH);
//        glEnable(GL_SCISSOR_TEST);
//        glEnable(GL_STENCIL_TEST);
        //create mirror effect


        // Set the viewport to cover the new window
        glViewport(0, 0, width, height);

        // Set the aspect ratio of the clipping volume to match the viewport
        glMatrixMode(GL_PROJECTION);  // To operate on the Projection matrix
        glLoadIdentity();             // Reset
        // Enable perspective projection with fovy, aspect, zNear and zFar
        GLU.gluPerspective(fovy, (float) width / (float) height, zNear, zFar);


        //TODO: THis has cool effect
        glColorMaterial ( GL_FRONT_AND_BACK, GL_EMISSION ) ;
        glEnable ( GL_COLOR_MATERIAL ) ;
    }
}
