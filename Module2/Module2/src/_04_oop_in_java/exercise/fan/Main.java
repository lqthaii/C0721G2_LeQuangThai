package _04_oop_in_java.exercise.fan;

public class Main {
    public static void main(String[] args) {

    Fan fan = new Fan(true,10,"yellow",Fan.MEDIUM);
    Fan fan2 = new Fan(false,5,"blue",Fan.FAST);
        System.out.println(fan.toString());;
        System.out.println(fan2.toString());;
    }
}
