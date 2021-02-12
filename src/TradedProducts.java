import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TradedProducts implements MontrealTradedProducts {
    Map<Product, Integer> tradeTracker = new HashMap<>();
    HashSet<Product> registeredProducts = new HashSet<>();


    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (registeredProducts.contains(product)) {
            throw new ProductAlreadyRegisteredException();
        } else {
            registeredProducts.add(product);
        }
    }

    public void trade(Product product, int quantity) throws ProductNotRegisteredException {
        if (registeredProducts.contains(product)){
            tradeTracker.put(product, quantity);
        } else {
            throw new ProductNotRegisteredException();
        }
    }

    public int totalTradeQuantityForDay(){
        int totalQuantity = tradeTracker.values().stream().reduce(0, Integer::sum);
        return totalQuantity;
    }

    public double totalValueOfDaysTradedProducts(){
        double totalValue = 0.0;

        for (Map.Entry<Product, Integer> entry : tradeTracker.entrySet()){
            totalValue = totalValue + (entry.getKey().price * entry.getValue());
        }
        return totalValue;
    }

}
