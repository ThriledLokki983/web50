package com.company;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addItem(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addItem(temp);

        temp = new StockItem("biscuit", 0.94, 25);
        stockList.addItem(temp);

        temp = new StockItem("eggs", 2.45, 98);
        stockList.addItem(temp);

        temp = new StockItem("yoghurt", 1.65, 245);
        stockList.addItem(temp);

        temp = new StockItem("avocado", 0.79, 58);
        stockList.addItem(temp);

        temp = new StockItem("apple", 0.76, 34);
        stockList.addItem(temp);

        temp = new StockItem("car", 12.50, 19);
        stockList.addItem(temp);

        temp = new StockItem("chair", 4.67, 19);
        stockList.addItem(temp);

        temp = new StockItem("juice", 3.50, 59);
        stockList.addItem(temp);

        temp = new StockItem("cake", 96.99, 86);
        stockList.addItem(temp);

        temp = new StockItem("towel", 8.56, 40);
        stockList.addItem(temp);

        System.out.println(stockList);
    }
}
