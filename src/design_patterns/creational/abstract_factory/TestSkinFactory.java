package design_patterns.creational.abstract_factory;

public class TestSkinFactory {
    public static void main(String[] args) {
        SkinFactory skinFactory=(SkinFactory)XMLUtil.getBean();
        Button button=skinFactory.createButton();
        button.display();
    }
}
interface Button{
    public void display();
}
class SpringButton implements Button{
    @Override
    public void display() {
        System.out.println("Spring button");
    }
}
class SummerButton implements Button{
    @Override
    public void display() {
        System.out.println("Summer button");
    }
}
interface TextField{
    public void display();
}
class SpringTextField implements TextField{
    @Override
    public void display() {
        System.out.println("Spring TextField");
    }
}
class SummerTextField implements TextField{
    @Override
    public void display() {
        System.out.println("Summer TextField");
    }
}
interface SkinFactory{
    public Button createButton();
    public TextField createTextField();
}
class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
}
class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}