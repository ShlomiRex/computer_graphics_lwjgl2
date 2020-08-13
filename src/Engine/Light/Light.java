package Engine.Light;

import Engine.EngineObject.IStateObject;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import java.awt.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Light implements IStateObject {

    public static final Vector3f DEFAULT_AMBIENT = new Vector3f(0f, 0f, 0f);


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

    /**
     * This state is set True to say to OpenGL context to update this SpatialLight's position(GL_POSITION), color, glEnable/glDisable, toRender
     * After this is set to True, Light is updated, and in the next clock, it is set back to False.
     */
    public boolean updateNeeded = false;

    public Light(int light_number) {
        LIGHT_X = light_number;
        color = Color.WHITE;
        intensity = 0.5f;
    }

    /**
     * OpenGL context is needed here to execute OpenGL commands. i.e. run from Main class.
     */
    @Override
    public void update() {
        if(updateNeeded == false)
            return;

        float red = color.getRed() / 255f;
        float green = color.getGreen() / 255f;
        float blue = color.getBlue() / 255f;
        float alpha = color.getAlpha() / 255f;

        red *= intensity;
        green *= intensity;
        blue *= intensity;
        alpha *= intensity;

        FloatBuffer color = BufferUtils.createFloatBuffer(4).put(new float[]{red, green, blue, alpha});
        color.rewind();

        glLight(LIGHT_X, GL_AMBIENT, color);
        glLight(LIGHT_X, GL_DIFFUSE, color);
        glLight(LIGHT_X, GL_SPECULAR, color);

        updateNeeded = false;

    }
}
