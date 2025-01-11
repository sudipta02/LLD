package duck_simulator_strategy.classes;

import duck_simulator_strategy.interfaces.FlyBehaviour;

public class FlyNoWay implements FlyBehaviour{
    public void fly(){
        System.out.println("I can't fly");
    }
}
