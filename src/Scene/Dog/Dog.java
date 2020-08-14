package Scene.Dog;


import Engine.EngineObject.SpatialObject;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Dog extends SpatialObject {

    private Head head;
    private Body body;

    public Dog() {
        this.setName("Dog");

        Vector4f bodyColor = new Vector4f(0.615f, 0.396f, 0.203f, 1);

        this.setRenderingOrder(RenderingOrder.TRANSLATION_ROTATION_SCALING);

        head = new Head(bodyColor);

        body = new Body(bodyColor);
        body.setScale(new Vector3f(0.2f, 0.2f, 0.2f));
        body.setColor(bodyColor);
        head.setColor(bodyColor);

        head.setScale(new Vector3f(0.2f, 0.2f, 0.2f));

        head.setPosition(new Vector3f(0.f, body.getScale().y + 0.1f, body.getScale().z + 0.1f));

        //Render them both
        addChildren(head);
        addChildren(body);
    }
}