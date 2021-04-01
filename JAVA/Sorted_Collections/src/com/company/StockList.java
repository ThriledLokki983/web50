package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Name: Gideon Nimoh
 * Date: 3/31/21
 * Time: 7:52 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class StockList {
    private final Map<String, StockItem> list;


    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addItem(StockItem item){
        if (item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //StockItem inStock = list.get(item.getName());
            // check if quantity is already > 0
            if (inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public int reserveItem(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        int reservedItems = 0;
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)){
            inStock.reserveStock(quantity);
            return reservedItems;
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

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s.append(stockItem);
            s.append(". There are ");
            s.append(stockItem.quantityInStock());
            s.append(" in stock. Value of items: \t");
            s.append(String.format("%.2f", itemValue)).append("\n");
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f",totalCost);
    }
}
