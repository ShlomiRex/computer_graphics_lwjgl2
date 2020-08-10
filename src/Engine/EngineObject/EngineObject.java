package Engine.EngineObject;

import java.util.ArrayList;

public class EngineObject {
    public String name;
    public ArrayList<EngineObject> children;

    public EngineObject() {
        name = "";
        children = new ArrayList<EngineObject>();
    }
}
