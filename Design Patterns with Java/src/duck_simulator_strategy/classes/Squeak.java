package duck_simulator_strategy.classes;

import duck_simulator_strategy.interfaces.QuackBehaviour;

public class Squeak implements QuackBehaviour{
    public void quack(){
        System.out.println("Squeak");
    }
}
