package Engine.Light;

import Engine.EngineObject.ISpatialObject;
import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import java.awt.*;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;

public class SpatialLight extends Light implements ISpatialObject {

    /**
     * Spatial position in space of light.
     */
    public Vector4f position; //Last element is 'w' which is 'directional light' or not.
    /**
     * The rendered spatial object of this light.
     */
    private SpatialObject renderObject;

    public SpatialLight(int light_number, boolean is_directional) {
        super(light_number);
        position = new Vector4f(0, 0, 0, is_directional ? 0 : 1);
        renderObject = new Sphere();
    }

    /**
     *
     * @return color buffer for glLight(GL_LIGHT, GL_XXXX, buffer) where XXXX can be GL_AMBIENT, GL_SPECULAR, GL_DIFFUSE
     */
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

    /**
     *
     * @return positional buffer for glLight(GL_LIGHTX, GL_POSITION, buffer)
     */
    public FloatBuffer getPositionFloatBuffer() {
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(4).put(new float[]{position.x, position.y, position.z, position.w});
        floatBuffer.rewind();
        return floatBuffer;
    }

    @Override
    public void render() {
        //Render the light in space as yellow sphere spatial object.
        renderObject.position.x = position.x;
        renderObject.position.y = position.y;
        renderObject.position.z = position.z;

        renderObject.render();
    }
}
