//package Scene;
//
//import Engine.EngineObject.RawModel;
//import Engine.EngineObject.SpatialObject;
//import org.lwjgl.util.vector.Vector3f;
//import org.lwjgl.util.vector.Vector4f;
//
//
//public class Room extends SpatialObject {
//
//    private float floorPositionBottomY = 0;
//    private float floorPositionTopY;
//    private float roomDepthFarPointZ;
//    private float roomRadius;
//
//
//    public Room(float wallHeight, float roomDepthClosePoint, float roomDepthFarPoint, float roomRadius) {
//        this.roomRadius = roomRadius;
//        this.floorPositionTopY = this.floorPositionBottomY + wallHeight;
//        this.roomDepthFarPointZ = roomDepthFarPoint;
//        float reflectance = 1;
//
//        SpatialObject leftWall = getSurface(
//                new Vector3f(-this.roomRadius, this.floorPositionTopY, roomDepthClosePoint),
//                new Vector3f(-this.roomRadius, this.floorPositionBottomY, roomDepthClosePoint),
//                new Vector3f(-this.roomRadius, this.floorPositionTopY, roomDepthFarPoint),
//                new Vector3f(-this.roomRadius, this.floorPositionBottomY, roomDepthFarPoint),
//                new Vector4f(0.7f, 0.3f, 0.1f, 1), reflectance
//        );
//        SpatialObject rightWall = getSurface(
//                new Vector3f(this.roomRadius, this.floorPositionTopY, roomDepthFarPoint),
//                new Vector3f(this.roomRadius, this.floorPositionBottomY, roomDepthFarPoint),
//                new Vector3f(this.roomRadius, this.floorPositionTopY, roomDepthClosePoint),
//                new Vector3f(this.roomRadius, this.floorPositionBottomY, roomDepthClosePoint),
//                new Vector4f(0.7f, 0.3f, 0.9f, 1), reflectance
//        );
//
//        SpatialObject backWall = getSurface(
//                new Vector3f(-this.roomRadius, this.floorPositionTopY, roomDepthFarPoint),
//                new Vector3f(-this.roomRadius, this.floorPositionBottomY, roomDepthFarPoint),
//                new Vector3f(this.roomRadius, this.floorPositionTopY, roomDepthFarPoint),
//                new Vector3f(this.roomRadius, this.floorPositionBottomY, roomDepthFarPoint),
//                new Vector4f(0f, 0.3f, 0.9f, 1), reflectance
//        );
//
////        try {
////            float floorReflectance = 0.5f;
////            Texture texture = new Texture("textures/floorTexture_64.jpg");
////            float floorPlacement = this.floorPositionBottomY;
////            ObjectInSpace floor = getSurface(
////                    new Vector3f(-this.roomRadius, floorPlacement, roomDepthClosePoint),
////                    new Vector3f(-this.roomRadius, floorPlacement, roomDepthFarPoint),
////                    new Vector3f(this.roomRadius, floorPlacement, roomDepthClosePoint),
////                    new Vector3f(this.roomRadius, floorPlacement, roomDepthFarPoint),
////                    texture, new float[]{0, 0, 0, 1, 1, 1, 1, 0}, floorReflectance
////            );
////            addObject(floor);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        //TODO: add thick floor
//        children.add(leftWall);
//        addObject(rightWall);
//        addObject(backWall);
//
//    }
//
//    public Room(float wallHeight, float roomDepthClosePoint, float roomDepthFarPoint) {
//        this(wallHeight, roomDepthClosePoint, roomDepthFarPoint, 2.0f);
//    }
//
//    public float getRoomDepthFarPointZ() {
//        return roomDepthFarPointZ;
//    }
//
//    public float getFloorPositionBottomY() {
//        return floorPositionBottomY;
//    }
//
//    public float getFloorPositionTopY() {
//        return floorPositionTopY;
//    }
//
//    public float getRoomRadius() {
//        return roomRadius;
//    }
//
//    private static Mesh getSurfaceMesh(Vector3f lt, Vector3f lb, Vector3f rt, Vector3f rb, float[] texture) {
//        float[] positions = new float[]{
//                lt.x, lt.y, lt.z,
//                lb.x, lb.y, lb.z,
//                rb.x, rb.y, rb.z,
//                rt.x, rt.y, rt.z,
//        };
//        int[] indices = new int[]{
//                0, 1, 3, 3, 1, 2
//        };
//        //Todo: Fix normals
//        float[] normals = new float[]{
//                0.0f, 0.0f, 1.0f
//        };
//        if (texture == null) {
//            texture = new float[]{1};
//        }
//
//        Mesh mesh = new Mesh(positions, texture, normals, indices);
//        return mesh;
//    }
//
//
//    private static SpatialObject getSurface(Vector3f lt, Vector3f lb, Vector3f rt, Vector3f rb, Vector4f color, float reflectance) {
//        RawModel wall = new RawModel();
//        wall.
//        Mesh mesh = getSurfaceMesh(lt, lb, rt, rb, null);
//        Material mat = new Material(color, reflectance);
//        mesh.setMaterial(mat);
//
//        ObjectInSpace surface = new ObjectInSpace(mesh);
//
//        return surface;
//    }
//
//    private static ObjectInSpace getSurface(Vector3f lt, Vector3f lb, Vector3f rt, Vector3f rb, Texture texture, float[] textureIndices, float reflectance) {
//        Mesh mesh = getSurfaceMesh(lt, lb, rt, rb, textureIndices);
//        Material mat = new Material(texture, reflectance);
//        mesh.setMaterial(mat);
//
//        ObjectInSpace surface = new ObjectInSpace(mesh);
//
//        return surface;
//    }
//
////    @Override
////    public void init(Window window) throws Exception {
////        super.init(window);
////        getSurfaces().stream().forEach(o -> objectInSpace.add(o));
////
////    }
////
////    @Override
////    public void input(Window window, MouseInput mouseInput) {
////
////    }
////
////    @Override
////    public void update(float interval, MouseInput mouseInput) {
////
////    }
////
////    @Override
////    public void render(Window window) {
////        renderer.render(window, camera, objectInSpace.toArray(new ObjectInSpace[]{}), ambientLight,
////                pointLightList, spotLightList, directionalLight);
////    }
////
////    @Override
////    public void cleanup() {
////        super.cleanup();
////        this.objectInSpace.forEach(o -> o.getMesh().cleanUp());
////    }
//}