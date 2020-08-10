package Object;

import java.util.ArrayList;

public class Object {
    public String name;
    public ArrayList<Object> children;

    public Object() {
        name = "";
        children = new ArrayList<Object>();
    }
}
