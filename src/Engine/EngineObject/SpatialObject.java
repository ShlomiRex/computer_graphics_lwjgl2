package Engine.EngineObject;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;

public abstract class SpatialObject extends BaseSpatialObject implements ISpatialObject {

    @Override
    public void render() {
        GL11.glPushMatrix();
        //Apply transformation of parent.
        glDisable(GL_LIGHTING);
        glDisable(GL_TEXTURE_2D);
        glClearColor(this.getColor().x, this.getColor().y, this.getColor().z, this.getColor().w);

        switch (this.getRenderingOrder()) {
            case ROTATION_TRANSLATION_SCALING:
                GL11.glRotatef(rotation.x, 1, 0, 0);
                GL11.glRotatef(rotation.y, 0, 1, 0);
                GL11.glRotatef(rotation.z, 0, 0, 1);
                GL11.glTranslatef(position.x, position.y, position.z);
                GL11.glScalef(scale.x, scale.y, scale.z);
                break;
            case TRANSLATION_ROTATION_SCALING:
                GL11.glTranslatef(position.x, position.y, position.z);
                GL11.glRotatef(rotation.x, 1, 0, 0);
                GL11.glRotatef(rotation.y, 0, 1, 0);
                GL11.glRotatef(rotation.z, 0, 0, 1);
                GL11.glScalef(scale.x, scale.y, scale.z);
                break;
            default:
                break;
        }

        renderChildren();

        glClearColor(1, 1, 1, 1);

        glEnable(GL_LIGHTING);
        glEnable(GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }
}