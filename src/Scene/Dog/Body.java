package Scene.Dog;

import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Body extends SpatialObject {

    private Sphere body;
    private Sphere backLeftLeg, backRightLeg, frontLeftLeg, frontRightLeg;

    public Body() {
        body = new Sphere();
        backLeftLeg = new Sphere();
        backRightLeg = new Sphere();
        frontLeftLeg = new Sphere();
        frontRightLeg = new Sphere();

        body.scale.z = 3f;

        children.add(body);
    }
}
