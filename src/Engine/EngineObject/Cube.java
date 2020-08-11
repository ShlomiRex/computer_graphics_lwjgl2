package Engine.EngineObject;

import static org.lwjgl.opengl.GL11.*;

public class Cube extends SpatialObject {

    public Cube() {
        scale.x /= 2;
        scale.y /= 2;
        scale.z /= 2;
    }

    /**
     * Draw simple 2x2x2 cube.
     */
    @Override
    public void render() {
        glColor3f(0.5f, 0.5f, 0.5f);

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

        glColor3f(0.5f, 0.5f, 0.5f);

        //Render children.
        super.render();
    }
}
