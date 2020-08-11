package Engine.Light;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import java.awt.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;

public class SpatialLight extends Light {

    private Vector4f position; //Last element is 'w' which is 'directional light' or not.

    public SpatialLight(int light_number, boolean is_directional) {
        super(light_number);
        position = new Vector4f(0, 0, 0, is_directional ? 0 : 1);
    }

    public FloatBuffer getColorFloatBuffer() {
        float red = color.getRed() / 255f;
        float green = color.getGreen() / 255f;
        float blue = color.getBlue() / 255f;
        float alpha = color.getAlpha() / 255f;

        red *= intensity;
        green *= intensity;
        blue *= intensity;
        alpha *= intensity;

        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(4).put(new float[]{red, green, blue, alpha});
        floatBuffer.rewind();
        return floatBuffer;
    }

    public FloatBuffer getPositionFloatBuffer() {
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(4).put(new float[]{position.x, position.y, position.z, position.w});
        floatBuffer.rewind();
        return floatBuffer;
    }
}
