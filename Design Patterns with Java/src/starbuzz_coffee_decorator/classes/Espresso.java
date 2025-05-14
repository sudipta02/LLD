package starbuzz_coffee_decorator.classes;

import starbuzz_coffee_decorator.abstract_class.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        // description = "Espresso";
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
