package com.monkmaze.ecommerce.utils;

import java.net.URI;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProductPriceHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
       
        URI uri = session.getUri();
        
        
        String[] pathSegments = uri.getPath().split("/");

        
        if (pathSegments.length < 3) {
            
            session.sendMessage(new TextMessage("{ \"error\": \"Invalid URI format.\" }"));
            return;
        }

        
        String productId = pathSegments[2];

        
        Double realTimePrice = getRealTimePriceForProduct(productId);

       
        String priceMessage = "{ \"product_id\": \"" + productId + "\", \"real_time_price\": " + realTimePrice + " }";

       
        session.sendMessage(new TextMessage(priceMessage));
    }

   
    private Double getRealTimePriceForProduct(String productId) {
       
        return Math.random() * 100; 
}
}
