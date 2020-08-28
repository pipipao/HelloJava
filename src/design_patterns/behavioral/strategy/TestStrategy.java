package design_patterns.behavioral.strategy;

public class TestStrategy {
    public static void main(String[] args) {
        Context context=new Context();
        Strategy strategy=new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.strategyMethod();
    }
}
interface Strategy{
    public void strategyMethod();
}
class ConcreteStrategyA implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("Strategy A method");
    }
}
class ConcreteStrategyB implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("Strategy B method");
    }
}
class Context{
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void strategyMethod(){
        strategy.strategyMethod();
    }
}