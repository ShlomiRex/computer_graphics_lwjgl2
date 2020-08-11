package Scene.Dog;

import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Body extends SpatialObject {

    private Sphere body;
    private Sphere backLeftLeg, backRightLeg, frontLeftLeg, frontRightLeg;

    //We can play with these values.
    private final float LEG_HEIGHT = 1f;
    private final float BODY_LENGTH = 3f;

    private final float LEG_X_OFFSET = 1f;
    private final float LEG_Y_OFFSET = 1f;
    private final float LEG_Z_OFFSET = 0.5f;

    public Body() {
        body = new Sphere();
        backLeftLeg = new Sphere();
        backRightLeg = new Sphere();
        frontLeftLeg = new Sphere();
        frontRightLeg = new Sphere();


        body.scale.z = BODY_LENGTH;

        backLeft();
        backRight();
        frontLeft();
        frontRight();

        children.add(body);
        body.children.add(backLeftLeg);
        body.children.add(backRightLeg);
        body.children.add(frontLeftLeg);
        body.children.add(frontRightLeg);
    }

    private void frontRight() {
        frontRightLeg.scale.x /= BODY_LENGTH;
        frontRightLeg.scale.y = LEG_HEIGHT;
        frontRightLeg.scale.z /= BODY_LENGTH * 2;

        frontRightLeg.position.x += LEG_X_OFFSET;
        frontRightLeg.position.y -= LEG_Y_OFFSET;
        frontRightLeg.position.z += LEG_Z_OFFSET;
    }

    private void frontLeft() {
        frontLeftLeg.scale.x /= BODY_LENGTH;
        frontLeftLeg.scale.y = LEG_HEIGHT;
        frontLeftLeg.scale.z /= BODY_LENGTH * 2;

        frontLeftLeg.position.x -= LEG_X_OFFSET;
        frontLeftLeg.position.y -= LEG_Y_OFFSET;
        frontLeftLeg.position.z += LEG_Z_OFFSET ;
    }

    private void backRight() {
        backRightLeg.scale.x /= BODY_LENGTH;
        backRightLeg.scale.y = LEG_HEIGHT;
        backRightLeg.scale.z /= BODY_LENGTH * 2;

        backRightLeg.position.x += LEG_X_OFFSET;
        backRightLeg.position.y -= LEG_Y_OFFSET;
        backRightLeg.position.z -= LEG_Z_OFFSET;
    }

    private void backLeft() {
        backLeftLeg.scale.x /= BODY_LENGTH;
        backLeftLeg.scale.y = LEG_HEIGHT;
        backLeftLeg.scale.z /= BODY_LENGTH * 2;

        backLeftLeg.position.x -= LEG_X_OFFSET;
        backLeftLeg.position.y -= LEG_Y_OFFSET;
        backLeftLeg.position.z -= LEG_Z_OFFSET;
    }
}
