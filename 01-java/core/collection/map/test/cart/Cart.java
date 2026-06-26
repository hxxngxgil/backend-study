package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> cartMap = new HashMap<>();
    
    public void add(Product product, int addQuantity) {
        cartMap.put(product, cartMap.getOrDefault(product, 0) + addQuantity);
    }

    public void minus(Product product, int minusQuantity) {
        int newQuantity = cartMap.getOrDefault(product, 0) - minusQuantity;
        if (newQuantity <= 0) {
            cartMap.remove(product);
        } else {
            cartMap.put(product, newQuantity);
        }
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println("상품: " + entry.getKey() + ", 수량: " + entry.getValue());
        }
    }
}
