package Engine.EngineObject;


import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class Sphere extends SpatialObject {

    private org.lwjgl.util.glu.Sphere sphere;

    public float radius;
    int slices, stacks;

    public Sphere() {
        sphere = new org.lwjgl.util.glu.Sphere();
        radius = 1f;
        slices = 10;
        stacks = 10;
    }

    @Override
    public void render() {
        GL11.glPushMatrix();
            GL11.glTranslatef(position.x, position.y, position.z);
            GL11.glScalef(scale.x, scale.y, scale.z);
            sphere.draw(radius, slices, stacks);
        GL11.glPopMatrix();

        //Render children.
        super.render();
    }
}
