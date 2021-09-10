package _07_abstract_class_and_interface.practice.animals;

public class Main {
    public static void main(String[] args) {
        Animal tiger = new Tiger();
        Animal chicken = new Chicken();
        System.out.println(tiger.makeSound());
        System.out.println(chicken.makeSound());;
        Fruit orange = new Orange();
        Fruit apple = new Apple();
        System.out.println(orange.howToEat());
        System.out.println(apple.howToEat());
    }
}
