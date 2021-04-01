package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/31/21
 * Time: 6:57 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;
    private int reserveItems;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.reserveItems = 0;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) this.price = price;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0 ) this.quantityStock = newQuantity;
    }

    public void reserveStock(int quantity){
        int reservedStock = this.reserveItems + quantity;
        if (reservedStock >= 0) this.reserveItems = quantity;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals(): ");
        if (obj == this) return true;
        if ((obj == null) || (obj.getClass() != this.getClass())) return false;
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.CompareTo(): ");
        if (this == o) return 0;
        if (o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + ": " + this.reserveItems;
    }
}
