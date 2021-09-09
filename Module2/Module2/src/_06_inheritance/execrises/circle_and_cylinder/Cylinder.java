package _06_inheritance.execrises.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){}
    public Cylinder(double height, double radius, String color){
        super();
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
    public double getArea(){
        return 2*PI*this.radius*(this.radius+this.height);
    }
    public double getVolume(){
        return PI*Math.pow(this.radius,2)*this.height;
    }
}
