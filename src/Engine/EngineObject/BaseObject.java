package Engine.EngineObject;

import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;

public class BaseObject {
    public String name;
    public ArrayList<BaseObject> children;

    public BaseObject() {
        name = "";
        children = new ArrayList<BaseObject>();
    }
}
