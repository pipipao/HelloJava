package design_patterns.structural.facade;

public class TestAbstractFacade {
    public static void main(String[] args) {
        AbstractFacade f1=new FacadeA();
        AbstractFacade f2=new FacadeB();
        f1.method();
        f2.method();
    }
}
class SubA{
    public void method(){
        System.out.println("A");
    }
}
class SubB{
    public void method(){
        System.out.println("B");
    }
}
class SubC{
    public void method(){
        System.out.println("C");
    }
}
abstract class AbstractFacade{
    public abstract void method();
}
class FacadeA extends AbstractFacade{
    private SubA subA=new SubA();
    private SubB subB=new SubB();
    @Override
    public void method() {
        subA.method();
        subB.method();
    }
}
class FacadeB extends AbstractFacade{
    private SubB subB=new SubB();
    private SubC subC=new SubC();
    @Override
    public void method() {
        subB.method();
        subC.method();
    }
}