package design_patterns.behavioral.observer;

import java.util.ArrayList;

public class TestObserver {
    public static void main(String[] args) {
        ConcreteSubject sub=new ConcreteSubject();
        ConcreteObserverA oa=new ConcreteObserverA();
        ConcreteObserverB ob=new ConcreteObserverB();
        sub.add(oa);
        sub.add(ob);
        sub.notifyObservers("CHANGE!!!");
    }
}
interface Observer{
    void response(String s);
}
class ConcreteObserverA implements Observer{
    @Override
    public void response(String s) {
        System.out.println("A catch "+s);
    }
}
class ConcreteObserverB implements Observer{
    @Override
    public void response(String s) {
        System.out.println("B catch "+s);
    }
}
abstract class Subject{
    protected ArrayList<Observer> observers=new ArrayList<Observer>();
    public void add(Observer observer){
        observers.add(observer);
    }
    public void remove(Observer observer){
        observers.remove(observer);
    }
    public abstract void notifyObservers(String s);
}
class ConcreteSubject extends Subject{
    @Override
    public void notifyObservers(String s) {
        for(Observer observer:observers){
            observer.response(s);
        }
    }
}