package Engine.EngineObject;


import Engine.Light.Light;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glColor3f;

public class Sphere extends SpatialObject {

    private org.lwjgl.util.glu.Sphere sphere;

    public float radius;
    int slices, stacks;

    public Sphere(SpatialObject parent, String name) {
        super(parent, name);
        sphere = new org.lwjgl.util.glu.Sphere();
        radius = 1f;
        slices = 10;
        stacks = 10;
    }


    @Override
    public void render() {
        float materialColor_red = Light.DEFAULT_AMBIENT.getX() * color.x;
        float materialColor_green = Light.DEFAULT_AMBIENT.getY() * color.y;
        float materialColor_blue = Light.DEFAULT_AMBIENT.getZ() * color.z;

        glColor3f(materialColor_red, materialColor_green, materialColor_blue);

        GL11.glPushMatrix();
            GL11.glTranslatef(position.x, position.y, position.z);
            GL11.glScalef(scale.x, scale.y, scale.z);
            sphere.draw(radius, slices, stacks);
        GL11.glPopMatrix();

        //Render children.
        super.render();
    }
}
