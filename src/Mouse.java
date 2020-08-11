import Engine.Camera;

public class Mouse {
    private static final Mouse instance = new Mouse();

    private static float last_x, last_y;
    private static boolean rotate_left_right;
    private static boolean rotate_up_down;

    /** Last button pressed */
    private static int lastButton;


    private static Camera camera;

    private Mouse() {
    }

    public static void init(Camera camera) {
        Mouse.camera = camera;
    }

    /**
     * reads a mouse in buffered mode
     */
    public static void poll() {
        if(org.lwjgl.input.Mouse.isButtonDown(0)) {
            lastButton = 0;
        }

        System.out.println(org.lwjgl.input.Mouse.getEventButton());

        int dx = org.lwjgl.input.Mouse.getDX();
        int dy = org.lwjgl.input.Mouse.getDY();
        int dw = org.lwjgl.input.Mouse.getDWheel();


        // get out if no movement
        if (dx == dy && dx == 0 && dw == 0) {
            return;
        }


        if(dx != 0) {
            Mouse.rotate_left_right = true;
        }

        if(dy != 0) {
            Mouse.rotate_up_down = true;
        }

        // ----------------------------
        // based on which button was last pushed, update model
        switch(lastButton) {
            case -1:
                break;
            case 0:
                camera.rotate_around_y(5);
                break;
        }
    }
}
