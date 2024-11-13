package Module2_Patterns2.L1Exercise1;

import Module2_Patterns2.L1Exercise1.enums.Dough;
import Module2_Patterns2.L1Exercise1.enums.Size;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Pizza hawaiianPizza = new PizzaMeister(new HawaiianPizzaBuilder())
                .preparePizza(Size.SMALL, Dough.CRUSTY);
        System.out.println("\nHawaiian Pizza: \n" + hawaiianPizza);

        Pizza meatPizza = new PizzaMeister(new MeatPizzaBuilder())
                .preparePizza(Size.LARGE, Dough.THIN);
        System.out.println("\nMeat Pizza: \n" + meatPizza);
    }
}