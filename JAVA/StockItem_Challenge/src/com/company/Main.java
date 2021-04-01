package com.company;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addItem(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addItem(temp);

        temp = new StockItem("Biscuit", 0.94, 25);
        stockList.addItem(temp);

        temp = new StockItem("Eggs", 2.45, 98);
        stockList.addItem(temp);

        temp = new StockItem("Yoghurt", 1.65, 245);
        stockList.addItem(temp);

        temp = new StockItem("Avocado", 0.79, 58);
        stockList.addItem(temp);

        temp = new StockItem("Apple", 0.76, 34);
        stockList.addItem(temp);

        temp = new StockItem("Car", 12.50, 19);
        stockList.addItem(temp);

        temp = new StockItem("Chair", 4.67, 19);
        stockList.addItem(temp);

        temp = new StockItem("Juice", 3.50, 59);
        stockList.addItem(temp);

        temp = new StockItem("Cake", 1.10, 3);
        stockList.addItem(temp);

        temp = new StockItem("Towel", 8.56, 40);
        stockList.addItem(temp);

        temp = new StockItem("Vase", 5.78, 35);
        stockList.addItem(temp);

        temp = new StockItem("Vase", 5.78, 10);
        stockList.addItem(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()){
            System.out.println(s);
        }

        Basket gideonBasket = new Basket("Gideon");

        sellItem(gideonBasket, "Cake", 5);
        sellItem(gideonBasket, "Cake", 5);
        sellItem(gideonBasket, "Cake", 5);
        if(sellItem(gideonBasket, "Cake", 1) != 1) {
            System.out.println("Cake out of Stock");
        }
        System.out.println("=============================================");
        sellItem(gideonBasket, "Aeroplane", 2);
        sellItem(gideonBasket, "Juice", 5);
        sellItem(gideonBasket, "Chair", 4);
        System.out.println(gideonBasket);
        System.out.println("=============================================");

        Basket customer = new Basket("Customer");
        sellItem(customer, "Juice", 4);
        sellItem(customer, "Chair", 4);
        sellItem(customer, "Towel", 4);
        System.out.println(customer);

        removeItem(gideonBasket, "Cake", 4);
        removeItem(gideonBasket, "Cake", 1);
        removeItem(gideonBasket, "Juice", 2);
        removeItem(gideonBasket, "Chair", 2);
        System.out.println("Cake removed: " + removeItem(gideonBasket, "Cake", 3));
        System.out.println("=============================================");
        System.out.println(gideonBasket);

        removeItem(gideonBasket, "Juice", 2);
        removeItem(gideonBasket, "Juice", 2);
        removeItem(gideonBasket, "Chair", 3);
        removeItem(gideonBasket, "Chair", 3);
        System.out.println(gideonBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(customer);
        System.out.println(stockList);
        checkOut(customer);
        System.out.println(customer);
        System.out.println(stockList);

        StockItem car = stockList.Items().get("Car");
        if (car != null){
            car.adjustStock(200);
        }
        if (car != null){
            stockList.get("Car").adjustStock(-200);
        }

        System.out.println(stockList);
        checkOut(gideonBasket);
        System.out.println(gideonBasket);


    }

    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't  sell " + item);
        }
        if (stockList.reserveItem(item, quantity) != 0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't  sell " + item);
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unReservedStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.cleanBasket();
    }

/**
 *     public static int reserveItem(Basket basket, String item, int quantity){
 *         StockItem stockItem = stockList.get(item);
 *         if (stockItem == null){
 *             System.out.println(item + " unavailable");
 *         }
 *         if (stockList.reserveItem(item, quantity) != 0){
 *             basket.reserve(stockItem, quantity);
 *             return quantity;
 *         }
 *         return 0;
 *     }
**/

}
