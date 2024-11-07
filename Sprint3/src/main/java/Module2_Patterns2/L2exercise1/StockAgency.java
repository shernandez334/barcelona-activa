package Module2_Patterns2.L2exercise1;

import java.util.Map;

public class StockAgency implements Observer{
    private String name;

    public StockAgency(String name){
        this.name = name;
    }

    public void update(Map stockExchange, String nameCompany, double value){
        String netValue = (value > 0) ? " up " + value: " down " + value;
        System.out.println("The " + this.name + " has an update on the market.\n" +
                nameCompany + " value went" + netValue + " points.\n" +
                "The current value is: " + stockExchange.get(nameCompany) + "\n");
    }
}
