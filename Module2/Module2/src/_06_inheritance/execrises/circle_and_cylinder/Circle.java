package _06_inheritance.execrises.circle_and_cylinder;

public class Circle {
    protected double radius;
    protected String color;
    protected double area;
    public final static double PI = 3.14;


    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        this.area = Math.pow(this.radius,2)*Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = Math.pow(this.radius,2)*Math.PI;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static double getPI() {
        return PI;
    }

    public double getArea(){
        return area ;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
