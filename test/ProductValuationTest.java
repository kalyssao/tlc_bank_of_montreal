import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductValuationTest {
    @Mock
    ProductPricingService mockPricingService = mock(ProductPricingService.class);

    @Test
    public void testStockValuation(){

        when(mockPricingService.price("NYSE", "A")).thenReturn(400.0);
        Stocks stocks1 = new Stocks("S001", "A", "NYSE", mockPricingService);

        Assert.assertEquals(400.0, stocks1.getPrice(), 0.01);

    }

    @Test
    public void testFuturesValuation(){

        when(mockPricingService.price("HKEX", "Z", 3, 1997)).thenReturn(600.0);
        Futures futures1 = new Futures("F001", "HKEX", "Z", 3, 1997, mockPricingService);

        Assert.assertEquals(600.0, futures1.getPrice(), 0.01);

    }

}
