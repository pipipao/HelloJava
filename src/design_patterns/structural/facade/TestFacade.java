package design_patterns.structural.facade;

public class TestFacade {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.method();
    }
}
class SubSystemA{
    public void methodA(){
        System.out.println("A");
    }
}
class SubSystemB{
    public void methodB(){
        System.out.println("B");
    }
}
class Facade{
    private SubSystemA subSystemA=new SubSystemA();
    private SubSystemB subSystemB=new SubSystemB();
    public void method(){
        subSystemA.methodA();
        subSystemB.methodB();
    }
}