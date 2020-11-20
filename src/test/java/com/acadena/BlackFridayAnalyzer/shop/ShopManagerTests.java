package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShopManagerTests {

    private ShopManager shopManager;
    private Product product;

    @Before
    public void setUp(){
        shopManager = new OculusShopManager();

    }

    @Test
    public void testcheckProductPrice(){
        product = new Product("test");
        Price price = null;
        try {
            price = shopManager.checkProductPrice(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert price != null;
        assertEquals(0.0, price.getPrice(), 0.0);
        assertEquals("€", price.getCurrency());
    }

    @Test
    public void productNotFound(){
        product = new Product("testException");
        boolean isError = false;
        try {
            shopManager.checkProductPrice(product);
        } catch (Exception e) {
            isError = true;
        }
        assertTrue(isError);
    }
}
