package com.acadena.BlackFridayAnalyzer.store;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoreManagerTests {

    private StoreManager storeManager;
    private Product product;

    @Before
    public void setUp(){
        storeManager = new OculusStoreManager();

    }

    @Test
    public void testcheckProductPrice(){
        product = new Product("test");
        Price price = null;
        try {
            price = storeManager.checkProductPrice(product);
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
            storeManager.checkProductPrice(product);
        } catch (Exception e) {
            isError = true;
        }
        assertTrue(isError);
    }
}
