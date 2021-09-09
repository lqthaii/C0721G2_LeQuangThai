package _06_inheritance.execrises.point2d_and_point3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void getXYZ(float x, float y, float z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public float[] getXYZ(){
        float[] xyz = new float[3];
        xyz[0]=this.x;
        xyz[1]=this.y;
        xyz[2]=this.z;
        return xyz;
    }
    public String toString(){
        return "Point2D:(x: "+this.x+",y: "+y+",z:"+z +")";
    }
}
