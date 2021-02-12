import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradedProductsTest {


    @Test
    public static void testTotalValueOfDaysTradedProducts(){
        ProductPricingService mockPricingService = mock(ProductPricingService.class);
        when(mockPricingService.price("HKEX", "Z", 3, 1997)).thenReturn(600.0);
        when(mockPricingService.price("NYSE", "A")).thenReturn(400.0);

        TradedProducts tradedProducts = new TradedProducts();
        Stocks stocks1 = new Stocks("S001", "A", "NYSE", mockPricingService);
        Futures futures1 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);
        Futures futures2 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);

        try {
            tradedProducts.addNewProduct(stocks1);
            tradedProducts.addNewProduct(futures1);
            tradedProducts.addNewProduct(futures2);

        } catch (ProductAlreadyRegisteredException e){
            System.out.println(e);
        }

        Assert.assertEquals(92000.0, tradedProducts.totalValueOfDaysTradedProducts(), 0.01);

    }

    @Test
    public static void totalTradeQuantityForDay(){
        ProductPricingService mockPricingService = mock(ProductPricingService.class);
        when(mockPricingService.price("HKEX", "Z", 3, 1997)).thenReturn(600.0);
        when(mockPricingService.price("NYSE", "A")).thenReturn(400.0);

        TradedProducts tradedProducts = new TradedProducts();
        Stocks stocks1 = new Stocks("S001", "A", "NYSE", mockPricingService);
        Futures futures1 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);
        Futures futures2 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);

        try {
            tradedProducts.addNewProduct(stocks1);
            tradedProducts.addNewProduct(futures1);
            tradedProducts.addNewProduct(futures2);

        } catch (ProductAlreadyRegisteredException e){
            System.out.println(e);
        }

        Assert.assertEquals(170, tradedProducts.totalTradeQuantityForDay());

    }

    @Test (expected = ProductNotRegisteredException.class)
    public static void testTrade() throws ProductNotRegisteredException{
        ProductPricingService mockPricingService = mock(ProductPricingService.class);
        when(mockPricingService.price("HKEX", "Z", 3, 1997)).thenReturn(600.0);
        when(mockPricingService.price("NYSE", "A")).thenReturn(400.0);

        TradedProducts tradedProducts = new TradedProducts();
        Stocks stocks1 = new Stocks("S001", "A", "NYSE", mockPricingService);
        Stocks stocks2 = new Stocks("S001", "A", "NYSE", mockPricingService);
        Futures futures1 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);
        Futures futures2 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);

        try {
            tradedProducts.addNewProduct(stocks1);
            tradedProducts.addNewProduct(futures1);
            tradedProducts.addNewProduct(futures2);

        } catch (ProductAlreadyRegisteredException e){
            System.out.println(e);
        }

        tradedProducts.trade(stocks2, 30);


    }

    @Test
    public static void testAddNewProduct() {


    }
}
