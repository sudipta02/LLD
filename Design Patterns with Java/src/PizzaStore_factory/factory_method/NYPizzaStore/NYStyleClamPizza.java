package PizzaStore_factory.factory_method.NYPizzaStore;

import PizzaStore_factory.factory_method.Pizza;

public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "White Garlic Sauce";

        toppings.add("Grated Parmesan Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }

}
