package Scene.Dog;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Head extends SpatialObject {

    private Sphere head;
    private Cube leftEye;
    private Cube rightEye;

    public Head() {
        this.name = "Head";
        head = new Sphere();
        leftEye = new Cube();
        rightEye = new Cube();

        leftEye.scale.x = 5f;
        leftEye.scale.y = 5f;
        leftEye.scale.z = 15f;

        children.add(head);
        head.children.add(leftEye);
        //children.add(rightEye);
    }
}
