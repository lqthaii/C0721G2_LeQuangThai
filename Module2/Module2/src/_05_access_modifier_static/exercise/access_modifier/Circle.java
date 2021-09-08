package _05_access_modifier_static.exercise.access_modifier;

public class Circle {
    private double radius =1.0;
    private String color ="red";
    public Circle(){}
    public Circle(double r){
        this.radius=r;
    }
    protected double getRadius(){
        return radius;
        }
    protected double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }
}

