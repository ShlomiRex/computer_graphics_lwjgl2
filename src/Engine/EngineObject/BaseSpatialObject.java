package Engine.EngineObject;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public abstract class BaseSpatialObject extends BaseObject {
    public enum RenderingOrder {
        TRANSLATION_ROTATION_SCALING,
        ROTATION_TRANSLATION_SCALING,
    }

    public Vector3f position;
    public Vector3f rotation;
    public Vector3f scale;
    private Vector4f color;
    private RenderingOrder renderingOrder;

    public BaseSpatialObject() {
        super();
        position = new Vector3f();
        rotation = new Vector3f();
        scale = new Vector3f(1, 1, 1);
        renderingOrder = RenderingOrder.ROTATION_TRANSLATION_SCALING;
        color = new Vector4f(1, 1, 1, 1);
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Vector4f getColor() {
        return color;
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public RenderingOrder getRenderingOrder() {
        return renderingOrder;
    }

    public void setRenderingOrder(RenderingOrder renderingOrder) {
        this.renderingOrder = renderingOrder;
    }
}