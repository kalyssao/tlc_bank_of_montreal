public class Stocks extends Product {
    String ticker;
    String exchange;

    Stocks(String id, String ticker, String exchange, ProductPricingService pricingService){
        super(id);
        this.ticker = ticker;
        this.exchange = exchange;
        this.price = pricingService.price(exchange, ticker);
    }
}
