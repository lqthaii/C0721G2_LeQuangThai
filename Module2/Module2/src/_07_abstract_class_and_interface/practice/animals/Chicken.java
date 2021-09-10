package _07_abstract_class_and_interface.practice.animals;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound(){
        return "Chicken: ò ó o";
    }

    @Override
    public String howToEat() {
        return null;
    }
}
