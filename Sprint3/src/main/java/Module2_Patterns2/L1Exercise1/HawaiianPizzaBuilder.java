package Module2_Patterns2.L1Exercise1;

import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;
import Module2_Patterns2.L1Exercise1.enums.Topping;

import java.util.ArrayList;
import java.util.List;

public class HawaiianPizzaBuilder implements PizzaBuilder{
    private Size size;
    private Dough dough;
    private List<Topping> toppings;

    public HawaiianPizzaBuilder(){
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
        this.toppings.add(Topping.PINEAPPLE);
        this.toppings.add(Topping.HAM);
        this.toppings.add(Topping.CHEESE);
        return new Pizza(size, dough, toppings);
    }
}