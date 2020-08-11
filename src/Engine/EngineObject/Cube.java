package Engine.EngineObject;

import org.lwjgl.util.vector.Vector4f;

import static org.lwjgl.opengl.GL11.*;

public class Cube extends SpatialObject {

    public Cube() {
        //Rotation, Scale, Translate is default
    }

    @Override
    public void render() {
        Vector4f color = this.getColor();
        glPushMatrix();
        glTranslatef(position.x, position.y, position.z);
        glScalef(scale.x, scale.y, scale.z);
        glDisable(GL_LIGHTING);
        glDisable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);

        glNormal3f(0, 1, 0);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(1.0f, 1.0f, -1.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(1.0f, 1.0f, 1.0f);

        glNormal3f(0, -1, 0);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(1.0f, -1.0f, -1.0f);

        glNormal3f(0, 0, 1);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, 1.0f);

        glNormal3f(0, 0, -1);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(1.0f, 1.0f, -1.0f);

        glNormal3f(-1, 0, 0);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);

        glNormal3f(1, 0, 0);
        glColor4f(color.x, color.y, color.z, color.w);
        glVertex3f(1.0f, 1.0f, -1.0f);
        glVertex3f(1.0f, 1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, -1.0f);

        glEnd();
        glEnable(GL_LIGHTING);
        glEnable(GL_TEXTURE_2D);
        glPopMatrix();

        //Render children.
        super.render();
    }
}
