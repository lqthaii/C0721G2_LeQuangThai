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
                ", radius=" + this.getRadius() +
                ", color='" + this.getColor() + '\'' +
                '}';
    }
    public double getArea(){
        return 2*Math.PI*this.getRadius()*(this.getRadius()+this.height);
    }
    public double getVolume(){
        return Math.PI*Math.pow(this.getRadius(),2)*this.height;
    }
}
