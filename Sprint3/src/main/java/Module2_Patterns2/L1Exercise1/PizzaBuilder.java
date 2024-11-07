package Module2_Patterns2.L1Exercise1;

import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;
import Module2_Patterns2.L1Exercise1.enums.Topping;

public interface PizzaBuilder {
    PizzaBuilder setSize(Size size);
    PizzaBuilder setDough(Dough dough);
    Pizza build();
}