package Scene.Dog;


import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Dog extends SpatialObject {

    private Head head;
    private Sphere body;

    public Dog() {
        this.name = "Dog";
        head = new Head();
        body = new Sphere();

        //Render them both
        this.children.add(head);
        this.children.add(body);

        position.y = 5f;
        body.scale.z = 3f;

        //Move head to correct position relative to Dog SpatialObject.
        head.position.x = 0f;
        head.position.y = 1.5f;
        head.position.z = 3f;
    }
}
