package starbuzz_coffee_decorator.abstract_class;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;
    public abstract String getDescription();
}
