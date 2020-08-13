package Engine.Light;

import Engine.EngineObject.ISpatialObject;
import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector4f;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class SpatialLight extends Light implements ISpatialObject {

    /**
     * Spatial position in space of light.
     */
    public Vector4f position; //Last element is 'w' which is 'directional light' or not.
    /**
     * When true, this object will not be rendered.
     */
    public boolean toRender;
    /**
     * The rendered spatial object of this light.
     */
    protected SpatialObject renderObject;

    public SpatialLight(int light_number, boolean is_directional) {
        super(light_number);
        position = new Vector4f(0, 0, 0, is_directional ? 0 : 1);
        renderObject = new Sphere();
        toRender = true;

        renderObject.name = "Light " + ((light_number / GL_LIGHT0) - 1);

        renderObject.color.x = 0.5f;
        renderObject.color.y = 0.5f;
        renderObject.color.z = 0f;
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
    public void update() {
        if(updateNeeded == false)
            return;

        glLight(LIGHT_X, GL_POSITION, getPositionFloatBuffer());
        if(toRender == false)
            glDisable(LIGHT_X);
        else
            glEnable(LIGHT_X);

        super.update();
    }

    @Override
    public void render() {
        if(toRender == false || glIsEnabled(LIGHT_X) == false)
            return;

        renderObject.position.x = position.x;
        renderObject.position.y = position.y;
        renderObject.position.z = position.z;

        float materialColor_red = Light.DEFAULT_AMBIENT.getX() * renderObject.color.x;
        float materialColor_green = Light.DEFAULT_AMBIENT.getY() * renderObject.color.y;
        float materialColor_blue = Light.DEFAULT_AMBIENT.getZ() * renderObject.color.z;

        glColor3f(materialColor_red, materialColor_green, materialColor_blue);
        renderObject.render();
    }
}
