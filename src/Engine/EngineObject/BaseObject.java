package Engine.EngineObject;

import java.util.ArrayList;

public class BaseObject {
    private String name;
    private ArrayList<BaseObject> children;

    public BaseObject() {
        name = "";
        children = new ArrayList<BaseObject>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BaseObject> getChildren() {
        return children;
    }

    public void addChildren(BaseObject children) {
        this.children.add(children);
    }

    protected void renderChildren() {
        for (BaseObject object : getChildren()) {
            if (object instanceof RawSpatialObject) {
                ((RawSpatialObject) object).render();
            } else if (object instanceof SpatialObject) {
                ((SpatialObject) object).render();
            }
        }
    }
}