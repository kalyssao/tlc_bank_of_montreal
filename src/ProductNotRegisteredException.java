public class ProductNotRegisteredException extends Exception {
    ProductNotRegisteredException(){
        super("Cannot proceed with trade - this product is not registered.");
    }
}
