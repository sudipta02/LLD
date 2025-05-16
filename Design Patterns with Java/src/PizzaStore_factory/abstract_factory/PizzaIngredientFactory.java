package PizzaStore_factory.abstract_factory;

import PizzaStore_factory.abstract_factory.ingredients.interfaces.Cheese;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Clams;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Dough;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Pepperoni;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Sauce;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
