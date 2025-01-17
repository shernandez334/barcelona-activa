package Module2_Patterns2.L2exercise1;

public class Main {
    public static void main(String[] args){
        BlackRock blackRock = new BlackRock();

        blackRock.registerAgency(new StockAgency("Stock Exchange of New York"));
        blackRock.registerAgency(new StockAgency("Stock Exchange of Barcelona"));
        blackRock.registerAgency(new StockAgency("Stock Exchange of Madrid"));

        blackRock.notifyStockAgency("Telefonica", -0.3);
        blackRock.notifyStockAgency("Santander", 0.3);
    }
}