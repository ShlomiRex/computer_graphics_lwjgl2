package Engine.EngineObject;

public class Sphere extends RawSpatialObject {

    private static final String BALL_FILE_NAME = "./resources/model/ball.obj";

    public Sphere() {
        super(BALL_FILE_NAME);
    }
//    @Override
//    public void render() {
//        float materialColor_red = Light.DEFAULT_AMBIENT.getX() * color.x;
//        float materialColor_green = Light.DEFAULT_AMBIENT.getY() * color.y;
//        float materialColor_blue = Light.DEFAULT_AMBIENT.getZ() * color.z;
//
//        glColor3f(materialColor_red, materialColor_green, materialColor_blue);
//
//        GL11.glPushMatrix();
//            GL11.glTranslatef(position.x, position.y, position.z);
//            GL11.glScalef(scale.x, scale.y, scale.z);
//            sphere.draw(radius, slices, stacks);
//        GL11.glPopMatrix();
//
//        //Render children.
//        super.render();
//    }
}
