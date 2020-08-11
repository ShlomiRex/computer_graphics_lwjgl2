package Engine.EngineObject;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public abstract class SpatialObject extends EngineObject implements ISpatialObject {
    public Vector3f position;
    public Vector3f rotation;
    public Vector3f scale;

    public SpatialObject() {
        position = new Vector3f();
        rotation = new Vector3f();
        scale = new Vector3f(1, 1, 1);
    }

    @Override
    public void render() {
        GL11.glPushMatrix();
            //Apply transformation of parent.
            GL11.glTranslatef(position.x, position.y, position.z);
            GL11.glScalef(scale.x, scale.y, scale.z);

            for(EngineObject object : children) {
                if(object instanceof SpatialObject) {
                    ((SpatialObject)object).render();
                }
            }
        GL11.glPopMatrix();
    }
}
