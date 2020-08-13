package Engine.EngineObject;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.io.FileNotFoundException;

import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;

public abstract class RawSpatialObject extends BaseSpatialObject implements ISpatialObject {

    private RawModel model;
    private final OBJLoader loader = new OBJLoader();

    public RawSpatialObject(String fileName) {
        super();
        try {
            this.model = loader.loadModel(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        GL11.glPushMatrix();
        glDisable(GL_LIGHTING);
        glDisable(GL_TEXTURE_2D);
        glClearColor(this.getColor().x, this.getColor().y, this.getColor().z, this.getColor().w);

        //Apply transformation of parent.
        GL11.glScalef(scale.x, scale.y, scale.z);
        GL11.glTranslatef(position.x, position.y, position.z);

        GL11.glMaterialf(GL_FRONT, GL_SHININESS, 120);
        GL11.glBegin(GL_TRIANGLES);
        {
            for (RawModel.Face face : model.getFaces()) {
                Vector3f[] normals = {
                        model.getNormals().get(face.getNormals()[0] - 1),
                        model.getNormals().get(face.getNormals()[1] - 1),
                        model.getNormals().get(face.getNormals()[2] - 1)
                };
                Vector2f[] texCoords = {
                        model.getTextureCoordinates().get(face.getTextureCoords()[0] - 1),
                        model.getTextureCoordinates().get(face.getTextureCoords()[1] - 1),
                        model.getTextureCoordinates().get(face.getTextureCoords()[2] - 1)
                };
                Vector3f[] vertices = {
                        model.getVertices().get(face.getVertices()[0] - 1),
                        model.getVertices().get(face.getVertices()[1] - 1),
                        model.getVertices().get(face.getVertices()[2] - 1)
                };
                {
                    glColor4f(getColor().x, getColor().y, getColor().z, getColor().w);

                    GL11.glNormal3f(normals[0].getX(), normals[0].getY(), normals[0].getZ());
                    GL11.glTexCoord2f(texCoords[0].getX(), texCoords[0].getY());
                    GL11.glVertex3f(vertices[0].getX(), vertices[0].getY(), vertices[0].getZ());
                    GL11.glNormal3f(normals[1].getX(), normals[1].getY(), normals[1].getZ());
                    GL11.glTexCoord2f(texCoords[1].getX(), texCoords[1].getY());
                    GL11.glVertex3f(vertices[1].getX(), vertices[1].getY(), vertices[1].getZ());
                    GL11.glNormal3f(normals[2].getX(), normals[2].getY(), normals[2].getZ());
                    GL11.glTexCoord2f(texCoords[2].getX(), texCoords[2].getY());
                    GL11.glVertex3f(vertices[2].getX(), vertices[2].getY(), vertices[2].getZ());
                }
            }
        }
        GL11.glEnd();

        renderChildren();

        glClearColor(1, 1, 1, 1);

        glEnable(GL_LIGHTING);
        glEnable(GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }
}
