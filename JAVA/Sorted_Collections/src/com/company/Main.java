package com.company;

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
        System.out.println(gideonBasket);
        System.out.println("=============================================");
        sellItem(gideonBasket, "Cake", 5);
        System.out.println(gideonBasket);
        System.out.println("=============================================");
        sellItem(gideonBasket, "Cake", 5);
        System.out.println(gideonBasket);
        System.out.println("=============================================");
        sellItem(gideonBasket, "Aeroplane", 2);
        System.out.println(gideonBasket);
        System.out.println("=============================================");
        sellItem(gideonBasket, "Juice", 5);
        System.out.println(gideonBasket);
        System.out.println("=============================================");
        sellItem(gideonBasket, "Chair", 4);
        System.out.println(gideonBasket);

        System.out.println("=============================================");

        System.out.println(stockList);

    }

    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't  sell " + item);
        }
        if (stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
