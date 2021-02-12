public class Futures extends Product {
    String exchange;
    String contractCode;
    int month;
    int year;

    Futures(String id, String exchange, String contractCode, int month, int year){
        super(id);

        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

}
