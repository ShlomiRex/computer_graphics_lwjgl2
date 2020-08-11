package Scene.Dog;


import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;

public class Dog extends SpatialObject {

    private Head head;
    private Body body;

    public Dog() {
        this.name = "Dog";
        head = new Head();
        body = new Body();


        //Render them both
        children.add(head);
        children.add(body);

        position.y = 10f;

        //Move head to correct position relative to Dog SpatialObject.
        head.position.x = 0f;
        head.position.y = 1.5f;
        head.position.z = 3f;


        //Scale entire dog.
        float s = 3f;
        scale.x *= s;
        scale.y *= s;
        scale.z *= s;
    }
}
