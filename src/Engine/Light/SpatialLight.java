package Engine.Light;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;

public class SpatialLight extends Light {
    private FloatBuffer position;


    public SpatialLight(int light_number, boolean is_directional) {
        super(light_number);
        position = BufferUtils.createFloatBuffer(4).put(new float[] {0f, 0f, 0f, is_directional ? 0f : 1f});
        position.rewind();

        updatePosition();
        updateAmbientLight();
        updateDiffuseLight();
        updateSpecularLight();
    }

    private void updatePosition() {
        glLight(LIGHT_X, GL_POSITION, position);
    }

    private void updateAmbientLight() {
        FloatBuffer ambient = BufferUtils.createFloatBuffer(4).put(new float[] { 1.0f, 1.0f, 1.0f, 1.0f});
        ambient.rewind();
        glLight(LIGHT_X, GL_AMBIENT, ambient);
    }

    private void updateDiffuseLight() {
        FloatBuffer diffuse = BufferUtils.createFloatBuffer(4).put(new float[] { 1.0f, 1.0f, 1.0f, 1.0f});
        diffuse.rewind();
        glLight(LIGHT_X, GL_DIFFUSE, diffuse);
    }

    private void updateSpecularLight() {
        FloatBuffer specular = BufferUtils.createFloatBuffer(4).put(new float[] { 1.0f, 1.0f, 1.0f, 1.0f});
        specular.rewind();
        glLight(LIGHT_X, GL_SPECULAR, specular);
    }
}
