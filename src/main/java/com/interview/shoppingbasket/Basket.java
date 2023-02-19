package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        Map<String, BasketItem> consolidateMap = new LinkedHashMap<>();
        
        for (BasketItem basketItem : items) {
			if(consolidateMap.containsKey(basketItem.getProductCode())) {
				BasketItem itemToSumQuantity = consolidateMap.get(basketItem.getProductCode());
				itemToSumQuantity.setQuantity(itemToSumQuantity.getQuantity() + basketItem.getQuantity());
			} else {
				consolidateMap.put(basketItem.getProductCode(), basketItem);
			}
		}
        items = new ArrayList<BasketItem>(consolidateMap.values());
    }
}
