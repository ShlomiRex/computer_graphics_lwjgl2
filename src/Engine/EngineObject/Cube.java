package Engine.EngineObject;

import Engine.Light.Light;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Cube extends SpatialObject {

    public Cube() {
//        scale.x /= 2;
//        scale.y /= 2;
//        scale.z /= 2;
    }

    /**
     * Draw simple 2x2x2 cube.
     */
    @Override
    public void render() {
        float materialColor_red = Light.DEFAULT_AMBIENT.getX() * getColor().x;
        float materialColor_green = Light.DEFAULT_AMBIENT.getY() * getColor().y;
        float materialColor_blue = Light.DEFAULT_AMBIENT.getZ() * getColor().z;

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

            //Render children.
            super.render();
        glPopMatrix();

    }
}
