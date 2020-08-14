package Scene.Dog;

import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Body extends SpatialObject {

    private Sphere body;
    private Sphere backLeftLeg, backRightLeg, frontLeftLeg, frontRightLeg;
    public Tail tail;

    //We can play with these values.
    private final float LEG_HEIGHT = 0.75f;
    private final float BODY_LENGTH = 2f;
    private final float LEG_VOLUME = 1 / (BODY_LENGTH * 2);


    private final float LEG_X_OFFSET = 2.5f;
    private final float LEG_Y_OFFSET = 1f;
    private final float LEG_Z_OFFSET = 2.6f;

    public Body(Vector4f color) {
        body = new Sphere();
        backLeftLeg = new Sphere();
        backRightLeg = new Sphere();
        frontLeftLeg = new Sphere();
        frontRightLeg = new Sphere();
        this.setRenderingOrder(RenderingOrder.TRANSLATION_ROTATION_SCALING);
        body.scale.z = BODY_LENGTH;

        backLeft();
        backRight();
        frontLeft();
        frontRight();

        backLeftLeg.setColor(color);
        backRightLeg.setColor(color);
        frontLeftLeg.setColor(color);
        frontRightLeg.setColor(color);
        body.setColor(color);

        addChildren(body);
        body.addChildren(backLeftLeg);
        body.addChildren(backRightLeg);
        body.addChildren(frontLeftLeg);
        body.addChildren(frontRightLeg);

        tail = new Tail();
        tail.setPosition(new Vector3f(0, 0, -body.getScale().z * 0.5f));
//        tail.setRenderingOrder(RenderingOrder.TRANSLATION_ROTATION_SCALING);

        body.addChildren(tail);
    }

    public int getTailRotationY() {
        return this.tail.getTailRotationY();
    }

    public void setTailRotationY(int tailRotationY) {
        this.tail.setTailRotationY(tailRotationY);
    }

    private void frontRight() {
        frontRightLeg.scale.x = LEG_VOLUME;
        frontRightLeg.scale.y = LEG_HEIGHT;
        frontRightLeg.scale.z /= BODY_LENGTH * 2;

        frontRightLeg.position.x += LEG_X_OFFSET;
        frontRightLeg.position.y -= LEG_Y_OFFSET;
        frontRightLeg.position.z += LEG_Z_OFFSET;
    }

    private void frontLeft() {
        frontLeftLeg.scale.x = LEG_VOLUME;
        frontLeftLeg.scale.y = LEG_HEIGHT;
        frontLeftLeg.scale.z /= BODY_LENGTH * 2;

        frontLeftLeg.position.x -= LEG_X_OFFSET;
        frontLeftLeg.position.y -= LEG_Y_OFFSET;
        frontLeftLeg.position.z += LEG_Z_OFFSET;
    }

    private void backRight() {
        backRightLeg.scale.x = LEG_VOLUME;
        backRightLeg.scale.y = LEG_HEIGHT;
        backRightLeg.scale.z /= BODY_LENGTH * 2;

        backRightLeg.position.x += LEG_X_OFFSET;
        backRightLeg.position.y -= LEG_Y_OFFSET;
        backRightLeg.position.z -= LEG_Z_OFFSET;
    }

    private void backLeft() {
        backLeftLeg.scale.x = LEG_VOLUME;
        backLeftLeg.scale.y = LEG_HEIGHT;
        backLeftLeg.scale.z /= BODY_LENGTH * 2;

        backLeftLeg.position.x -= LEG_X_OFFSET;
        backLeftLeg.position.y -= LEG_Y_OFFSET;
        backLeftLeg.position.z -= LEG_Z_OFFSET;
    }

}