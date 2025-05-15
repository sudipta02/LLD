package PizzaStore_factory.factory_method.NYPizzaStore;

import PizzaStore_factory.factory_method.Pizza;
import PizzaStore_factory.factory_method.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        }

        return pizza;
    }

}
