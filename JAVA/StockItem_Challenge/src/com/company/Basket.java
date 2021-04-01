package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Name: Gideon Nimoh
 * Date: 4/1/21
 * Time: 2:44 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, null);
            int newQuantity = inBasket + quantity;
            if (newQuantity > 0){
                list.put(item, newQuantity);
                return quantity;
            }else if (newQuantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public int reserve(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int resBasket = list.getOrDefault(item, 0);
            list.put(item, resBasket + quantity);
            return resBasket;
        }
        return 0;
    }

    public void cleanBasket(){
        this.list.clear();
    }

    public Map<StockItem, Integer> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            s.append(item.getKey());
            s.append(". ");
            s.append(item.getValue());
            s.append(" purchased\n");
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: " + String.format("%.2f", totalCost);
    }
}
