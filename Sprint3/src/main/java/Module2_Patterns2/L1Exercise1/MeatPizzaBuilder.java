package Module2_Patterns2.L1Exercise1;

import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;
import Module2_Patterns2.L1Exercise1.enums.Topping;

import java.util.ArrayList;
import java.util.List;

public class MeatPizzaBuilder implements PizzaBuilder{
    private Size size;
    private Dough dough;
    private List<Topping> toppings;

    public MeatPizzaBuilder(){
        this.toppings = new ArrayList<>();
    }

    @Override
    public PizzaBuilder setSize(Size size){
        this.size = size;
        return this;
    }

    @Override
    public PizzaBuilder setDough(Dough dough){
        this.dough = dough;
        return this;
    }

    @Override
    public Pizza build(){
        this.toppings.add(Topping.TOMATO);
        this.toppings.add(Topping.SAUSAGE);
        this.toppings.add(Topping.CHEESE);
        this.toppings.add(Topping.SAUSAGE);
        this.toppings.add(Topping.PEPPERONI);
        return new Pizza(size, dough, toppings);
    }
}
