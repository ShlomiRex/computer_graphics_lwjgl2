package Engine.Light;

import java.awt.*;

public class Light {
    public Color color;
    public float intensity;
    public final int LIGHT_X; //GL_LIGHT0, G_LIGHT1...

    public Light(int light_number) {
        LIGHT_X = light_number;
        color = Color.WHITE;
        intensity = 1.0f;
    }
}
