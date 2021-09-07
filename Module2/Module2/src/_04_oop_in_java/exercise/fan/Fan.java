package _04_oop_in_java.exercise.fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    //========================================

    private boolean on=true;
    private double radius=5;
    private String color="blue";
    private int speed;
    public Fan(){}
    public Fan(boolean on, double radius, String color){
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public boolean isOn() {
        return on;
    }
    public void setLow() {
        this.speed = SLOW;
    }
    public void setMedium() {
        this.speed = MEDIUM;
    }
    public void setFast() {
        this.speed = FAST;
    }
    public int getSpeed(){
        return speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if(on){
            return "Fan is turn on, radius = "+radius+" ,color: "+color+" ,Speed: "+speed;
        }
        else {
            return "Fan is turn off, radius = "+radius+" ,color: "+color+" ,Speed: "+speed+"";
        }
    }
}
