package Module2_Patterns2.L1Exercise1;

import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;
import Module2_Patterns2.L1Exercise1.enums.Topping;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(Size size, Dough dough, List<Topping> toppings){
        this.size = size;
        this.dough = dough;
        this.toppings = toppings;
    }

    @Override
    public String toString(){
        return "Size: " + this.size + "\n"
                + "Dough: " + this.dough + "\n"
                + "Topping: " + this.toppings;
    }
}