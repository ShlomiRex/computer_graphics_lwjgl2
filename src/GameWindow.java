import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameWindow {
    public int width, height;
    public String title;

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
    }
}
