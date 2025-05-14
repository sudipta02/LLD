package starbuzz_coffee_decorator.classes;

import starbuzz_coffee_decorator.abstract_class.Beverage;
import starbuzz_coffee_decorator.abstract_class.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

}
