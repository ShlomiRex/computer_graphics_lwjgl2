package Scene.boxpile;


import Engine.EngineObject.OBJLoader;
import Engine.EngineObject.RawModel;
import Engine.EngineObject.SpatialObject;
import org.lwjgl.util.vector.Vector3f;

public class Pile extends SpatialObject {
    private float floorPositionY;
    private RawModel model;
    private final OBJLoader loader = new OBJLoader();
    private static final String BOX_FILE_NAME = "./resources/model/cube.obj";

    public Pile(Vector3f position, Vector3f scale, Vector3f rotation) {
        this.rotation = rotation;
        this.scale = scale;
        this.position = position;
        try {

            float scaleValue = 1.2f;

            Vector3f boxScale = new Vector3f(scaleValue, scaleValue, scaleValue);
            float yPosition = position.y + scaleValue;
            this.setRenderingOrder(RenderingOrder.TRANSLATION_ROTATION_SCALING);

            Box box1 = getBox(boxScale, rotation);
            box1.position = new Vector3f(position);
            box1.position.y = yPosition;

            this.children.add(box1);

            Box box2 = getBox(boxScale, rotation);
            box2.position = new Vector3f(position.x + 1 * boxScale.x, yPosition, position.z);
            this.children.add(box2);

            Box box3 = getBox(boxScale, rotation);
            box3.position = new Vector3f(position.x + 1 * boxScale.x, yPosition, position.z + boxScale.z);
            this.children.add(box3);

            Box box4 = getBox(boxScale, rotation);
            box4.position = new Vector3f(position.x + 1 * boxScale.x, yPosition + boxScale.y * 1, position.z + boxScale.z);
            this.children.add(box4);

//            ObjectInSpace box3 = getBox(scale, boxMesh, rotation);
//            box3.setPosition(position.x + scale, yPosition, position.z + scale * 2);
//
//            ObjectInSpace box4 = getBox(scale, boxMesh, rotation);
//            box4.setPosition(position.x + scale, yPosition + scale * 2, position.z + scale);
//
//            addObject(box1);
//            addObject(box2);
//            addObject(box3);
//            addObject(box4);
//
//            Mesh openBoxMesh = OBJLoader.loadMesh("./models/CardboardBox2.obj");
//
//            ObjectInSpace openedBox = getBox(scale * 1.5f, openBoxMesh, rotation);
//            openedBox.setPosition(position.x + scale, yPosition + scale * 3, position.z + scale);
//            addObject(openedBox);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Box getBox(Vector3f scale, Vector3f rotation) {
        Box box = new Box(BOX_FILE_NAME, new Vector3f(), scale, rotation);
//        boxMesh.setMaterial(new Material(new Vector4f(0.388f, 0.286f, 0.196f, 1), 0.3f));
//        ObjectInSpace box = new ObjectInSpace(boxMesh);
//        box.setRotation(rotation.x, rotation.y, rotation.z);
//        box.setScale(scale);
        return box;
    }
//    @Override
//    public void render() {
//        GL11.glPushMatrix();
//        //Apply transformation of parent.
//        GL11.glScalef(scale.x, scale.y, scale.z);
//        GL11.glTranslatef(position.x, position.y, position.z);
//
//        children.stream().forEach(c -> c.render());
//        GL11.glPopMatrix();
//    }

}