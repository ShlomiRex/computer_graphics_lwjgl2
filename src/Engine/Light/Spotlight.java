package Engine.Light;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector3f;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.glColor3f;

public class Spotlight extends SpatialLight {

    public Vector3f direction;
    public float cutoff;

    /**
     * Attenuation.
     */
    public float constant_attenuation, linear_attenuation, quadratic_attenuation;
    public float exponent;

    public Spotlight(int light_number) {
        super(light_number, false);
        direction = new Vector3f(0, 0, -1);
        cutoff = 45f;

        constant_attenuation = 1f;
        linear_attenuation = 0f;
        quadratic_attenuation = 0f;

        exponent = 0f;
    }

    public FloatBuffer getDirectionFloatBuffer() {
        float x = position.x + direction.x;
        float y = position.y + direction.y;
        float z = position.z + direction.z;
        float w = position.w; //This doesn't get changed
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(4).put(new float[]{x, y, z, w});
        floatBuffer.rewind();
        return floatBuffer;
    }
}
