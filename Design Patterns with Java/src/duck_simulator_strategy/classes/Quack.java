package duck_simulator_strategy.classes;

import duck_simulator_strategy.interfaces.QuackBehaviour;

public class Quack implements QuackBehaviour{
    public void quack(){
        System.out.println("Quack");
    }
}
