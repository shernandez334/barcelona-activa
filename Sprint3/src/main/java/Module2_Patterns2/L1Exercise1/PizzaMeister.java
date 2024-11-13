package Module2_Patterns2.L1Exercise1;


import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;

public class PizzaMeister {

    private PizzaBuilder pizzaBuilder;

    public PizzaMeister(PizzaBuilder pizzaBuilder){
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza preparePizza(Size size, Dough dough){
        return pizzaBuilder
                .setSize(size)
                .setDough(dough)
                .build();
    }

}