import Engine.Camera;

public class Mouse {
    private static final Mouse instance = new Mouse();

    private static float last_x, last_y;
    private static boolean rotate_left_right;
    private static boolean rotate_up_down;

    /** Last button pressed */
    private static int lastButton;


    private static Camera camera;

    private static final float ROTATE_AMOUNT = 1f; //Degrees to turn each update if mouse is dragged

    private Mouse() {
    }

    public static void init(Camera camera) {
        Mouse.camera = camera;
    }

    /**
     * reads a mouse in buffered mode
     */
    public static void poll() {
        int dx = org.lwjgl.input.Mouse.getDX();
        int dy = org.lwjgl.input.Mouse.getDY();
        int dw = org.lwjgl.input.Mouse.getDWheel();

        if(org.lwjgl.input.Mouse.isButtonDown(0)) {
            if(dx > 0)
                camera.rotate_around_y(ROTATE_AMOUNT);
            else if(dx < 0)
                camera.rotate_around_y(-ROTATE_AMOUNT);
        }
    }
}
