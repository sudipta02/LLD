package starbuzz_coffee_decorator.classes;

import starbuzz_coffee_decorator.abstract_class.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        // description = "House Blend Coffee";
    }

    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
