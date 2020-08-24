package design_patterns.creational.prototype;

import java.util.HashMap;
import java.util.Scanner;

public class PrototypeShape {
    public static void main(String[] args) {
        PrototypeManager pm=new PrototypeManager();
        Shape obj1=pm.getShape("Circle");
        obj1.printArea();
    }
}

interface Shape extends Cloneable {
    public Object clone();

    public void printArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle c = null;
        try {
            c = (Circle) super.clone();
        } catch (Exception e) {
            System.out.println("Clone Circle failed!");
        }
        return c;
    }

    @Override
    public void printArea() {
        int r = 0;
        System.out.println("Please input rad");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("Area = " + 3.14 * r * r);

    }
}

class Square implements Shape {
    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (Exception e) {
            System.out.println("Clone Square failed");
        }
        return square;
    }

    @Override
    public void printArea() {
        int a = 0;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("Area = " + a * a);

    }
}
class PrototypeManager{
    private HashMap<String,Shape> ht=new HashMap<String, Shape>();

    public PrototypeManager() {
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
    }
    public void addShape(String key,Shape shape){
        ht.put(key,shape);
    }
    public Shape getShape(String key){
        Shape shape=ht.get(key);
        return (Shape) shape.clone();
    }
}
