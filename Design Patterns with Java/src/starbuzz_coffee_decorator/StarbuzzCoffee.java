package starbuzz_coffee_decorator;

import starbuzz_coffee_decorator.abstract_class.Beverage;
import starbuzz_coffee_decorator.classes.Espresso;
import starbuzz_coffee_decorator.classes.HouseBlend;
import starbuzz_coffee_decorator.classes.Mocha;
import starbuzz_coffee_decorator.classes.Whip;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        System.out.println();

        // Beverage beverage3 = new DarkRoast();
        // beverage3 = new Mocha(beverage3);
        // beverage3 = new Whip(beverage3);
        // System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
