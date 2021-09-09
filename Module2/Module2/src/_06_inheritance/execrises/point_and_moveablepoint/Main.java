package _06_inheritance.execrises.point_and_moveablepoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(0,0);
        MoveablePoint moveablePoint = new MoveablePoint(0,0,1,1);
        System.out.println(point);
        moveablePoint.move();
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
