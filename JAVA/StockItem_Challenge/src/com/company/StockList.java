package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 4/1/21
 * Time: 2:46 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class StockList {
    private final Map<String, StockItem> list;


    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public void addItem(StockItem item){
        if (item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item){
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(), item);
            item.availableQuantity();
        }
    }

    public void sellStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) {
            inStock.finalizeStock(quantity);
        }
    }

    public int reserveItem(String item, int quantity){
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)){
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unReservedStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)){
            return inStock.unReservedStock(quantity);
        }
        return 0;
    }


    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nStock List\n");
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s.append(stockItem);
            s.append(". There are ");
            s.append(stockItem.availableQuantity());
            s.append(" in stock. Value of items: \t");
            s.append(String.format("%.2f", itemValue)).append("\n");
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f",totalCost);
    }
}
