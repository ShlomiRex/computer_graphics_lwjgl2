package Scene;

import Engine.EngineObject.Cube;
import Engine.EngineObject.SpatialObject;

public class House extends SpatialObject {

    private final float WALL_THICKNESS = 0.1f;
    private final float WALL_LENGTH = 30f;
    private final float CEILING_HEIGHT = WALL_LENGTH / 2f;

    private Cube floor, backWall, leftWall, rightWall;

    public House() {
        super(null, "House Class");
        this.name = "House";
        floor = new Cube(this, "Floor Cube");
        floor.scale.x = WALL_LENGTH;
        floor.scale.y = WALL_THICKNESS;
        floor.scale.z = WALL_LENGTH;

        backWall = new Cube(this, "Back Wall Cube");
        backWall.scale.x = WALL_LENGTH;
        backWall.scale.y = CEILING_HEIGHT;
        backWall.scale.z = WALL_THICKNESS;
        backWall.position.z -= WALL_LENGTH;
        backWall.position.y += CEILING_HEIGHT;

        leftWall = new Cube(this, "Left Wall Cube");
        leftWall.scale.x = WALL_THICKNESS;
        leftWall.scale.y = CEILING_HEIGHT;
        leftWall.scale.z = WALL_LENGTH;
        leftWall.position.x -= WALL_LENGTH;
        leftWall.position.y += CEILING_HEIGHT;

        rightWall = new Cube(this, "Right Wall Cube");
        rightWall.scale.x = WALL_THICKNESS;
        rightWall.scale.y = CEILING_HEIGHT;
        rightWall.scale.z = WALL_LENGTH;
        rightWall.position.x += WALL_LENGTH;
        rightWall.position.y += CEILING_HEIGHT;

        children.add(floor);
        children.add(backWall);
        children.add(leftWall);
        children.add(rightWall);
    }
}
