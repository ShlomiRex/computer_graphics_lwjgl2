package Engine;



public class Keyboard {
    public Runnable move_forward, move_backward, move_left, move_right, move_up, move_down;

    public static Runnable dog_head_rotate_clockwise, dog_head_rotate_cclockwise;
    public static Runnable key_h, key_j; //not sure what these do but ok
    public static Runnable key_n, key_m; //These move the spotlight

    private Window window;

    public Keyboard(Window window, Runnable move_forward, Runnable move_backward, Runnable move_left, Runnable move_right, Runnable move_up, Runnable move_down) {
        this.window = window;
        this.move_forward = move_forward;
        this.move_backward = move_backward;
        this.move_left = move_left;
        this.move_right = move_right;
        this.move_up = move_up;
        this.move_down = move_down;
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
