package Module2_Patterns2.L2exercise1;

public interface Observable {
    void registerAgency(StockAgency stockAgency);
    void notifyStockAgency(String nameCompany, double valueModifier);
}
