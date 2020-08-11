package Scene.Dog;


import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Dog extends SpatialObject {

    private Sphere head;
    private Sphere body;

    public Dog() {
        head = new Sphere();
        body = new Sphere();

        this.children.add(head);
        this.children.add(body);

        body.scale.z = 3f;

        //Move head to correct position relative to body.
        head.position.x = 0f;
        head.position.y = 1.5f;
        head.position.z = 3f;
    }
}
