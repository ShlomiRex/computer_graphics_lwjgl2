public class Keyboard {

    private static final Keyboard instance = new Keyboard();

    public static Runnable move_forward, move_backward, move_left, move_right, move_up, move_down;

    public static Runnable dog_head_rotate_clockwise, dog_head_rotate_cclockwise;
    public static Runnable key_h, key_j; //not sure what these do but ok
    public static Runnable key_n, key_m; //These move the spotlight

    private static GameWindow window;

    private Keyboard() {

    }

    public static void init(GameWindow window, Runnable move_forward, Runnable move_backward, Runnable move_left, Runnable move_right, Runnable move_up, Runnable move_down) {
        Keyboard.window = window;
        Keyboard.move_forward = move_forward;
        Keyboard.move_backward = move_backward;
        Keyboard.move_left = move_left;
        Keyboard.move_right = move_right;
        Keyboard.move_up = move_up;
        Keyboard.move_down = move_down;
    }

    public static void pollKeys() {
        //check keys, buffered
        org.lwjgl.input.Keyboard.poll();

        //Do not remove this. This can be useful in the future.
        /*
        int count = org.lwjgl.input.Keyboard.getNumKeyboardEvents();
        while (org.lwjgl.input.Keyboard.next()) {
            int character_code = ((int) org.lwjgl.input.Keyboard.getEventCharacter()) & 0xffff;
            System.out.println("Checking key:" + org.lwjgl.input.Keyboard.getKeyName(org.lwjgl.input.Keyboard.getEventKey()));
            System.out.println("Pressed:" + org.lwjgl.input.Keyboard.getEventKeyState());
            System.out.println("Key character code: 0x" + Integer.toHexString(character_code));
            System.out.println("Key character: " + org.lwjgl.input.Keyboard.getEventCharacter());
            System.out.println("Repeat event: " + org.lwjgl.input.Keyboard.isRepeatEvent());

            if (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_R && org.lwjgl.input.Keyboard.getEventKeyState()) {
                org.lwjgl.input.Keyboard.enableRepeatEvents(!org.lwjgl.input.Keyboard.areRepeatEventsEnabled());
            }
            if (org.lwjgl.input.Keyboard.getEventKey() == org.lwjgl.input.Keyboard.KEY_ESCAPE) {
                return;
            }
        }
         */

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_W)) {
            move_forward.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_S)) {
            move_backward.run();
        }

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_A)) {
            move_left.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_D)) {
            move_right.run();
        }

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_Z)) {
            move_down.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_X)) {
            move_up.run();
        }
    }

    /*
    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            move_forward.run();
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            move_backward.run();
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            move_left.run();
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            move_right.run();
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            move_up.run();
        } else if (window.isKeyPressed(GLFW_KEY_X)) {
            move_down.run();
        }

        if (window.isKeyPressed(GLFW_KEY_T)) {
            dog_head_rotate_clockwise.run();
        } else if (window.isKeyPressed(GLFW_KEY_Y)) {
            dog_head_rotate_cclockwise.run();
        }

        if (window.isKeyPressed(GLFW_KEY_H)) {
            key_h.run();
        } else if (window.isKeyPressed(GLFW_KEY_J)) {
            key_j.run();
        }

        if (window.isKeyPressed(GLFW_KEY_N)) {
            key_n.run();
        } else if (window.isKeyPressed(GLFW_KEY_M)) {
            key_m.run();
        }
    }
     */
}
