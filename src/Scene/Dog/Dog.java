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

        position.y = 6f;


        //Scale entire dog.
        float s = 3f;
        scale.x *= s;
        scale.y *= s;
        scale.z *= s;
    }
}
