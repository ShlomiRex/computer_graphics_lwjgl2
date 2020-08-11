import Engine.Camera;

public class Mouse {
    private static final Mouse instance = new Mouse();

    private static float last_x, last_y;
    private static boolean rotate_left_right;
    private static boolean rotate_up_down;

    /** Last button pressed */
    private static int lastButton;

    /** Direction mouse has moved */
    private static int direction;

    /** Last direction we scrolled in */
    private static int lastScrollDirection = -1;

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
        /*
        // iterate all events, use the last button down
        while(org.lwjgl.input.Mouse.next()) {
            if(org.lwjgl.input.Mouse.getEventButton() != -1 && org.lwjgl.input.Mouse.getEventButtonState()) {
                lastButton = org.lwjgl.input.Mouse.getEventButton();
            }
        }
        */

        updateState();
    }

    /**
     * Updates our "model"
     *
     */
    private static void updateState() {
        direction = -1;

        int dx = org.lwjgl.input.Mouse.getDX();
        int dy = org.lwjgl.input.Mouse.getDY();
        int dw = org.lwjgl.input.Mouse.getDWheel();


        // get out if no movement
        if (dx == dy && dx == 0 && dw == 0) {
            return;
        }

        // determine direction moved
        // ============================
        if(dx > 0) {
            direction = 3;
        }

        if(dx < 0) {
            direction = 1;
        }

        if(dy > 0) {
            direction = 0;
        }

        if(dy < 0) {
            direction = 2;
        }

        // ----------------------------
        if(direction > -1) {

            // based on which button was last pushed, update model
            switch(lastButton) {
                case -1:
                    break;
                case 0:
                    System.out.println("0");
                    camera.rotate_around_y(5);
                    break;
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
            }
        }



        // get direction to update in
        if (dw > 0) {
            lastScrollDirection++;
        } else if (dw < 0) {
            lastScrollDirection--;
        } else if (dw == 0) {
            return;
        }

        // over/underflow
        if(lastScrollDirection < 0) {
            lastScrollDirection = 3;
        }
        if(lastScrollDirection > 3) {
            lastScrollDirection = 0;
        }
    }
}
