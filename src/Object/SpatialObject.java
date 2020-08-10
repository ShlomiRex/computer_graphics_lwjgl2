package Object;

import org.lwjgl.util.vector.Vector3f;

public abstract class SpatialObject extends Object implements ISpatialObject {
    public Vector3f position;
    public Vector3f rotation;
    public Vector3f scale;

    public SpatialObject() {
        position = new Vector3f();
        rotation = new Vector3f();
        scale = new Vector3f();
    }
}
