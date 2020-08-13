package Engine.EngineObject;

public class Sphere extends RawSpatialObject {

    private static final String BALL_FILE_NAME = "./resources/model/ball.obj";

    public Sphere() {
        super(BALL_FILE_NAME);
    }
}
