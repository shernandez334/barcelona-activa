package Module2_Patterns2.L2exercise1;

import java.util.Map;

public interface Observer {
    void update(Map stockExchange, String nameCompany, double value);
}