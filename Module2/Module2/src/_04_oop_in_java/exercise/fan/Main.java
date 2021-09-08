package _04_oop_in_java.exercise.fan;

public class Main {
    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
    Fan fan = new Fan(true,10,"yellow",MEDIUM);
    Fan fan2 = new Fan(false,5,"blue",FAST);
        System.out.println(fan.toString());;
        System.out.println(fan2.toString());;
    }
}
