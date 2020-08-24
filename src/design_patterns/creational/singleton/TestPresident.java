package design_patterns.creational.singleton;

public class TestPresident {
    public static void main(String[] args) {
        President p1=President.getInstance();
        President p2=President.getInstance();
        System.out.println(p1==p2);
        p1.printName();
    }
}

class President{
    private static volatile President instance=null;
    private President(){
        System.out.println("Election!!!");
    }

    public static synchronized President getInstance() {
        if(instance==null){
            instance=new President();
        }else{
            System.out.println("We already had a president");
        }
        return instance;
    }

    public void printName(){
        System.out.println("Trump");
    }
}