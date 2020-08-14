package Scene.Dog;


import Engine.EngineObject.SpatialObject;

public class Dog extends SpatialObject {

    public Head head;
    public Body body;

    public Dog() {
        super(null, "Dog Class");
        head = new Head(this);
        body = new Body(this);


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
