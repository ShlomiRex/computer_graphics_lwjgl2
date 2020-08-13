package Scene.Dog;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Head extends SpatialObject {

    //Spatial objects.

    private Sphere head;

    public Head(Vector4f color) {
        head = new Sphere();
        head.setPosition(new Vector3f(0, 0, 0));
//        head.setRotation(rotation);
        head.setRenderingOrder(RenderingOrder.ROTATION_TRANSLATION_SCALING);

        Cube leftEye = new Cube();
        Cube rightEye = new Cube();

        this.setName("Head Class");
        head.setName("Head");
        leftEye.setName("Left Eye");
        rightEye.setName("Right Eye");

        float eyeScale = 0.1f;
        Vector3f eyeScaleVec = new Vector3f(eyeScale, eyeScale, eyeScale);
        leftEye.setScale(eyeScaleVec);
        rightEye.setScale(eyeScaleVec);

        //Bring forward eyes.
        float zOffset = 0.8f;
        leftEye.position.z += zOffset;
        rightEye.position.z += zOffset;

        //Move left eye to the left. Right to the right.
        float xOffset = 0.5f;
        leftEye.position.x -= xOffset;
        rightEye.position.x += xOffset;

        this.addChildren(head);
        head.addChildren(leftEye);
        head.addChildren(rightEye);

        Sphere leftEar = new Sphere();
        leftEar.setName("Left ear");
        Sphere rightEar = new Sphere();
        rightEar.setName("Right ear");

        Vector4f earColor = new Vector4f(0.533f, 0.360f, 0.207f, 1);

        float earScale = 0.55f;
        Vector3f earScaleVec = new Vector3f(earScale, earScale * 1.2f, earScale);
        leftEar.setScale(earScaleVec);
        rightEar.setScale(earScaleVec);

        float earY = 0.5f;
        float earX = 0.8f;
        rightEar.setPosition(new Vector3f(earX, earY, 0));
        leftEar.setPosition(new Vector3f(-earX, earY, 0));

        leftEar.setColor(earColor);
        rightEar.setColor(earColor);
        head.addChildren(leftEar);
        head.addChildren(rightEar);

        float noseScale = 0.25f;
        Vector4f noseColor = new Vector4f(0.176f, 0.176f, 0.176f, 1);
        Sphere nose = new Sphere();
        nose.setPosition(new Vector3f(0, -0.5f, 3f));
        nose.setScale(new Vector3f(noseScale, noseScale * 1.3f, noseScale));
        nose.setColor(noseColor);
        head.addChildren(nose);

        head.setColor(color);
        Vector4f eyeColor = new Vector4f(0, 0, 0, 1);
        leftEye.setColor(eyeColor);
        rightEye.setColor(eyeColor);
    }
}
