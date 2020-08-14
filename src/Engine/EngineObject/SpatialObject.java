package Engine.EngineObject;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

/**
 * Spatial object is a physical object in space. It has transformations and position. It can be rendered.
 */
public abstract class SpatialObject extends EngineObject implements ISpatialObject {
    public Vector3f position;
    public Vector3f rotation;
    public Vector3f scale;

    //Material properties
    /**
     * Pure color (it is multiplied by ambient color)
     */
    public Vector3f color;

    public SpatialObject parent;

    public SpatialObject(SpatialObject parent, String name) {
        this.parent = parent;
        this.name = name;
        position = new Vector3f();
        rotation = new Vector3f();
        scale = new Vector3f(1, 1, 1);
        color = new Vector3f(1.0f, 1.0f, 1.0f);
    }

    @Override
    public void render() {
        GL11.glPushMatrix();
            //Apply transformation of parent.
            GL11.glScalef(scale.x, scale.y, scale.z);
            GL11.glTranslatef(position.x, position.y, position.z);

            for(EngineObject object : children) {
                if(object instanceof SpatialObject) {
                    ((SpatialObject)object).render();
                }
            }
        GL11.glPopMatrix();
    }

    //Calculates all children / parents position into 1 big vector which is the absolute world position, not relative.
    public Vector3f getAbsoluteWorldPosition() {
        Vector3f pos = new Vector3f(position);

        //Recursion: depth first, parent last
        if(parent != null) {
            Vector3f parentPos = parent.getAbsoluteWorldPosition();
            pos.x += parentPos.x;
            pos.y += parentPos.y;
            pos.z += parentPos.z;
        }

        return pos;
    }
}
