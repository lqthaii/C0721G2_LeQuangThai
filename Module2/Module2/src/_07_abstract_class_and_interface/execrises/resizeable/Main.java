package _07_abstract_class_and_interface.execrises.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Square(6,8,"Blue",true);
        shapes[2] = new Rectangle(6.2,8);
        //After
        ((Circle)shapes[0]).resize(50);
        System.out.println(((Circle)shapes[0]));
        ((Square)shapes[1]).resize(50);
        System.out.println(((Square)shapes[1]));
        ((Rectangle)shapes[2]).resize(50);
        System.out.println(((Rectangle)shapes[2]));
        System.out.println("---------------------------------------------------");

        for(int i =0;i<shapes.length;i++){
            if((shapes[i]) instanceof Square){
                System.out.println(((Square)shapes[i]));
                ((Square)shapes[i]).howToColor();
            }
        }
    }
}
