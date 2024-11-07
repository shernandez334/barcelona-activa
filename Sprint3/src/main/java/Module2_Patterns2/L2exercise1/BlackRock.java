package Module2_Patterns2.L2exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlackRock implements Observable{
    List<StockAgency> stockAgencies = new ArrayList<>();
    Stocks stockExchangeMadrid = new Stocks();
    Map stocksMadrid = Stocks.stockExchange;

    @Override
    public void registerAgency(StockAgency stockAgency){
        this.stockAgencies.add(stockAgency);
    }

    @Override
    public void notifyStockAgency(String nameCompany, double valueModifier){
        stockExchangeMadrid.changeStockValue(nameCompany, valueModifier);
        for (StockAgency a: stockAgencies){
            a.update(stocksMadrid, nameCompany, valueModifier);
        }
    }
}
