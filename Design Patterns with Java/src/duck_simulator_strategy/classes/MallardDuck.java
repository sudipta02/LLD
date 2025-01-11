package duck_simulator_strategy.classes;

public class MallardDuck  extends Duck{
    public MallardDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWIngs();
    }

    public void display(){
        System.out.println("I'm a real Mallard Duck");
    }
}
