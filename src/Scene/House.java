package Scene;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;

public class House extends SpatialObject {

    private Cube floor;

    public House() {
        floor = new Cube();
        floor.scale.x = 10f;
        floor.scale.y = 0.1f;
        floor.scale.z = 10f;

        children.add(floor);
    }
}
