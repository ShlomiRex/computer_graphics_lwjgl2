package Engine.Input;

public class Keyboard {

    private static final Keyboard instance = new Keyboard();

    public static Runnable move_forward, move_backward, move_left, move_right, move_up, move_down;

    public static Runnable dog_head_rotate_clockwise, dog_head_rotate_cclockwise;
    public static Runnable dog_head_rotate_up, dog_head_rotate_down;
    public static Runnable tail_clockwise, tail_cclockwise;
    public static Runnable key_h, key_j;
    public static Runnable key_n, key_m;
    public static Runnable key_o, key_p;

    private Keyboard() {

    }

    public static void init(Runnable move_forward, Runnable move_backward, Runnable move_left, Runnable move_right, Runnable move_up, Runnable move_down) {
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
        int count = org.lwjgl.input.Engine.Input.Keyboard.getNumKeyboardEvents();
        while (org.lwjgl.input.Engine.Input.Keyboard.next()) {
            int character_code = ((int) org.lwjgl.input.Engine.Input.Keyboard.getEventCharacter()) & 0xffff;
            System.out.println("Checking key:" + org.lwjgl.input.Engine.Input.Keyboard.getKeyName(org.lwjgl.input.Engine.Input.Keyboard.getEventKey()));
            System.out.println("Pressed:" + org.lwjgl.input.Engine.Input.Keyboard.getEventKeyState());
            System.out.println("Key character code: 0x" + Integer.toHexString(character_code));
            System.out.println("Key character: " + org.lwjgl.input.Engine.Input.Keyboard.getEventCharacter());
            System.out.println("Repeat event: " + org.lwjgl.input.Engine.Input.Keyboard.isRepeatEvent());

            if (org.lwjgl.input.Engine.Input.Keyboard.getEventKey() == org.lwjgl.input.Engine.Input.Keyboard.KEY_R && org.lwjgl.input.Engine.Input.Keyboard.getEventKeyState()) {
                org.lwjgl.input.Engine.Input.Keyboard.enableRepeatEvents(!org.lwjgl.input.Engine.Input.Keyboard.areRepeatEventsEnabled());
            }
            if (org.lwjgl.input.Engine.Input.Keyboard.getEventKey() == org.lwjgl.input.Engine.Input.Keyboard.KEY_ESCAPE) {
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

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_N)) {
            key_n.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_M)) {
            key_m.run();
        }

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_H)) {
            key_h.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_J)) {
            key_j.run();
        }

        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_O)) {
            key_o.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_P)) {
            key_p.run();
        }

        // Move head left
        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_T)) {
            dog_head_rotate_clockwise.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_Y)) {
            // Move head right
            dog_head_rotate_cclockwise.run();
        }

        // Move head up
        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_U)) {
            dog_head_rotate_up.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_I)) {
            // Move head down
            dog_head_rotate_down.run();
        }

        // Move tail clockwise
        if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_7)) {
            tail_clockwise.run();
        } else if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_8)) {
            // Move tail counter clockwise
            tail_cclockwise.run();
        }
    }
}
