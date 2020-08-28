package design_patterns.behavioral.command;

public class TestCommand {
    public static void main(String[] args) {
        ConcreteCommand cmd=new ConcreteCommand();
        Invoker invoker=new Invoker(cmd);
        invoker.call();
    }
}
interface Command{
    public void execute();
}
class Invoker{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command) {
        this.command = command;
    }
    public void call(){
        System.out.println("Invoker call cmd");
        command.execute();
    }
}
class ConcreteCommand implements Command{
    private Receiver receiver;
    public ConcreteCommand(){
        receiver=new Receiver();
    }
    @Override
    public void execute() {
        receiver.action();
    }
}
class Receiver{
    public void action(){
        System.out.println("Taking action");
    }
}