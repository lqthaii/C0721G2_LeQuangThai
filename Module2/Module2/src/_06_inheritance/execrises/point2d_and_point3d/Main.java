package _06_inheritance.execrises.point2d_and_point3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2d = new Point2D(3,5);
        float[] xy = point2d.getXY();
        for(float i : xy){
            System.out.println(i);
        }
        System.out.println(point2d);
        System.out.println("-----------------------------------");
        Point3D point3d = new Point3D(3,5,9);
        float[] xyz = point3d.getXYZ();
        for(float i : xyz){
            System.out.println(i);
        }
        System.out.println(point3d);
    }
}
