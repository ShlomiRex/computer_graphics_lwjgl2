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

        move_speed = 0.5f;
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

    public void moveForward() {
        Vector3f forward = new Vector3f();
        forward.x = direction.x - position.x;
        forward.y = direction.y - position.y;
        forward.z = direction.z - position.z;

        Vector3f normalised_forward = new Vector3f();
        forward.normalise(normalised_forward);

        //Move forward
        position.x += normalised_forward.x * move_speed;
        position.y += normalised_forward.y * move_speed;
        position.z += normalised_forward.z * move_speed;

        direction.x += normalised_forward.x * move_speed;
        direction.y += normalised_forward.y * move_speed;
        direction.z += normalised_forward.z * move_speed;
    }
}
