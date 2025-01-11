package duck_simulator_strategy.classes;

import duck_simulator_strategy.interfaces.FlyBehaviour;

public class FlyRocketPowered implements FlyBehaviour{
    public void fly(){
        System.out.println("I'm flying with a rocket!");
    }
}
