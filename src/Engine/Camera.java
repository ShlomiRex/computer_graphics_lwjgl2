package Engine;

import Engine.EngineObject.SpatialObject;
import org.lwjgl.util.vector.Vector3f;

public class Camera extends SpatialObject  {

    public Vector3f position;
    public Vector3f direction;
    public Vector3f up; //Up vector

    public float move_speed;
    public float xz_angle, y_angle;

    public Camera() {
        position = new Vector3f(0, 0, 0);
        direction = new Vector3f(0, 0, -1);
        up = new Vector3f(0, 1, 0);

        move_speed = 0.01f;
        xz_angle = 0;
        y_angle = 0;
    }

    @Override
    public void render() {
        //We can render the camera in the scene as just a Box or Sphere or not render anything.
        //Remember, SpatialObject is just 3D object. Camera is 3D object that we can render. But we say 'render from camera' which is the view matrix. It's diffirent.
    }

    public void rotate_around_y(float angle) {
        xz_angle += angle;

        //Make angle between 0 and 360
        if (xz_angle < 0)
        {
            float iangle = -xz_angle; //negative sign, iangle is positive
            iangle = iangle / 360;
            xz_angle += 360 * iangle;
        }
        else if (xz_angle > 360)
        {
            float iangle = xz_angle; //positive sign, iangle is positive
            iangle = iangle / 360;
            xz_angle -= 360 * iangle;
        }

        //Unit circle X,Y
        double x_distance = Math.cos(Math.toRadians(xz_angle * Math.PI / 180));
        double y_distance = Math.sin(Math.toRadians(xz_angle * Math.PI / 180));

        //In unit circle, positive X is the 'base' axis. (from which angles are calculated)
        //But in camera coordinates, we look at negative Z, which we want to calculate angles on XZ plane from.
        //So our base axis is -z

        //camera.dir.x = disY;
        //camera.dir.z = -disX;

        //However, we calculated direction vector based on (0,0,0) eye pos.
        //So, we add to dir vector the pos vector.

        direction.x = (float) (y_distance + position.x);
        direction.z = (float) (-x_distance + position.z);
    }

    public void rotate_around_xz(float angle) {
        //TODO: Impliment or no impliment? That is the question.
    }

    private Vector3f getNormalizedForwardVector() {
        Vector3f forward = new Vector3f();
        forward.x = direction.x - position.x;
        forward.y = direction.y - position.y;
        forward.z = direction.z - position.z;

        Vector3f normalised_forward = new Vector3f();
        forward.normalise(normalised_forward);

        return normalised_forward;
    }

    public void moveForward() {
        Vector3f normalised_forward = getNormalizedForwardVector();

        //Move forward
        position.x += normalised_forward.x * move_speed;
        position.y += normalised_forward.y * move_speed;
        position.z += normalised_forward.z * move_speed;

        direction.x += normalised_forward.x * move_speed;
        direction.y += normalised_forward.y * move_speed;
        direction.z += normalised_forward.z * move_speed;
    }

    public void moveBackward() {
        Vector3f normalised_forward = getNormalizedForwardVector();

        position.x -= normalised_forward.x * move_speed;
        position.y -= normalised_forward.y * move_speed;
        position.z -= normalised_forward.z * move_speed;

        direction.x += normalised_forward.x * move_speed;
        direction.y += normalised_forward.y * move_speed;
        direction.z += normalised_forward.z * move_speed;
    }

    public void moveLeft() {
        Vector3f normalised_forward = getNormalizedForwardVector();
        Vector3f left = new Vector3f();
        Vector3f.cross(up, normalised_forward, left);

        position.x += left.x * move_speed;
        position.y += left.y * move_speed;
        position.z += left.z * move_speed;

        direction.x += left.x * move_speed;
        direction.y += left.y * move_speed;
        direction.z += left.z * move_speed;
    }

    public void moveRight() {
        Vector3f normalised_forward = getNormalizedForwardVector();
        Vector3f right = new Vector3f();
        Vector3f.cross(normalised_forward, up, right);

        position.x += right.x * move_speed;
        position.y += right.y * move_speed;
        position.z += right.z * move_speed;

        direction.x += right.x * move_speed;
        direction.y += right.y * move_speed;
        direction.z += right.z * move_speed;

    }

    public void moveUp() {
        position.y += move_speed;
        direction.y += move_speed;
    }

    public void moveDown() {
        position.y -= move_speed;
        direction.y -= move_speed;
    }
}
