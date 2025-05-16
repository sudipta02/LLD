package PizzaStore_factory.abstract_factory;

import PizzaStore_factory.abstract_factory.ingredients.FreshClams;
import PizzaStore_factory.abstract_factory.ingredients.Garlic;
import PizzaStore_factory.abstract_factory.ingredients.MarinaraSauce;
import PizzaStore_factory.abstract_factory.ingredients.Mushroom;
import PizzaStore_factory.abstract_factory.ingredients.Onion;
import PizzaStore_factory.abstract_factory.ingredients.RedPepper;
import PizzaStore_factory.abstract_factory.ingredients.ReggianoCheese;
import PizzaStore_factory.abstract_factory.ingredients.SlicedPepperoni;
import PizzaStore_factory.abstract_factory.ingredients.ThinCrustDough;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Cheese;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Clams;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Dough;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Pepperoni;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Sauce;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
