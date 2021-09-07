package _04_oop_in_java.exercise.fan;

public class Main {
    public static void main(String[] args) {
    Fan fan = new Fan(true,10,"yellow");
    fan.setFast();
    Fan fan2 = new Fan(false,5,"blue");
    fan2.setMedium();
        System.out.println(fan.toString());;
        System.out.println(fan2.toString());;
    }
}
