package duck_simulator_strategy;

import duck_simulator_strategy.classes.Duck;
import duck_simulator_strategy.classes.FlyRocketPowered;
import duck_simulator_strategy.classes.MallardDuck;
import duck_simulator_strategy.classes.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehaviour(new FlyRocketPowered());
        model.performFly();
    }
    
}
