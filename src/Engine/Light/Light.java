package Engine.Light;

import org.lwjgl.util.vector.Vector3f;

import java.awt.*;

public class Light {

    public static final Vector3f DEFAULT_AMBIENT = new Vector3f(0.5f, 0.5f, 0.5f);


    /**
     * Color of light. Values in [0, 255]
     */
    public Color color;
    /**
     * Intensity of light. Value in [0, 1]
     */
    public float intensity;
    /**
     * Light index: GL_LIGHT0, G_LIGHT1, GL_LIGHT2...
     */
    public final int LIGHT_X;

    public Light(int light_number) {
        LIGHT_X = light_number;
        color = Color.WHITE;
        intensity = 0.5f;
    }
}
