public class Stocks extends Product {
    String ticker;
    String exchange;

    Stocks(String id, String ticker, String exchange){
        super(id);
        this.ticker = ticker;
        this.exchange = exchange;
    }
}
