package com.hdsx.mq;


import com.hdsx.mq.sevice.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2017/1/4.
 */
public class ProductTest extends SpringJunitTest {

    @Autowired
    private Product product;

    @Test
    public void sendMessage() {
        String text = "阿弥陀佛么么哒";
        product.sendMessage(text);
    }
}
