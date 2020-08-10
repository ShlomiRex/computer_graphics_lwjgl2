package Light;

import org.lwjgl.util.vector.Vector3f;

public class SpatialLight extends Light {
    public Vector3f position;

    public SpatialLight() {
        position = new Vector3f();
    }
}
