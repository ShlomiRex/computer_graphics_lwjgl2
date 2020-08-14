package Test;

import Engine.EngineObject.SpatialObject;
import Engine.EngineObject.Sphere;
import org.junit.jupiter.api.Test;
import org.lwjgl.util.vector.Vector3f;

public class MainTest {

    @Test
    void testAbsolutePosition() {
        SpatialObject parent, child, child2;
        parent = new Sphere(null, "Parent Test");
        parent.position = new Vector3f(0, 1, 0);
        child = new Sphere(parent, "Child Test");
        child.position = new Vector3f(1, 0, 1);
        child2 = new Sphere(child, "Child of Child Test"); //Child of Child
        SpatialObject secondChildOfParent = new Sphere(parent, "Second Child of Parent");

        //Position should be: 1,0,1
        //Absolute position should be: 1,1,1
        assert child.position.equals(new Vector3f(1,0,1));
        assert child.getAbsoluteWorldPosition().equals(new Vector3f(1,1,1));


        //Position should be: 0, 0, 0
        //Absolute position should be: 1,1,1
        assert child2.position.equals(new Vector3f(0, 0,0));
        assert child2.getAbsoluteWorldPosition().equals(new Vector3f(1,1,1));

        secondChildOfParent.position.equals(new Vector3f());
        secondChildOfParent.getAbsoluteWorldPosition().equals(parent.position);

        secondChildOfParent.position.x = 100f;
        secondChildOfParent.position.y = -100f;

        secondChildOfParent.position.equals(new Vector3f(100f, -100f, 0f));
        secondChildOfParent.getAbsoluteWorldPosition().equals(new Vector3f(parent.position.x + 100f, parent.position.y - 100f, 0f));
    }
}
