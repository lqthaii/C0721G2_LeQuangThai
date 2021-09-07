package _04_oop_in_java.exercise.fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    //========================================
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public Fan(){}

    public boolean isOn() {
        return on;
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
            return "Fan{" +
                    "Fan is on"+
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
        else {
            return "Fan{" +
                    "Fan is off"+
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
