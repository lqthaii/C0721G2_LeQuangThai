package _20_behavioral_design_pattern.practice.observer;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
