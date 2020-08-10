package Scene.Dog;


import Engine.EngineObject.SpatialObject;

public class Dog extends SpatialObject {

    private Head head;
    private Body body;

    public Dog() {
        head = new Head();
        body = new Body();

        this.children.add(head);
        this.children.add(body);
    }

    @Override
    public void render() {

    }
}
