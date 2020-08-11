package Scene.Dog;

import Engine.EngineObject.SpatialObject;
import org.lwjgl.util.glu.Sphere;

public class Body extends Engine.EngineObject.Sphere {

    private Sphere body;

    public Body() {
        body = new Sphere();
    }

    @Override
    public void render() {
        body.draw(5, 10, 10);
    }
}
