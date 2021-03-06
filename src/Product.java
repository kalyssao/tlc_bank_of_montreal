public abstract class Product {
    String productID;
    double price;

    Product(String productID){
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", price=" + price +
                '}';
    }
}
