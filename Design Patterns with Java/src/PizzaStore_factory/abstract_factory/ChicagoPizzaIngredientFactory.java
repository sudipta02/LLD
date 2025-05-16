package PizzaStore_factory.abstract_factory;

import PizzaStore_factory.abstract_factory.ingredients.BlackOlives;
import PizzaStore_factory.abstract_factory.ingredients.Eggplant;
import PizzaStore_factory.abstract_factory.ingredients.FrozenClams;
import PizzaStore_factory.abstract_factory.ingredients.MozzarellaCheese;
import PizzaStore_factory.abstract_factory.ingredients.PlumTomatoSauce;
import PizzaStore_factory.abstract_factory.ingredients.SlicedPepperoni;
import PizzaStore_factory.abstract_factory.ingredients.Spinach;
import PizzaStore_factory.abstract_factory.ingredients.ThickCrustDough;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Cheese;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Clams;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Dough;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Pepperoni;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Sauce;
import PizzaStore_factory.abstract_factory.ingredients.interfaces.Veggies;

public class ChicagoPizzaIngredientFactory
		implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(),
				new Spinach(),
				new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
