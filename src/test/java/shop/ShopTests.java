package shop;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import com.acadena.BlackFridayAnalyzer.product.ProductImpl;
import com.acadena.BlackFridayAnalyzer.shop.OculusShop;
import com.acadena.BlackFridayAnalyzer.shop.Shop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTests {

    private Shop shop;
    private Product product;

    @Before
    public void setUp(){
        shop = new OculusShop();

    }

    @Test
    public void testcheckProductPrice(){
        product = new ProductImpl("test");
        Price price = null;
        try {
            price = shop.checkProductPrice(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert price != null;
        assertEquals(15.03, price.getPrice(), 0.0);
    }

    @Test
    public void productNotFound(){
        product = new ProductImpl("testException");
        boolean isError = false;
        try {
            shop.checkProductPrice(product);
        } catch (Exception e) {
            isError = true;
        }
        assertTrue(isError);
    }
}
