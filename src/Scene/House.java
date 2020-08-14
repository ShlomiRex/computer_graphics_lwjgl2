package Scene;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;
import Scene.Dog.Dog;
import Scene.boxpile.Pile;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class House extends SpatialObject {

    private final float WALL_THICKNESS = 0.01f;
    private final float WALL_LENGTH = 1;
    private final float CEILING_HEIGHT = WALL_LENGTH / 2f;
    private final float NORMAL_DISTANCE = 1;

    private Cube floor, backWall, leftWall, rightWall;

    public Dog dog;

    public House() {
        floor = new Cube();
//        floor.scale.x = WALL_LENGTH;
        floor.scale.y = WALL_THICKNESS;
        floor.scale.z = WALL_LENGTH;
        floor.position.y += position.y - CEILING_HEIGHT;
        floor.setColor(new Vector4f(0.2f, 0.3f, 0.9f, 1));

        backWall = new Cube();
//        backWall.scale.x = WALL_LENGTH;
        backWall.scale.y = CEILING_HEIGHT;
        backWall.scale.z = WALL_THICKNESS;
        backWall.position.z -= position.z + NORMAL_DISTANCE;
        backWall.position.y += position.y;
        backWall.setColor(new Vector4f(0f, 0.3f, 0.9f, 1));

        leftWall = new Cube();
        leftWall.scale.x = WALL_THICKNESS;
        leftWall.scale.y = CEILING_HEIGHT;
//        leftWall.scale.z = WALL_LENGTH;
        leftWall.position.x -= position.x + NORMAL_DISTANCE;
        leftWall.position.y += position.y;
        leftWall.setColor(new Vector4f(0.7f, 0.3f, 0.1f, 1));

        rightWall = new Cube();
        rightWall.scale.x = WALL_THICKNESS;
        rightWall.scale.y = CEILING_HEIGHT;
//        rightWall.scale.z = WALL_LENGTH;
        rightWall.position.x += position.x + NORMAL_DISTANCE;
        rightWall.position.y += position.y;
        rightWall.setColor(new Vector4f(0.7f, 0.3f, 0.9f, 1));

        Pile pile = getBoxPile(0.1f, floor, backWall, leftWall);

        this.dog = getDog(0.25f, floor, backWall, leftWall);

        addChildren(dog);
        addChildren(pile);
        addChildren(floor);
        addChildren(backWall);
        addChildren(leftWall);
        addChildren(rightWall);
    }

    private Pile getBoxPile(float scale, Cube floor, Cube backWall, Cube leftWall) {
        Vector3f boxScale = new Vector3f(scale, scale, scale);
        Vector3f pilePosition = new Vector3f(leftWall.position.x + boxScale.x * 2.5f, floor.position.y + floor.scale.y, backWall.position.z + 0.5f);
        Vector3f boxRotation = new Vector3f(0, -255, 0);
        Pile boxPile = new Pile(pilePosition, boxScale, boxRotation);
        return boxPile;
    }

    private Dog getDog(float scale, Cube floor, Cube backWall, Cube leftWall) {
        Vector3f vScale = new Vector3f(scale, scale, scale);
        Vector3f position = new Vector3f(rightWall.position.x - scale * 2.5f, floor.position.y + 0.075f, floor.position.z + floor.getScale().z * 0.75f);

//        Vector3f position = new Vector3f(0, floor.getPosition().y + scale, 0);
        Vector3f rotation = new Vector3f(0, -45, 0);
        Dog dog = new Dog();
        dog.setPosition(position);
        dog.setScale(vScale);
        dog.setRotation(rotation);
        dog.setRenderingOrder(RenderingOrder.TRANSLATION_ROTATION_SCALING);
        return dog;
    }
}