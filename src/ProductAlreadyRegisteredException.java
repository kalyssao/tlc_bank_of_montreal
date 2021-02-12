public class ProductAlreadyRegisteredException extends Exception {
    ProductAlreadyRegisteredException(String s){
        super("Product already registered!");
    }
}
