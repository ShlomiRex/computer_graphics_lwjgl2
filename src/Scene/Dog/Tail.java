package Scene.Dog;

import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Tail extends SpatialObject {
    private int tailRotationY = 0;

    public Tail() {
        Sphere tail = new Sphere();
        float tailScale = 0.1f;
        tail.setRenderingOrder(RenderingOrder.ROTATION_TRANSLATION_SCALING);
        tail.setScale(new Vector3f(tailScale, tailScale * 4, tailScale));
        tail.setColor(new Vector4f(0, 0, 0, 1));
        tail.setRotation(new Vector3f(0,0,100f));
        addChildren(tail);
    }

    public int getTailRotationY() {
        return tailRotationY;
    }

    public void setTailRotationY(int tailRotationY) {
        this.tailRotationY = tailRotationY;
    }

    @Override
    public void renderAfter() {
        GL11.glTranslatef(0, -position.y, 0);
        GL11.glRotatef(40, 0, 1, 0);
        GL11.glTranslatef(0, position.y, 0);
    }
}
