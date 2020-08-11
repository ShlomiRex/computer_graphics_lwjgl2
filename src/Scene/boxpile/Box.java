package Scene.boxpile;


import Engine.EngineObject.OBJLoader;
import Engine.EngineObject.RawModel;
import Engine.EngineObject.RawSpatialObject;
import Engine.EngineObject.SpatialObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Box extends RawSpatialObject {
    private float floorPositionY;
    private final OBJLoader loader = new OBJLoader();

    public Box(String fileName, Vector3f position, Vector3f scale, Vector3f rotation) {
        super(fileName);

        this.setColor(new Vector4f(0.388f, 0.286f, 0.196f, 1));
        this.rotation = rotation;
        this.scale = scale;
        this.position = position;
    }
}