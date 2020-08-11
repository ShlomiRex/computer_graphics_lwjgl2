package Scene.Dog;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Head extends SpatialObject {

    //Spatial objects.

    private Sphere head;
    private Cube leftEye;
    private Cube rightEye;

    public Head() {
        head = new Sphere();
        leftEye = new Cube();
        rightEye = new Cube();

        name = "Head Class";
        head.name = "Head";
        leftEye.name = "Left Eye";
        rightEye.name = "Right Eye";

        float eye_scale = 0.1f;

        leftEye.scale.x = eye_scale;
        leftEye.scale.y = eye_scale;
        leftEye.scale.z = eye_scale;

        rightEye.scale.x = eye_scale;
        rightEye.scale.y = eye_scale;
        rightEye.scale.z = eye_scale;

        //Bring forward eyes.
        float zOffset = 0.8f;
        leftEye.position.z += zOffset;
        rightEye.position.z += zOffset;

        //Move left eye to the left. Right to the right.
        float xOffset = 0.5f;
        leftEye.position.x -= xOffset;
        rightEye.position.x += xOffset;

        children.add(head);
        head.children.add(leftEye);
        head.children.add(rightEye);
    }
}
