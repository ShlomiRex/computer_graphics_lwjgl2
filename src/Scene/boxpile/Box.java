package Scene.boxpile;


import Engine.EngineObject.RawSpatialObject;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Box extends RawSpatialObject {
    public Box(String fileName, Vector3f position, Vector3f scale, Vector3f rotation) {
        super(fileName);

        this.setColor(new Vector4f(0.388f, 0.286f, 0.196f, 1));
        this.rotation = rotation;
        this.scale = scale;
        this.position = position;
    }
}