package _06_inheritance.execrises.circle_and_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        circle.setColor("Blue");

        System.out.println("Circle:"+circle);
        System.out.println("Area: "+circle.getArea());;
        //-------------------------------------
        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(9.9);
        cylinder.setRadius(3);
        cylinder.setColor("Red");
        System.out.println("-------------------------------------------");
        System.out.println("Cylinder:"+cylinder);
        System.out.println("Area:"+cylinder.getArea());
        System.out.println("Volume:"+cylinder.getVolume());

    }
}
