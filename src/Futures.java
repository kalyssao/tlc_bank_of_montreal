public class Futures extends Product {
    String exchange;
    String contractCode;
    int month;
    int year;

    Futures(String id, String exchange, String contractCode, int month, int year,
            ProductPricingService pricingService){
        super(id);

        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
        this.price = pricingService.price(exchange, contractCode, month, year);
    }

}
