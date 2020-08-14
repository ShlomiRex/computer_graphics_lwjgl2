package Scene.Dog;


import Engine.EngineObject.SpatialObject;
import Engine.Input.ObjectInput;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Dog extends SpatialObject implements ObjectInput {

    private Head head;
    private Body body;
    private int yDiff = 5;
    private int xDiff = 3;

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

    @Override
    public void update(String action) {
        int headRotationY = this.head.getHeadRotationY();
        int headRotationX = this.head.getHeadRotationX();

        DogMovement dogMovement = DogMovement.valueOf(action);
        if (dogMovement == DogMovement.HEAD_LEFT) {
            if (headRotationY >= -90) {
                this.head.setHeadRotationY(headRotationY - yDiff);
            }
        } else if (dogMovement == DogMovement.HEAD_RIGHT) {
            if (headRotationY <= 90) {
                this.head.setHeadRotationY(headRotationY + yDiff);
            }
        } else if (dogMovement == DogMovement.HEAD_DOWN) {
            if (headRotationX <= 60) {
                this.head.setHeadRotationX(headRotationX + xDiff);
            }
        } else if (dogMovement == DogMovement.HEAD_UP) {
            if (headRotationX >= -45) {
                this.head.setHeadRotationX(headRotationX - xDiff);
            }
        }

        int tailRotationY = this.body.getTailRotationY();
        if (dogMovement == DogMovement.TAIL_LEFT) {
            if (tailRotationY >= -70) {
                this.body.setTailRotationY(tailRotationY - yDiff);
            }
        } else if (dogMovement == DogMovement.TAIL_RIGHT) {
            if (tailRotationY <= 70) {
                this.body.setTailRotationY(tailRotationY + yDiff);
            }
        }

    }

    public enum DogMovement {
        HEAD_LEFT,
        HEAD_RIGHT,
        HEAD_UP,
        HEAD_DOWN,
        TAIL_LEFT,
        TAIL_RIGHT
    }
}