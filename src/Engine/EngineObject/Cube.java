package Engine.EngineObject;

import Engine.Light.Light;

import static org.lwjgl.opengl.GL11.*;

public class Cube extends SpatialObject {

    public Cube(SpatialObject parent, String name) {
        super(parent, name);
        scale.x /= 2;
        scale.y /= 2;
        scale.z /= 2;
    }

    /**
     * Draw simple 2x2x2 cube.
     */
    @Override
    public void render() {
        float materialColor_red = Light.DEFAULT_AMBIENT.getX() * color.x;
        float materialColor_green = Light.DEFAULT_AMBIENT.getY() * color.y;
        float materialColor_blue = Light.DEFAULT_AMBIENT.getZ() * color.z;

        glColor3f(materialColor_red, materialColor_green, materialColor_blue);

        glPushMatrix();
            glTranslatef(position.x, position.y, position.z);
            glScalef(scale.x, scale.y, scale.z);
            glBegin(GL_QUADS);
                glNormal3f(0, 1, 0);
                //glColor3f(1.0f, 1.0f, 0.0f);
                glVertex3f(1.0f, 1.0f, -1.0f);
                glVertex3f(-1.0f, 1.0f, -1.0f);
                glVertex3f(-1.0f, 1.0f, 1.0f);
                glVertex3f(1.0f, 1.0f, 1.0f);

                glNormal3f(0, -1, 0);
                //glColor3f(1.0f, 0.5f, 0.0f);
                glVertex3f(1.0f, -1.0f, 1.0f);
                glVertex3f(-1.0f, -1.0f, 1.0f);
                glVertex3f(-1.0f, -1.0f, -1.0f);
                glVertex3f(1.0f, -1.0f, -1.0f);

                glNormal3f(0, 0, 1);
                //glColor3f(1.0f, 0.0f, 0.0f);
                glVertex3f(1.0f, 1.0f, 1.0f);
                glVertex3f(-1.0f, 1.0f, 1.0f);
                glVertex3f(-1.0f, -1.0f, 1.0f);
                glVertex3f(1.0f, -1.0f, 1.0f);

                glNormal3f(0, 0, -1);
                //glColor3f(1.0f, 1.0f, 0.0f);
                glVertex3f(1.0f, -1.0f, -1.0f);
                glVertex3f(-1.0f, -1.0f, -1.0f);
                glVertex3f(-1.0f, 1.0f, -1.0f);
                glVertex3f(1.0f, 1.0f, -1.0f);

                glNormal3f(-1, 0, 0);
                //glColor3f(0.0f, 0.0f, 1.0f);
                glVertex3f(-1.0f, 1.0f, 1.0f);
                glVertex3f(-1.0f, 1.0f, -1.0f);
                glVertex3f(-1.0f, -1.0f, -1.0f);
                glVertex3f(-1.0f, -1.0f, 1.0f);

                glNormal3f(1, 0, 0);
                //glColor3f(1.0f, 0.0f, 1.0f);
                glVertex3f(1.0f, 1.0f, -1.0f);
                glVertex3f(1.0f, 1.0f, 1.0f);
                glVertex3f(1.0f, -1.0f, 1.0f);
                glVertex3f(1.0f, -1.0f, -1.0f);
            glEnd();
        glPopMatrix();
        //Render children.
        super.render();
    }
}
